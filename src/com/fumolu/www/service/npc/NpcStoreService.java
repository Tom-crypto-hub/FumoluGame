package com.fumolu.www.service.npc;

import com.fumolu.www.data.NpcData;
import com.fumolu.www.model.Player;

/**
 * @ClassName: NpcStoreService
 * @Description: TODO
 * @author: 王靖
 * @createDate: 2020-08-28 16:44
 *
 * 包含商店npc的具有的方法
 */
public class NpcStoreService extends AbstractNpcService {

    /**
     * 构造方法，在实例化商店npc时生效
     */
    public NpcStoreService() {
        // 给从父类继承的npc对象进行赋值
        this.npc = NpcData.npcDoctor;

    }

    /**
     * 支付金币购买增加玩家属性或者增加法力值
     * @param player
     */
    @Override
    public void helpPlayer(Player player) {

    }
}
