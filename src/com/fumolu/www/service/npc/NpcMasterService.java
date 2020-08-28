package com.fumolu.www.service.npc;

import com.fumolu.www.data.NpcData;
import com.fumolu.www.model.Player;
import com.fumolu.www.model.Skill;
import com.fumolu.www.utils.ScannerUtil;

import java.util.List;
/**
 * 包含技能导师npc具有的方法
 */
public class NpcMasterService extends AbstractNpcService {
    /**
     * 构造方法，在实例化技能导师npc时生效
     */
    public NpcMasterService() {

        // 给从父类继承的npc对象进行赋值
        this.npc = NpcData.npcMaster;

    }

    /**
     * 支付金币学习技能
     * @param player
     */
    @Override
    public void helpPlayer(Player player) {

    }
    }

