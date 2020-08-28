package com.fumolu.www.model;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.ArrayList;
import java.util.List;

/**
 * 玩家
 */
public class Player extends Character {

    private int userID;
    // 账号
    private String username;

    // 密码
    private String password;

    public  Player(){}

    public Player(int userID, int ID, String characterName, int level, int exp, int maxExp, int money, int pyhsicalAttack, int magicAttack, int pyhsicalDefense, int magicDefense, int hp, int maxHp, int mana, int maxMana, int dodgeRate, int maxDodgeRate, int critRite, int maxCritRite, int speed, List<Skill> skills, String username, String password, Profession profession) {
        super(ID, characterName, level, exp, maxExp, money, pyhsicalAttack, magicAttack, pyhsicalDefense, magicDefense, hp, maxHp, mana, maxMana, dodgeRate, maxDodgeRate, critRite, maxCritRite, speed, profession, skills);
        this.userID = userID;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
