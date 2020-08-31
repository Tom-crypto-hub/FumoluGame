package com.fumolu.www.utils;

import java.util.Random;

/**
 * @ClassName: RandomUtil
 * @Description: TODO
 * @author: 王靖
 * @createDate: 2020-08-28 16:36
 */
public class RandomUtil {

    public static Random random = new Random();

    // 是否山闪避成功或者暴击成功
    public static boolean isSuccess(int rate){
        int num = random.nextInt(100) + 1;
        return rate >= num;
    }

    //根据玩家随机敌人等级
    public static int getEnemyLevel(int playerLevel){
        // 获取随机数
        int flag = random.nextInt(100) + 1;
        // 敌人等级
        int enemylevel = 0;
        // 5%的概率遇到大于玩家等级4级、5级、6级的怪
        if(flag <= 5){
            enemylevel = playerLevel + 4 + random.nextInt(3);
        }else if(flag <= 15){ // 10%的概率遇到大于玩家等级3级
            enemylevel = playerLevel + 3;
        }else if(flag <= 45){// 30%的概率遇到和玩家等级相同或者大于玩家1-2级的怪
            enemylevel = playerLevel + random.nextInt(3);
        }else if(flag <= 85){// 40%的概率遇到比玩家等级小1-4级的怪
            if(playerLevel <= 4){
                enemylevel = random.nextInt(4) + 1;
            }
            else {
                enemylevel = playerLevel - random.nextInt(4) - 1;
            }
        }else if(flag <= 95){// 10%的概率遇到比玩家等级小5-6级的怪
            if(playerLevel <= 5){
                enemylevel = random.nextInt(3) + 1;
            }
            else {
                enemylevel = playerLevel - random.nextInt(2) - 4;
            }
        }else if(flag <= 100) {// 5%的概率遇到比玩家等级小7-9级的怪
            if(playerLevel <= 10){
                enemylevel = random.nextInt(3) + 1;
            }
            else {
                enemylevel = playerLevel - random.nextInt(3) - 6;
            }
        }

        return Math.max(enemylevel, 1);
    }
}
