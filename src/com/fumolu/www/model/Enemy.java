package com.fumolu.www.model;

import java.util.List;

public class Enemy extends Character {

    public Enemy(){}

    public Enemy(int ID, String characterName, int level, int exp, int maxExp, int money, int pyhsicalAttack, int magicAttack, int pyhsicalDefense, int magicDefense, int hp, int maxHp, int mana, int maxMana, int dodgeRate, int maxDodgeRate, int critRite, int maxCritRite, int speed, Profession profession, List<Skill> skills) {
        super(ID, characterName, level, exp, maxExp, money, pyhsicalAttack, magicAttack, pyhsicalDefense, magicDefense, hp, maxHp, mana, maxMana, dodgeRate, maxDodgeRate, critRite, maxCritRite, speed, profession, skills);
    }

}
