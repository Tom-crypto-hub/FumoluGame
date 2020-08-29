package com.fumolu.www.service;

import com.fumolu.www.dao.EnemyDao;
import com.fumolu.www.model.*;
import com.fumolu.www.utils.RandomUtil;
import com.fumolu.www.utils.ScannerUtil;

import java.util.List;

public class EnemyService {
    //传入敌人id获取具体敌人，传入玩家等级playerLevel设置敌人等级
    public static Enemy choiceEnemy(int enemy_id, int playerLevel) {
        EnemyDao enemies = new EnemyDao();
        //传入敌人id获取具体敌人
        Enemy enemy = enemies.inquiry(enemy_id);
        //调用getEnemyLevel方法，传入玩家等级playerLevel设置敌人等级
        int enemyLevel = RandomUtil.getEnemyLevel(playerLevel);
        enemy.setLevel(enemyLevel);
        //调用initializeEnemy初始敌人属性
        initializeEnemy(enemy);
        //返回初始化后的敌人
        return enemy;
    }

    //传入敌人参数，根据敌人等级及职业初始化敌人属性
    public static void initializeEnemy(Enemy e) {
        //敌人等级
        int eLevel = e.getLevel();
        //敌人职业
        Profession eProfession = e.getProfession();
        //物理攻击力
        e.setPhysicalAttack(e.getPhysicalAttack() + eProfession.getPhysicalAttackGrow() * eLevel);
        //物理防御力
        e.setPhysicalDefense(e.getPhysicalDefense() + e.getProfession().getPhysicalDefenseGrow() * eLevel);
        //魔法攻击力
        e.setMagicAttack(e.getMagicAttack() + e.getProfession().getMagicAttackGrow() * eLevel);
        //魔法防御力
        e.setMagicDefense(e.getMagicDefense() + e.getProfession().getMagicDefenseGrow() * eLevel);
        //最大HP
        e.setMaxHp(e.getMaxHp() + e.getProfession().getHpGrow() * eLevel);
        //初始hp等于最大HP
        e.setHp(e.getMaxHp());
        //最大蓝量
        e.setMaxMana(e.getMaxMana() + e.getProfession().getManaGrow() * eLevel);
        //初始蓝量等于最大蓝量
        e.setMana(e.getMaxMana());
    }

    //敌人的物理攻击，计算玩家物理防御力后造成伤害
    public static int physicalAction(Enemy enemy, Player player) {
        int damage = 0;
        //先计算玩家的闪避概率,若玩家闪避,返回伤害值0；否则计算伤害值
        if (RandomUtil.isSuccess(player.getDodgeRate())) {
            return damage;
            //计算此次攻击是否暴击，若暴击造成两倍伤害
        } else if (RandomUtil.isSuccess(enemy.getCritRate())) {
            damage = enemy.getPhysicalAttack() - player.getPhysicalDefense();
            damage = damage * 2;
            return damage;
            //不暴击返回计算的伤害值
        } else {
            damage = enemy.getPhysicalAttack() - player.getPhysicalDefense();
            return damage;
        }
    }

    //敌人的魔法攻击，计算玩家魔法防御力后造成伤害
    public static int magicAction(Enemy enemy, Player player) {
        int damage = 0;
        //先计算玩家的闪避概率,若玩家闪避,返回伤害值0；否则计算伤害值
        if (RandomUtil.isSuccess(player.getDodgeRate())) {
            return damage;
            //计算此次攻击是否暴击，若暴击造成两倍伤害
        } else if (RandomUtil.isSuccess(enemy.getCritRate())) {
            damage = enemy.getMagicAttack() - player.getMagicDefense();
            damage = damage * 2;
            return damage;
            //不暴击返回计算的伤害值
        } else {
            damage = enemy.getMagicAttack() - player.getMagicDefense();
            return damage;
        }
    }

    //判断敌人是否能使用技能攻击，不能返回false
    public static boolean isUseSkill(Enemy enemy) {
        List<Skill> list=enemy.getProfession().getSkills();
        //获取Skill集合里的第一个技能蓝量
        int mana=0;//技能蓝量
        Skill skill=list.get(0);
        mana=skill.getMana();

        if (enemy.getProfession().getSkills()== null) {
            return false;
            //敌人蓝量减去此次技能蓝量若大于0，表示可以释放，返回true
        } else if (enemy.getMana()-mana>=0){
            return true;
        }else{
            return false;
        }
    }
    //敌人的技能攻击,不计算护甲魔抗
    public static double skillAttack(Enemy enemy,Player player) {
        double damage=0;//伤害值
        int attackAddition=0;//技能伤害倍率

        //先计算玩家的闪避概率,若玩家闪避,返回伤害值0；否则计算伤害值
        if (RandomUtil.isSuccess(player.getDodgeRate())) {
            return damage;
            //计算此次攻击是否暴击，若暴击造成两倍伤害
        } else if (RandomUtil.isSuccess(enemy.getCritRate())) {
            //获取Skill集合的第一个元素，获取技能倍率
            List<Skill> list=enemy.getProfession().getSkills();
            Skill skill=list.get(0);
            attackAddition=skill.getAttackAddition();
            damage = enemy.getMagicAttack()*attackAddition;
            return damage*2;
            //不暴击返回计算的伤害值
        } else {
            damage = enemy.getMagicAttack()*attackAddition;
            return damage;
        }
    }
}