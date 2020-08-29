package com.fumolu.www.service.npc;

import com.fumolu.www.data.NpcData;
import com.fumolu.www.model.Character;
import com.fumolu.www.model.Player;

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
    public void helpPlayer(Player player) {
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

    }
}
