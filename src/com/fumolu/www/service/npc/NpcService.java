package com.fumolu.www.service.npc;

import com.fumolu.www.model.Player;

public interface NpcService {
    /**
    * 当玩家访问时打招呼并自我介绍
    */
    void welcome();

    /**
     * 对玩家提供相应的帮助
     *
     * @param player
     *            访问NPC的玩家
     */
    boolean helpPlayer(Player player);

}
