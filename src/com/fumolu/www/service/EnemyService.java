package com.fumolu.www.service;

import com.fumolu.www.model.Enemy;
import com.fumolu.www.model.Place;
import com.fumolu.www.utils.RandomUtil;
import com.fumolu.www.utils.ScannerUtil;

public class EnemyService {

    /**
     * 选择敌人
     * @param place
     * @return
     */
    public static Enemy[] choiceEnemy(Place place) {
        // 1.从传入的场景place中拿到场景中有的敌人
        // 2.显示全部场景中的敌人
        Enemy[] enemies=place.getEnemys();
        for (int i = 0; i <enemies.length ; i++) {

        }
        return enemies;
    }
    public static int action(Enemy enemy) {
        return attack(enemy);
    }
    /**
     * 敌人普通攻击
     *
     * @param enemy
     *            对战中的敌人
     * @return 敌人普通攻击造成的伤害
     */
    private static int attack(Enemy enemy) {
        if (RandomUtil.isSuccess(enemy.getDodgeRate()))
            return enemy.getPhysicalAttack()*2;
        else
            return enemy.getPhysicalAttack();
    }
}
