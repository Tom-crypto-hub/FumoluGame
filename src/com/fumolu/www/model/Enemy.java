package com.fumolu.www.model;

import java.util.List;

public class Enemy extends Character {
    private Profession profession;

    public Enemy(String characterName, int level, int exp, int money, int pyhsicalAttack, int magicAttack, int pyhsicalDefense, int magicDefense, int hp, int maxHp, int mana, int maxMana, int dodgeRate, int maxDodgeRate, int critRite, int maxCritRite, List<Skill> skills, int maxExp) {
        super(characterName, level, exp, money, pyhsicalAttack, magicAttack, pyhsicalDefense, magicDefense, hp, maxHp, mana, maxMana, dodgeRate, maxDodgeRate, critRite, maxCritRite, skills, maxExp);
    }


    // 根据等级去初始化角色信息
   public Enemy(String characterName, int level) {
       super(characterName,level);
       this.setMoney(level*200);
       this.setPyhsicalAttack(level*);
       this.setMagicAttack(level*100);
       this.setPyhsicalDefense(level*100);
       this.setHp(level*400);
       this.set(level*200);
       this.setMoney(level*200);
       this.setMoney(level*200);
       this.setMoney(level*200);
       this.setMoney(1+level*200);

   }
}
