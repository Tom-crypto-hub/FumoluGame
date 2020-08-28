package com.fumolu.www.service.npc;

import com.fumolu.www.data.NpcData;
import com.fumolu.www.model.Player;
import com.fumolu.www.utils.ScannerUtil;
/**
 * 包含回复导师npc的具有的方法
 */
public class NpcDoctorService extends AbstractNpcService {
    /**
     * 构造方法，在实例化医师npc时生效
     */
    public NpcDoctorService() {
        // 给从父类继承的npc对象进行赋值
        this.npc = NpcData.npcDoctor;

    }

    /**
     * 支付金币进行治疗，治疗恢复生命值
     * @param player
     */
    @Override
    public void helpPlayer(Player player) {

    }
}

