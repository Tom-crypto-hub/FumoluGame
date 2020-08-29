package com.fumolu.www.model;
/**
 * 游戏内部非玩家操控的角色
 */
public class Npc {
    // npc的名字
  private  String npcName;

    // npc的对白
  private  String[] dialogue;

    public String getNpcName() {
        return npcName;
    }

    public void setNpcName(String npcName) {
        this.npcName = npcName;
    }

    public String[] getDialogue() {
        return dialogue;
    }

    public void setDialogue(String[] dialogue) {
        this.dialogue = dialogue;
    }
}
