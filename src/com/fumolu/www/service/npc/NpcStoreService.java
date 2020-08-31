package com.fumolu.www.service.npc;

import com.fumolu.www.dao.PlayerDao;
import com.fumolu.www.data.NpcData;
import com.fumolu.www.model.Player;
import com.fumolu.www.utils.RandomUtil;

/**
 * @ClassName: NpcStoreService
 * @Description: TODO
 * @author: 王靖
 * @createDate: 2020-08-28 16:44
 *
 * 包含商店npc的具有的方法
 */
public class NpcStoreService extends AbstractNpcService {

    /**
     * 构造方法，在实例化商店npc时生效
     */
    public NpcStoreService() {
        // 给从父类继承的npc对象进行赋值
        this.npc = NpcData.npcDoctor;

    }

    /**
     * 支付金币购买道具，增加玩家属性
     * @param player
     */
    @Override
    public boolean helpPlayer(Player player) {
        //判断玩家职业
        //支付500金币恢复500生命值和500法力值
        if (player.getMoney()<500){
            System.out.println("您的金币不足");
        }else if (player.getProfession().equals("剑士")){
            //玩家金币扣500
            player.setMoney(player.getMoney()-500);
            //玩家生命值上限加和法力值上限加100，物理攻击力加10，护甲和魔抗加10
            player.setMaxHp(player.getMaxHp()+100);
            player.setMaxMana(player.getMaxMana()+100);
            player.setPhysicalAttack(player.getPhysicalAttack()+10);
            player.setPhysicalDefense(player.getPhysicalDefense()+10);
            player.setMagicDefense(player.getMagicDefense()+10);
            System.out.println("购买成功！");
        }if (player.getProfession().equals("术士")){
            //玩家金币扣500
            player.setMoney(player.getMoney()-500);
            //玩家生命值上限加和法力值上限加100，魔法攻击力加10，护甲和魔抗加10
            player.setMaxHp(player.getMaxHp()+100);
            player.setMaxMana(player.getMaxMana()+100);
            player.setMagicAttack(player.getMagicAttack()+10);
            player.setMagicDefense(player.getMagicDefense()+10);
            player.setPhysicalDefense(player.getPhysicalDefense()+10);
            System.out.println("购买成功！");
        }
        return false;
    }

    /**
     * 使用物品
     * @param player
     * @param goodsIndex
     * @param name   如果使用了改名卡则需要传入新的姓名
     * @return
     */
    public Boolean helpPlayer(Player player, int goodsIndex, String name) {
        switch (goodsIndex) {
            case 1:
                // 大力丸
                return powerPills(player);
            case 2:// 健体丸
                return fitnessPills(player);
            case 3:// 七星散
                return sevenStars(player);
            case 4:// 改名卡
                return renameCard(player, name);
            case 5:// 雷神甲
                return thorA(player);
            case 6:
                return fumoblade(player);
            case 7:
                return lightBoots(player);
            case 8:
                return resurrection(player);
            default:
                return false;
        }
    }


    /**
     * 大力丸：根据职业永久增加30点物理攻击或法术攻击
     * @param player
     */
    public boolean powerPills(Player player){
        if(player.getMoney() >= 2000) {
            player.setMoney(player.getMoney() - 2000);
            if (player.getProfession().getProfessionName().equals("剑客")) {
                player.setPhysicalAttack(player.getPhysicalAttack() + 30);
            } else {
                player.setMagicAttack(player.getMagicAttack() + 30);
            }

            return new PlayerDao().update(player);
        }
        return false;
    }

    /**
     * 健体丸：全 永久增加15点 玩家的物理防御和法术防御
     * @param player
     */
    public boolean fitnessPills(Player player){
        if(player.getMoney() >= 2000) {
            player.setMoney(player.getMoney() - 2000);
            player.setPhysicalDefense(player.getPhysicalDefense() + 15);
            player.setMagicDefense(player.getMagicDefense() + 15);
            return new PlayerDao().update(player);
        }
        return false;
    }

    /**
     * 七星散：全 恢复玩家300点生命值和300点法力值
     * @param player
     */
    public boolean sevenStars(Player player){
        if(player.getMoney() >= 800) {
            player.setMoney(player.getMoney() - 800);
            player.setHp(Math.min(player.getMaxHp(), player.getHp() + 300));
            player.setMana(Math.min(player.getMaxMana(), player.getMana() + 300));
            return new PlayerDao().update(player);
        }
        return false;
    }

    /**
     * 改名卡：更改玩家姓名和头像（头像随机生成）
     * @param player
     */
    public boolean renameCard(Player player, String name){
        if(player.getMoney() >= 1000) {
            player.setMoney(player.getMoney() - 1000);
            // 设置新名字
            player.setCharacterName(name);
            // 更改头像id
            int imgID = player.getImg_id();
            while (imgID == player.getImg_id()) {
                imgID = RandomUtil.random.nextInt(11) + 1;
            }
            player.setImg_id(imgID);
            return new PlayerDao().update(player);
        }
        return false;
    }

    /**
     * 雷神甲：永久增加玩家生命上限200点和物理魔法防御各20点
     * @param player
     */
    public boolean thorA(Player player){
        if(player.getMoney() >= 8000) {
            player.setMoney(player.getMoney() - 8000);

            player.setMaxHp(player.getMaxHp() + 200);
            player.setHp(player.getHp() + 200);

            player.setPhysicalDefense(player.getPhysicalDefense() + 20);
            player.setMagicDefense(player.getMagicDefense() + 20);

            return new PlayerDao().update(player);
        }
        return false;
    }

    /**
     * 伏魔刃：永久增加玩家4%的暴击率，物理攻击和法术攻击各10点
     * @param player
     */
    public boolean fumoblade(Player player){
        if(player.getMoney() >= 8000) {
            player.setMoney(player.getMoney() - 8000);
            player.setCritRate(Math.min(player.getCritRate() + 4, player.getMaxCritRate()));

            player.setPhysicalAttack(player.getPhysicalAttack() + 10);
            player.setMagicAttack(player.getMagicAttack() + 10);

            return new PlayerDao().update(player);
        }
        return false;
    }

    /**
     * 轻灵靴：永久增加玩家4%的闪避率和1的速度值
     * @param player
     */
    public boolean lightBoots(Player player){
        if(player.getMoney() >= 8000) {
            player.setMoney(player.getMoney() - 8000);
            player.setDodgeRate(Math.min(player.getDodgeRate() + 4, player.getMaxDodgeRate()));

            player.setSpeed(Math.min(player.getSpeed() + 1, 35));

            return new PlayerDao().update(player);
        }
        return false;
    }

    /**
     * 复活甲：在战斗中死亡后购买，可以复活并脱离战场，复活后拥有最大生命值得60%和最大法力值的50%
     * @param player
     */
    public boolean resurrection(Player player){
        if(player.getMoney() >= 2000){
            player.setMoney(player.getMoney() - 2000);
            player.setHp((int)(player.getMaxHp() * 0.6));
            player.setMana(player.getMaxMana() / 2);

            return new PlayerDao().update(player);
        }
        return false;
    }


}
