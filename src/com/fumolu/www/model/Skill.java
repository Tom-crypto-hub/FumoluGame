package com.fumolu.www.model;

/**
 * 技能
 */
public class Skill {
    // ID
    private int ID;

    // 技能名
  private  String SkillName;

    // 学习所需金钱
  private  int skillMoney;

    // 技能攻击加成
  private  int attackAddition;

    // 技能描述
  private  String skillInstruction;

    // 释放消耗法力
  private  int mana;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSkillName() {
        return SkillName;
    }

    public void setSkillName(String skillName) {
        SkillName = skillName;
    }

    public int getSkillMoney() {
        return skillMoney;
    }

    public void setSkillMoney(int skillMoney) {
        this.skillMoney = skillMoney;
    }

    public int getAttackAddition() {
        return attackAddition;
    }

    public void setAttackAddition(int attackAddition) {
        this.attackAddition = attackAddition;
    }

    public String getSkillInstruction() {
        return skillInstruction;
    }

    public void setSkillInstruction(String skillInstruction) {
        this.skillInstruction = skillInstruction;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "ID=" + ID +
                ", SkillName='" + SkillName + '\'' +
                ", skillMoney=" + skillMoney +
                ", attackAddition=" + attackAddition +
                ", skillInstruction='" + skillInstruction + '\'' +
                ", mana=" + mana +
                '}';
    }
}
