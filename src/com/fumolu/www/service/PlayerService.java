package com.fumolu.www.service;

import com.fumolu.www.dao.PlayerDao;
import com.fumolu.www.dao.ProfessionDao;
import com.fumolu.www.data.FightStatus;
import com.fumolu.www.model.Enemy;
import com.fumolu.www.model.Player;
import com.fumolu.www.model.Profession;
import com.fumolu.www.model.Skill;
import com.fumolu.www.utils.ScannerUtil;
import com.sun.deploy.net.HttpRequest;
import com.fumolu.www.utils.RandomUtil;

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
    public static void fight(Player player, Enemy enemy, FightStatus status) {
        // 传入的是玩家的行为，使用的是
        // 普通攻击还是法术功击，还是防御，还是技能攻击，还是逃跑
        switch (status){
            case FIGHT_ERROR:
                break;
            case FIGHT_DEFENCE:
            case FIGHT_RUN_AWAY:
                break;
            case FIGHT_MAGIC_ATTACK:
                magicAttack(player);
                break;
            case FIGHT_SKILL_ATTACK:
                userSkill(player);
                break;
            case FIGHT_PYHSICAL_ATTACK:
                physicalAttack(player);
                break;
            case FIGHT_CURE:
                cure(player);


        }
        // 如果状态是ERROR的话直接退出

        // 玩家各种行为的处理以及攻击方是否暴击，被攻击方是否闪避


    }

    /**
     * 玩家对敌人进行普通物理攻击
     *
     * @param player
     *            参与战斗的玩家
     * @return 攻击产生的伤害
     */
    private static int physicalAttack(Player player) {

        if (RandomUtil.isSuccess(player.getDodgeRate()))
            return 0;
        else if (RandomUtil.isSuccess(player.getCritRate())){
            return player.getPhysicalAttack()*2;
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
        if (RandomUtil.isSuccess(player.getDodgeRate()))
            return 0;
        else if (RandomUtil.isSuccess(player.getCritRate())){
            return player.getMagicAttack()*2;
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
    private static void victory(Player player, Enemy enemy) {
        if (player.getMaxExp()-player.getExp() > enemy.getExp()){
            player.setExp(player.getExp()+ enemy.getExp());
            player.setMoney(player.getMoney() + enemy.getMoney());
        }
        if (player.getMaxExp()-player.getExp() <= enemy.getExp()){
            levelUp(player);
            player.setMoney(player.getMoney() + enemy.getMoney());

        }

    }
    /**
     * 玩家升级
     *
     * @param player
     *            要升级的玩家
     */
    private static void levelUp(Player player) {
        ProfessionDao professionDao = new ProfessionDao();
        Profession profession = professionDao.inquiry(player.getProfession().getID());
        player.setMaxExp(player.getMaxExp()*2);
        player.setHp(player.getHp() + profession.getHpGrow());
        player.setMagicAttack(player.getMagicAttack() + profession.getMagicAttackGrow());
        player.setPhysicalAttack(player.getPhysicalAttack() + profession.getPhysicalAttackGrow());
        player.setPhysicalDefense(player.getPhysicalDefense() + profession.getPhysicalDefenseGrow());
        player.setMagicDefense(player.getMagicDefense() + profession.getMagicDefenseGrow());
        player.setMana(player.getMana() + profession.getManaGrow());

    }

    /**
     * 玩家对敌人释放技能进行攻击
     *
     * @param player
     *            参与战斗的玩家
     * @return 技能产生的伤害
     */
    private static int userSkill(Player player) {
        Skill skill = new Skill();
        if (player.getCharacterName().equals("剑士")){
            player.setPhysicalAttack(player.getPhysicalAttack()+skill.getAttackAddition());
            return player.getPhysicalAttack();
        }
        else {
            player.setMagicAttack(player.getMagicAttack()+skill.getAttackAddition());
            return player.getMagicAttack();
        }

    }
    //防御
    private static int defence(Enemy enemy){
//        enemy.



        return 0;
    }
    //治疗
    private static void cure(Player player){
        player.setHp(player.getHp() + (player.getHp()/2));
        if (player.getHp() > player.getMaxHp())
            player.setHp(player.getMaxHp());
    }

}

