package com.fumolu.www.service.npc;

import com.fumolu.www.dao.PlayerDao;
import com.fumolu.www.dao.SkillDao;
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
    public String helpPlayer(Player player, int skillID) {
        // 通过ID，获取数据库的SKill数值属性
        Skill skill = new SkillDao().inquirySkill(skillID);
        // 判断玩家是否已经学习了这个技能
        List<Skill> list = player.getSkills();
        // 判断玩家是否学习了该技能
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals(skill)){
                return "您已经学会了 " + skill.getSkillName() + " ，不需要再次学习";
            }
        }
        //判断玩家金币是否足够再进行技能学习
        if (player.getMoney() < skill.getSkillMoney()){
            System.out.println("您的金币不足");
            return "很抱歉，您的金币不足啦！";
        }else{
            player.setMoney(player.getMoney()-skill.getSkillMoney());
            player.getSkills().add(skill);
            // 向数据库添加玩家技能数据
            PlayerDao playerDao = new PlayerDao();
            int result = playerDao.insertUserSkill(player.getUserID(), skillID);
            // 更改玩家信息
            boolean flag = playerDao.update(player);
            if(result >= 0 && flag) {
                System.out.println("恭喜您成功学会技能：" + skill.getSkillName());
                return "恭喜您成功学会技能：" + skill.getSkillName() + "！\n纵横伏魔录，您还等什么！";
            }
        }
        return "学习技能失败";
    }

    @Override
    public boolean helpPlayer(Player player) {
        return false;
    }
}

