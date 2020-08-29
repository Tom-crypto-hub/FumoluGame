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

        Skill skill=new Skill();
        // 判断玩家是否已经学习了这个技能
        List<Skill> list = player.getSkills();
        //判断玩家是否学习了该技能
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals(skill)){
                return;
            }
        }
        //判断玩家金币是否足够再进行技能学习
        if (player.getMoney()<skill.getSkillMoney()){
            System.out.println("您的金币不足");
        }else{
            player.setMoney(player.getMoney()-skill.getSkillMoney());
            list.add(skill);
        }
    }
}

