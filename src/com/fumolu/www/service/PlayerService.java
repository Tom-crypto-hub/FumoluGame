package com.fumolu.www.service;

import com.fumolu.www.dao.PlayerDao;
import com.fumolu.www.dao.ProfessionDao;
import com.fumolu.www.dao.SkillDao;
import com.fumolu.www.data.FightStatus;
import com.fumolu.www.model.Enemy;
import com.fumolu.www.model.Player;
import com.fumolu.www.model.Profession;
import com.fumolu.www.model.Skill;
import com.fumolu.www.utils.RoleUtils;
import com.fumolu.www.utils.ScannerUtil;
import com.sun.deploy.net.HttpRequest;
import com.fumolu.www.utils.RandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerService {
    private static PlayerDao playerDao = new PlayerDao();
    private static ProfessionDao professionDao = new ProfessionDao();

    // 登陆的一个逻辑，通过实例化一个PlayerDao
    // 去查询用户名是否存在，用户名和密码是否正确
    public static Player login(String username, String password) {
        PlayerDao playerDao = new PlayerDao();
        //查询用户是否存在，不存在返回false
        Player player = playerDao.inquiry(username);
        if (player == null) {
            return null;
            //判断密码是否匹配，匹配返回true，否则false
        } else if (player.getPassword().equals(password)) {
            return player;
        } else {
            return null;
        }
    }

    public static List<Skill> getSkills(int playerID){
        return playerDao.inquiry(playerID);
    }

    // 注册的一个逻辑，通过实例化PlayerDao 去判断
    // 账号是否已经存在，添加是否成功
    public static boolean register(String username, String password, int img_id) {
        // 查询用户名是否重复，重复返回false，不重复做用户信息插入
        Player p = playerDao.inquiry(username);
        System.out.println("player is null? + " + (p == null));
        if (p==null){
            // 插入到character表中一条空的数据
            playerDao.insert(username);
            // 获取到插入之后的一个id
            int id = playerDao.inquiryCharacterID(username);
            System.out.println("玩家数据信息ID：" + id);
            // 初始化用户数据
            Player player = new Player();
            player.setID(id);
            player.setUsername(username);
            player.setPassword(password);
            Profession profession = new Profession();
            profession.setID(0);
            player.setProfession(profession);
            player.setImg_id(img_id);
            //插入用户信息
            playerDao.insert(player);
            return true;
        }else {
            return false;
        }
        // 通过ProfessionDao 插入player 的基础属性
    }

    /**
     * 初始化玩家角色信息
     * 通过玩家id去获取玩家剑士或者术士的一个初始化属性值
     * 修改玩家信息
     *
     * @return 返回实例化的player对象
     */
    public static Player initPlayer(String username, int professionId) {
        // 1.传入的是玩家id，实例化PlayerDao 去查询玩家信息。
//        初始化player父类的所有属性
        Player player = playerDao.inquiry(username);
        player.getProfession().setID(professionId);
        // 设置两种职业的相同属性值
        player.setCharacterName(username);
        player.setLevel(1);
        player.setExp(0);
        player.setMaxExp(200);
        player.setMoney(1000);
        //两种职业的不同属性值
        if(professionId == 0){
            // 指代剑客
            player.setPhysicalAttack(100);
            player.setPhysicalDefense(50);
            player.setMagicAttack(20);
            player.setMagicDefense(40);
            player.setMaxHp(400);
            player.setHp(player.getMaxHp());//初始生命值等于最大生命值
            player.setMaxMana(30);
            player.setMana(player.getMaxMana());//初始蓝量等于最大蓝量
            player.setDodgeRate(20);
            player.setMaxDodgeRate(60);
            player.setCritRate(20);
            player.setMaxCritRate(60);
            player.setSpeed(20);
        }
        else if(professionId == 1){
            // 指代术士
            player.setPhysicalAttack(20);
            player.setPhysicalDefense(20);
            player.setMagicAttack(200);
            player.setMagicDefense(20);
            player.setMaxHp(300);
            player.setHp(player.getMaxHp());//初始生命值等于最大生命值
            player.setMaxMana(80);
            player.setMana(player.getMaxMana());//初始蓝量等于最大蓝量
            player.setDodgeRate(10);
            player.setMaxDodgeRate(50);
            player.setCritRate(30);
            player.setMaxCritRate(80);
            player.setSpeed(15);
        }
        // 设置玩家的职业属性
        player.setProfession(professionDao.inquiry(player.getProfession().getID()));
        // 更改信息
        playerDao.update(player);
        // 重新读取玩家信息
        player = playerDao.inquiry(player.getUsername());
        // 4.返回玩家信息
        return player;
    }

    /**
     * 玩家跟敌人战斗
     *
     * @param player
     *            参与战斗的玩家
     * @param enemy
     *            挑战的敌人
     */
    public static String fight(Player player, Enemy enemy, FightStatus status, String skillName) {
        // 传入的是玩家的行为，使用的是
        // 普通攻击还是法术功击，还是防御，还是技能攻击，还是逃跑
        int hert = 0;
        String result = "";
        int temp = 0;
        switch (status){
            case FIGHT_ERROR:
            case FIGHT_DEFENCE:
                return "";
            case FIGHT_RUN_AWAY:
                int money = RandomUtil.random.nextInt(100) - 50;
                player.setMoney(player.getMoney() - money);
                return "玩家逃跑了，掉落了金币：" + money;
            case FIGHT_MAGIC_ATTACK:
                temp = magicAttack(player);
                hert = temp - enemy.getMagicDefense();
                if (hert < 0 ) hert = 1;
                if(RandomUtil.isSuccess(enemy.getDodgeRate())){
                    return "敌人闪避了玩家的法术攻击";
                }
                if(temp > player.getPhysicalAttack()) result += "暴击：";
                enemy.setHp(Math.max(enemy.getHp() - hert, 0));
                return result + "玩家使用法术攻击对敌人造成了" + hert + "点伤害值";

            case FIGHT_SKILL_ATTACK:
                hert = userSkill(player, skillName);
                if(hert == -1){
                    return "玩家想释放技能《" + skillName + "》，但是法力值不足，行动失败";
                }
                hert -=  - enemy.getMagicDefense() - enemy.getPhysicalDefense();
                if(hert < 0) hert = 1;

                if(hert > 0 && skillName.equals("春风吹又生")){
                    int HP = Math.min(player.getMaxHp(), player.getHp() + hert);
                    return "玩家释放技能《吹风吹又生》为自己恢复了" + HP + "点生命值";
                }
                if(RandomUtil.isSuccess(enemy.getDodgeRate())){
                    return "敌人闪避了玩家的技能攻击";
                }
                // 判断是否特殊回血技能
                if(hert >= 0 && skillName.equals("嗜狼印")){
                    int HP = Math.min(player.getMaxHp(), player.getHp() + (int)(hert * 0.5));
                    player.setHp(HP);
                    result += "玩家恢复了" + HP + "血量，";
                }
                enemy.setHp(Math.max(enemy.getHp() - hert, 0));
                return "玩家使用技能：" + skillName + "对敌人造成了" + hert + "点伤害值";

            case FIGHT_PYHSICAL_ATTACK:
                temp = physicalAttack(player);
                hert = temp - enemy.getPhysicalDefense();
                if (hert < 0 ) hert = 1;
                if(RandomUtil.isSuccess(enemy.getDodgeRate())){
                    return "敌人闪避了玩家的物理攻击";
                }
                if(temp > player.getPhysicalAttack()) result += "暴击：";
                enemy.setHp(Math.max(enemy.getHp() - hert, 0));
                return result + "玩家使用物理攻击对敌人造成了" + hert + "点伤害值";
        }
        return "";
    }

    /**
     * 玩家对敌人进行普通物理攻击
     *
     * @param player
     *            参与战斗的玩家
     * @return 攻击产生的伤害
     */
    private static int physicalAttack(Player player) {

//        if (RandomUtil.isSuccess(player.getDodgeRate()))
//            return 0;
        // 判断玩家的攻击是否产生了暴击
        if (RandomUtil.isSuccess(player.getCritRate())){
            return (int)(player.getPhysicalAttack()*1.5);
        }else
            return player.getPhysicalAttack();

    }

    /**
     * 玩家对敌人进行普通法术攻击
     *
     * @param player
     *            参与战斗的玩家
     * @return 攻击产生的伤害
     */
    private static int magicAttack(Player player) {
//        // 判断玩家是否闪避
//        if (RandomUtil.isSuccess(player.getDodgeRate()))
//            return 0;
        // 判断玩家是否造成了暴击
        if (RandomUtil.isSuccess(player.getCritRate())){
            return (int)(player.getMagicAttack() * 1.5);
        }else
            return player.getMagicAttack();
    }

    /**
     * 战斗胜利后玩家获得金钱奖励，以及经验
     * 升级玩家可以提升属性
     *
     * @param player
     *            战斗胜利的玩家
     * @param enemy
     *            被击败的敌人
     */
    public static boolean victory(Player player, Enemy enemy) {
        // 获得金币
        player.setMoney(player.getMoney() + enemy.getMoney());
        // 玩家获得经验值
        player.setExp(player.getExp() + enemy.getExp());
        // 判断玩家经验值是否超过最大经验，超过则升级
        while (player.getMaxExp() <= player.getExp()){
            levelUp(player);
        }
        // 更新玩家数据
        return new PlayerDao().update(player);
    }

    /**
     * 战斗失败后玩家将损失金币，损失值为怪物身上的金币的50%，和怪物经验值的30%
     *
     * @param player
     *            战斗失败的玩家
     * @param enemy
     *            胜利的的敌人
     */
    public static boolean fail(Player player, Enemy enemy) {
        // 损失金币
        player.setMoney(player.getMoney() - (int)(enemy.getMoney() * 0.5));
        // 损失怪物经验的30%
        player.setExp(player.getExp() - (int) (enemy.getExp() * 0.3));
        // 更新玩家数据
        return new PlayerDao().update(player);
    }

    /**
     * 玩家升级
     *
     * @param player
     *            要升级的玩家
     */
    private static void levelUp(Player player) {
        Profession profession = player.getProfession();
        System.out.println(profession.toString());
        player.setMaxExp(RoleUtils.ExpRole(player.getMaxExp()));
        // 等级+1
        player.setLevel(player.getLevel() + 1);
        // 当等级升到20级的时候拥有一个独有技能
        if(player.getLevel() == 20) {
            List<Skill> skills = player.getSkills();
            Skill newSkill = null;
            if (player.getProfession().getProfessionName().equals("剑客")) {
                newSkill = new SkillDao().inquirySkill(4);
            } else {
                newSkill = new SkillDao().inquirySkill(2);
            }
            skills.add(newSkill);
            player.setSkills(skills);
        }
        // 设置最大属性值得增加
        player.setMaxHp(player.getMaxHp() + profession.getHpGrow());
        player.setMagicAttack(player.getMagicAttack() + profession.getMagicAttackGrow());
        player.setPhysicalAttack(player.getPhysicalAttack() + profession.getPhysicalAttackGrow());
        player.setPhysicalDefense(player.getPhysicalDefense() + profession.getPhysicalDefenseGrow());
        player.setMagicDefense(player.getMagicDefense() + profession.getMagicDefenseGrow());
        player.setMaxMana(player.getMaxMana() + profession.getManaGrow());
    }

    /**
     * 玩家对敌人释放技能进行攻击
     *
     * @param player
     *            参与战斗的玩家
     * @return 技能产生的伤害
     */
    private static int userSkill(Player player, String skillName) {
        // 获取玩家拥有的技能
        List<Skill> list = player.getSkills();
        for(int i = 0; i < list.size(); i++){
            if(skillName.equals(list.get(i).getSkillName()) ){
                if(player.getMana() >= list.get(i).getMana()) {
                    // 玩家消耗法力值
                    player.setMana(player.getMana() - list.get(i).getMana());
                    // 获取玩家的职业，返回攻击值
                    if (player.getProfession().getProfessionName().equals("剑客")) {
                        return player.getPhysicalAttack() * list.get(i).getAttackAddition();
                    } else {
                        return player.getMagicAttack() * list.get(i).getAttackAddition();
                    }
                }else {
                    // 玩家法力值不足
                    return -1;
                }
            }
        }
        // 没有找到该技能
        return -2;
    }

}

