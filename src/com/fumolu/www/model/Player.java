package com.fumolu.www.model;



import java.util.ArrayList;
import java.util.List;

/**
 * 玩家
 */
public class Player extends Character {

    // 玩家ID
    private int userID;
    // 账号
    private String username;

    // 密码
    private String password;

    // 头像ID
    private int img_id;

    public  Player(){}

    public Player(int userID, int ID, String characterName, int level, int exp, int maxExp, int money, int pyhsicalAttack, int magicAttack, int pyhsicalDefense, int magicDefense, int hp, int maxHp, int mana, int maxMana, int dodgeRate, int maxDodgeRate, int critRite, int maxCritRite, int speed, List<Skill> skills, String username, String password, Profession profession, int img_id) {
        super(ID, characterName, level, exp, maxExp, money, pyhsicalAttack, magicAttack, pyhsicalDefense, magicDefense, hp, maxHp, mana, maxMana, dodgeRate, maxDodgeRate, critRite, maxCritRite, speed, profession, skills);
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.img_id = img_id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getImg_id() {
        return img_id;
    }

    public void setImg_id(int img_id) {
        this.img_id = img_id;
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
