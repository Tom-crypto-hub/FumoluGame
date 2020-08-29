package com.fumolu.www.utils;

public class RoleUtils {
    public static int ExpRole(int maxExp, int level){
        return maxExp + maxExp * (2<<level);
    }
}
