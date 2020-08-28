package com.fumolu.www.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 玩家
 */
public class Player extends Character {
    // 账号
    private String username;

    // 密码
    private String password;

    // 职业
    private Profession profession;



    public Player(String characterName, int level, int exp, int money, int pyhsicalAttack, int magicAttack, int pyhsicalDefense, int magicDefense, int hp, int maxHp, int mana, int maxMana, int dodgeRate, int maxDodgeRate, int critRite, int maxCritRite, List<Skill> skills, int maxExp, String username, String password, Profession profession) {
        super(characterName, level, exp, money, pyhsicalAttack, magicAttack, pyhsicalDefense, magicDefense, hp, maxHp, mana, maxMana, dodgeRate, maxDodgeRate, critRite, maxCritRite, skills, maxExp);
        this.username = username;
        this.password = password;
        this.profession = profession;
    }

// 根据等级去初始化角色信息
//    public Enemy(String characterName, int level){
////       super();
//    }

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

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }
}
