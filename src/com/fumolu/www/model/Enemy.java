package com.fumolu.www.model;

import java.util.List;

public class Enemy extends Character {



    public Enemy(String characterName, int level, int exp, int money, int pyhsicalAttack, int magicAttack, int pyhsicalDefense, int magicDefense, int hp, int maxHp, int mana, int maxMana, int dodgeRate, int maxDodgeRate, int critRite, int maxCritRite, List<Skill> skills) {
        super(characterName, level, exp, money, pyhsicalAttack, magicAttack, pyhsicalDefense, magicDefense, hp, maxHp, mana, maxMana, dodgeRate, maxDodgeRate, critRite, maxCritRite, skills);
    }

    // 根据等级去初始化角色信息
//    public Enemy(String characterName, int level){
//        super();
//    }
}
