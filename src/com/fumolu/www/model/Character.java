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
    // ID属性
    private int ID;
    // 昵称
    private String characterName;

    // 等级
    private int level;

    // 经验
    private int exp;

    // 最大经验
    private int maxExp;

    // 金钱
    private int money;

    // 物理攻击力
    private int physicalAttack;

    // 魔法攻击
    private int magicAttack;

    // 物理防御力
    private int physicalDefense;

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
    private int critRate;

    // 暴击率
    private int maxCritRate;

    // 速度
    private int speed;

    // 成长
    private Profession profession;

    // 掌握技能
    private List<Skill> skills  = new ArrayList<>();

    public Character(){}

    public Character(int ID, String characterName, int level, int exp, int maxExp, int money, int physicalAttack, int magicAttack, int physicalDefense, int magicDefense, int hp, int maxHp, int mana, int maxMana, int dodgeRate, int maxDodgeRate, int critRite, int maxCritRite, int speed, Profession profession, List<Skill> skills) {
        this.ID = ID;
        this.characterName = characterName;
        this.level = level;
        this.exp = exp;
        this.maxExp = maxExp;
        this.money = money;
        this.physicalAttack = physicalAttack;
        this.magicAttack = magicAttack;
        this.physicalDefense = physicalDefense;
        this.magicDefense = magicDefense;
        this.hp = hp;
        this.maxHp = maxHp;
        this.mana = mana;
        this.maxMana = maxMana;
        this.dodgeRate = dodgeRate;
        this.maxDodgeRate = maxDodgeRate;
        this.critRate = critRite;
        this.maxCritRate = maxCritRite;
        this.speed = speed;
        this.profession = profession;
        this.skills = skills;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public int getMaxExp() {
        return maxExp;
    }

    public void setMaxExp(int maxExp) {
        this.maxExp = maxExp;
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

    public int getPhysicalAttack() {
        return physicalAttack;
    }

    public void setPhysicalAttack(int physicalAttack) {
        this.physicalAttack = physicalAttack;
    }

    public int getMagicAttack() {
        return magicAttack;
    }

    public void setMagicAttack(int magicAttack) {
        this.magicAttack = magicAttack;
    }

    public int getPhysicalDefense() {
        return physicalDefense;
    }

    public void setPhysicalDefense(int physicalDefense) {
        this.physicalDefense = physicalDefense;
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

    public int getCritRate() {
        return critRate;
    }

    public void setCritRate(int critRate) {
        this.critRate = critRate;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public int getMaxCritRate() {
        return maxCritRate;
    }

    public void setMaxCritRate(int maxCritRate) {
        this.maxCritRate = maxCritRate;
    }

    @Override
    public String toString() {
        return "Character{" +
                "ID=" + ID +
                ", characterName='" + characterName + '\'' +
                ", level=" + level +
                ", exp=" + exp +
                ", maxExp=" + maxExp +
                ", money=" + money +
                ", physicalAttack=" + physicalAttack +
                ", magicAttack=" + magicAttack +
                ", physicalDefense=" + physicalDefense +
                ", magicDefense=" + magicDefense +
                ", hp=" + hp +
                ", maxHp=" + maxHp +
                ", mana=" + mana +
                ", maxMana=" + maxMana +
                ", dodgeRate=" + dodgeRate +
                ", maxDodgeRate=" + maxDodgeRate +
                ", critRate=" + critRate +
                ", maxCritRate=" + maxCritRate +
                ", speed=" + speed +
                ", profession=" + profession.toString() +
                ", skills=" + skills +
                '}';
    }
}
