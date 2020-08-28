package com.fumolu.www.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Character
 * @Description: TODO
 * @author: 王靖
 * @createDate: 2020-08-28 16:10
 */
public class Character {
    // 昵称
    private String characterName;

    // 等级
    private int level;

    // 经验
    private int exp;
    //最大经验值
    private int maxExp;
    // 金钱
    private int money;

    // 物理攻击力
    private int pyhsicalAttack;

    // 魔法攻击
    private int magicAttack;

    // 物理防御力
    private int pyhsicalDefense;

    // 魔法防御
    private int magicDefense;

    // 当前血量
    private int hp;

    // 血量上限
    private  int maxHp;

    // 法力
    private int mana;

    // 法力上限
    private int maxMana;

    // 闪避率
    private int dodgeRate;

    // 最大闪避率
    private int maxDodgeRate;

    // 暴击率
    private int critRite;

    // 暴击率
    private int maxCritRite;

    // 掌握技能
    private List<Skill> skills  = new ArrayList<>();

    public Character(String characterName, int level) {
        this.characterName = characterName;
        this.level = level;
    }

    public Character(String characterName, int level, int exp, int money, int pyhsicalAttack, int magicAttack, int pyhsicalDefense, int magicDefense, int hp, int maxHp, int mana, int maxMana, int dodgeRate, int maxDodgeRate, int critRite, int maxCritRite, List<Skill> skills, int maxExp) {
        this.characterName = characterName;
        this.level = level;
        this.exp = exp;
        this.money = money;
        this.pyhsicalAttack = pyhsicalAttack;
        this.magicAttack = magicAttack;
        this.pyhsicalDefense = pyhsicalDefense;
        this.magicDefense = magicDefense;
        this.hp = hp;
        this.maxHp = maxHp;
        this.mana = mana;
        this.maxMana = maxMana;
        this.dodgeRate = dodgeRate;
        this.maxDodgeRate = maxDodgeRate;
        this.critRite = critRite;
        this.maxCritRite = maxCritRite;
        this.skills = skills;
        this.maxExp=maxExp;
    }

    public int getMaxExp() {
        return maxExp;
    }

    public void setMaxExp(int maxExp) {
        this.maxExp = maxExp;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public int getDodgeRate() {
        return dodgeRate;
    }

    public void setDodgeRate(int dodgeRate) {
        this.dodgeRate = dodgeRate;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public int getPyhsicalAttack() {
        return pyhsicalAttack;
    }

    public void setPyhsicalAttack(int pyhsicalAttack) {
        this.pyhsicalAttack = pyhsicalAttack;
    }

    public int getMagicAttack() {
        return magicAttack;
    }

    public void setMagicAttack(int magicAttack) {
        this.magicAttack = magicAttack;
    }

    public int getPyhsicalDefense() {
        return pyhsicalDefense;
    }

    public void setPyhsicalDefense(int pyhsicalDefense) {
        this.pyhsicalDefense = pyhsicalDefense;
    }

    public int getMagicDefense() {
        return magicDefense;
    }

    public void setMagicDefense(int magicDefense) {
        this.magicDefense = magicDefense;
    }

    public int getMaxDodgeRate() {
        return maxDodgeRate;
    }

    public void setMaxDodgeRate(int maxDodgeRate) {
        this.maxDodgeRate = maxDodgeRate;
    }

    public int getCritRite() {
        return critRite;
    }

    public void setCritRite(int critRite) {
        this.critRite = critRite;
    }

    public int getMaxCritRite() {
        return maxCritRite;
    }

    public void setMaxCritRite(int maxCritRite) {
        this.maxCritRite = maxCritRite;
    }

}
