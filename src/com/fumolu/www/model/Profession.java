package com.fumolu.www.model;

import java.util.List;

/**
 * 职业
 */
public class Profession {
    // 职业名
  private  String professionName;

    // 魔法攻击成长
  private int physicalAttackGrow;

    // 魔法攻击成长
  private  int magicAttackGrow;

    // 物理防御力成长
  private  int physicalDefenseGrow;

    // 魔法防御力成长
    private  int magicDefenseGrow;

    // 血量成长
  private  int hpGrow;

    // 法力成长
  private  int manaGrow;

    // 职业可学技能
  private  List<Skill> skills;

    public Profession(String professionName, int physicalAttackGrow, int magicAttackGrow, int physicalDefenseGrow, int magicDefenseGrow, int hpGrow, int manaGrow, List<Skill> skills) {
        this.professionName = professionName;
        this.physicalAttackGrow = physicalAttackGrow;
        this.magicAttackGrow = magicAttackGrow;
        this.physicalDefenseGrow = physicalDefenseGrow;
        this.magicDefenseGrow = magicDefenseGrow;
        this.hpGrow = hpGrow;
        this.manaGrow = manaGrow;
        this.skills = skills;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    public int getPhysicalAttackGrow() {
        return physicalAttackGrow;
    }

    public void setPhysicalAttackGrow(int physicalAttackGrow) {
        this.physicalAttackGrow = physicalAttackGrow;
    }

    public int getMagicAttackGrow() {
        return magicAttackGrow;
    }

    public void setMagicAttackGrow(int magicAttackGrow) {
        this.magicAttackGrow = magicAttackGrow;
    }

    public int getPhysicalDefenseGrow() {
        return physicalDefenseGrow;
    }

    public void setPhysicalDefenseGrow(int physicalDefenseGrow) {
        this.physicalDefenseGrow = physicalDefenseGrow;
    }

    public int getMagicDefenseGrow() {
        return magicDefenseGrow;
    }

    public void setMagicDefenseGrow(int magicDefenseGrow) {
        this.magicDefenseGrow = magicDefenseGrow;
    }

    public int getHpGrow() {
        return hpGrow;
    }

    public void setHpGrow(int hpGrow) {
        this.hpGrow = hpGrow;
    }

    public int getManaGrow() {
        return manaGrow;
    }

    public void setManaGrow(int manaGrow) {
        this.manaGrow = manaGrow;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
}
