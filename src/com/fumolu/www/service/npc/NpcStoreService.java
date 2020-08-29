package com.fumolu.www.service.npc;

import com.fumolu.www.data.NpcData;
import com.fumolu.www.model.Character;
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
     * 支付金币购买道具，恢复玩家生命值和法力值
     * @param player
     */
    @Override
    public void helpPlayer(Player player) {
        //判断玩家金币是否足够
        //支付500金币恢复500生命值和500法力值
        if (player.getMoney()<500){
            System.out.println("您的金币不足");
        }else{
            //玩家金币扣500
            player.setMoney(player.getMoney()-500);
            //玩家生命值和法力值恢复500
            player.setHp(player.getHp()+500);
            player.setMana(player.getMana()+500);
        }

    }
}
