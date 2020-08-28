package com.fumolu.www.service;

import com.fumolu.www.model.Enemy;
import com.fumolu.www.model.Player;
import com.fumolu.www.model.Skill;
import com.fumolu.www.utils.ScannerUtil;

import java.util.Scanner;

public class PlayerService {
    /**
     * 初始化玩家角色信息
     *
     * @return 返回实例化的player对象
     */
    public static Player initPlayer() {

        // 1.输出欢迎信息
        System.out.println("*****************************************");
        System.out.println("欢迎来到大型文字角色扮演游戏《伏魔录》");
        System.out.println("我该如何称呼您？");

        // 2.输出角色名


        // 3.调用构造函数初始化角色


        // 4.输出初始化结果信息


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
    public static void fight(Player player, Enemy enemy) {

        // 1.使用do-while循环，持续进行战斗，到有一方血量扣完为止

            // 2.玩家选择行为


            // 3.敌人生命值进行扣减


            // 4.对于敌人是否战败进行判断


    }
    /**
     * 玩家选择战斗中的行为,攻击或者释放技能
     *
     * @param player
     *            参与战斗的玩家
     * @return 对敌人造成伤害
     */
    private static int action(Player player) {

        // 输出可选行动
        System.out.println("当前回合，您可采取如下行动：");

       return 0;
    }
    /**
     * 玩家对敌人进行普通攻击
     *
     * @param player
     *            参与战斗的玩家
     * @return 攻击产生的伤害
     */
    private static int attack(Player player) {
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
