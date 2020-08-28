package com.fumolu.www.data;

import com.fumolu.www.model.Npc;

public class NpcData {
    /**
     * 医师Npc静态实例
     */
    public static Npc npcDoctor = new Npc();

    /**
     * 技能导师Npc静态实例
     */
    public static Npc npcMaster = new Npc();

    static {

        // 为医师Npc静态实例属性赋值
        npcDoctor.setNpcName("华医师");
//        npcDoctor.setDialogue("一手交钱，一手救命。");

        // 为技能导师Npc静态实例属性赋值
        npcMaster.setNpcName("路边大师");
//        npcMaster.setDialogue("小朋友，我看你天赋异禀、骨骼惊奇，想来是百年难得一见的练武奇才！");

    }
}
