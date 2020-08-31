package com.fumolu.www.service.npc;

import com.fumolu.www.dao.PlayerDao;
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
    public boolean helpPlayer(Player player) {
        //判断玩家金币是否足够
        //支付300金币恢复玩家500生命值和500法力值
        if (player.getMoney()<300) {
            System.out.println("您的金币不足");
            return false;
        }else {
            //玩家金币扣300
            player.setMoney(player.getMoney() - 300);
            //玩家生命值恢复600, 和法力值恢复400，但是不能超过上限
            player.setHp(Math.min(player.getHp() + 600, player.getMaxHp()));
            player.setMana(Math.min(player.getMana() + 400, player.getMaxMana()));
            System.out.println("治疗成功！");
            // 将改动的数据存入数据库中
            new PlayerDao().update(player);
            return true;
        }
    }
}

