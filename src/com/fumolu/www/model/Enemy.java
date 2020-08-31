package com.fumolu.www.model;

import java.util.List;

public class Enemy extends Character {

    // 敌人ID
    private int enemy_id;

    public Enemy(){}

    public Enemy(int ID, String characterName, int level, int exp, int maxExp, int money, int pyhsicalAttack, int magicAttack, int pyhsicalDefense, int magicDefense, int hp, int maxHp, int mana, int maxMana, int dodgeRate, int maxDodgeRate, int critRite, int maxCritRite, int speed, Profession profession, List<Skill> skills, int enemy_id) {
        super(ID, characterName, level, exp, maxExp, money, pyhsicalAttack, magicAttack, pyhsicalDefense, magicDefense, hp, maxHp, mana, maxMana, dodgeRate, maxDodgeRate, critRite, maxCritRite, speed, profession, skills);
        this.enemy_id = enemy_id;
    }

    public int getEnemy_id() {
        return enemy_id;
    }

    public void setEnemy_id(int enemy_id) {
        this.enemy_id = enemy_id;
    }

    @Override
    public String toString() {
        return "Enemy{" +
                "enemy_id=" + enemy_id +
                '}';
    }
}
