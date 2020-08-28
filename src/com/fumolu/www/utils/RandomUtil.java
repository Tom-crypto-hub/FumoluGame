package com.fumolu.www.utils;

import java.util.Random;

/**
 * @ClassName: RandomUtil
 * @Description: TODO
 * @author: 王靖
 * @createDate: 2020-08-28 16:36
 */
public class RandomUtil {

    private static Random random = new Random();

    // 是否山闪避成功或者暴击成功
    public static boolean isSuccess(int rate){
        int num = random.nextInt(100) + 1;
        return rate >= num;
    }
}
