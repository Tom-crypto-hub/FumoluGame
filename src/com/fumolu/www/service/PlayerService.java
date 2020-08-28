package com.fumolu.www.service;

import com.fumolu.www.data.FightStatus;
import com.fumolu.www.model.Enemy;
import com.fumolu.www.model.Player;
import com.fumolu.www.model.Skill;
import com.fumolu.www.utils.ScannerUtil;

import java.util.Scanner;

public class PlayerService {
    // 登陆的一个逻辑，通过实例化一个PlayerDao
    // 去查询用户名是否存在，用户名和密码是否正确
    public static boolean login(String username, String password){
        return false;
    }

    // 注册的一个逻辑，通过实例化PlayerDao 去判断
    // 账号是否已经存在，添加是否成功
    public static boolean registe(String username, String password){
        return false;
    }

    //


    /**
     * 初始化玩家角色信息
     * 通过玩家id去数据库获取玩家信息，以及刚刚注册的初始化
     *
     * @return 返回实例化的player对象
     */
    public static Player initPlayer(int id) {

        // 1.传入的是玩家id，实例化PlayerDao 去查询玩家信息。

        // 2.输出初始化结果信息

        // 3.返回玩家信息

        return null;
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

        // 如果状态是ERROR的话直接退出

        // 玩家各种行为的处理以及攻击方是否暴击，被攻击方是否闪避


    }
    /**
     * 玩家选择战斗中的行为,攻击或者释放技能
     *
     * @param player
     *            参与战斗的玩家
     * @return 对敌人造成伤害
     */
    private static int action(Player player) {

        // 处理玩家攻击造成的伤害，并返回

       return 0;
    }
    /**
     * 玩家对敌人进行普通物理攻击
     *
     * @param player
     *            参与战斗的玩家
     * @return 攻击产生的伤害
     */
    private static int physicalAttack(Player player) {
        return 0;
    }

    /**
     * 玩家对敌人进行普通法术攻击
     *
     * @param player
     *            参与战斗的玩家
     * @return 攻击产生的伤害
     */
    private static int magicAttack(Player player) {
        return 0;
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


    }
    /**
     * 玩家升级
     *
     * @param player
     *            要升级的玩家
     */
    private static void levelUp(Player player) {


    }

    /**
     * 玩家对敌人释放技能进行攻击
     *
     * @param player
     *            参与战斗的玩家
     * @return 技能产生的伤害
     */
    private static int userSkill(Player player) {

      return 0;
    }

}
