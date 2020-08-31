package com.fumolu.www.utils;

public class RoleUtils {
    //升级后提升最大经验值
    public static int ExpRole(int maxExp){
        return maxExp + maxExp / 2;
    }
}
