package com.fumolu.www.service;

import com.fumolu.www.dao.EnemyDao;
import com.fumolu.www.model.*;
import com.fumolu.www.utils.RandomUtil;
import com.fumolu.www.utils.ScannerUtil;

import java.util.List;

public class EnemyService {
    //传入敌人id获取具体敌人，传入玩家等级playerLevel设置敌人等级
    public static Enemy choiceEnemy(Enemy enemy, int playerLevel) {
        EnemyDao enemies = new EnemyDao();
        //传入敌人id获取具体敌人
//        Enemy enemy = enemies.inquiryEnemy(enemy_id);
        //调用getEnemyLevel方法，传入玩家等级playerLevel设置敌人等级
        int enemyLevel = RandomUtil.getEnemyLevel(playerLevel);
        enemy.setLevel(enemyLevel);
        //调用initializeEnemy初始敌人属性
        initializeEnemy(enemy);
        enemy.setSkills(enemies.inqueryEnemySkill(enemy.getID()));
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
        e.setPhysicalDefense(e.getPhysicalDefense() + eProfession.getPhysicalDefenseGrow() * eLevel);
        //魔法攻击力
        e.setMagicAttack(e.getMagicAttack() + eProfession.getMagicAttackGrow() * eLevel);
        //魔法防御力
        e.setMagicDefense(e.getMagicDefense() + eProfession.getMagicDefenseGrow() * eLevel);
        //最大HP
        e.setMaxHp(e.getMaxHp() + eProfession.getHpGrow() * eLevel);
        //初始hp等于最大HP
        e.setHp(e.getMaxHp());
        //最大蓝量
        e.setMaxMana(e.getMaxMana() + eProfession.getManaGrow() * eLevel);
        //初始蓝量等于最大蓝量
        e.setMana(e.getMaxMana());
    }

    //敌人的物理攻击，计算玩家物理防御力后造成伤害
    public static String physicalAction(Enemy enemy, Player player) {
        int damage = 0;
        //先计算玩家的闪避概率,若玩家闪避,返回伤害值0；否则计算伤害值
        if (RandomUtil.isSuccess(player.getDodgeRate())) {
            return "玩家闪避了敌人的物理攻击";
            //计算此次攻击是否暴击，若暴击造成两倍伤害
        } else if (RandomUtil.isSuccess(enemy.getCritRate())) {
            damage = enemy.getPhysicalAttack() - player.getPhysicalDefense();
            damage = (int)(damage * 1.5);
            if (damage < 0 ) damage = 1;
            player.setHp(Math.max(0, player.getHp() - damage));
            return "暴击：敌人给玩家造成了" + damage + "点物理伤害";
            //不暴击返回计算的伤害值
        } else {
            damage = enemy.getPhysicalAttack() - player.getPhysicalDefense();
            if (damage < 0 ) damage = 1;
            player.setHp(Math.max(0, player.getHp() - damage));
            return "敌人给玩家造成了" + damage + "点物理伤害";
        }
    }

    //敌人的魔法攻击，计算玩家魔法防御力后造成伤害
    public static String magicAction(Enemy enemy, Player player) {
        int damage = 0;
        //先计算玩家的闪避概率,若玩家闪避,返回伤害值0；否则计算伤害值
        if (RandomUtil.isSuccess(player.getDodgeRate())) {
            return "玩家闪避了敌人的法术攻击";
            //计算此次攻击是否暴击，若暴击造成两倍伤害
        } else if (RandomUtil.isSuccess(enemy.getCritRate())) {
            damage = enemy.getMagicAttack() - player.getMagicDefense();
            damage = (int)(damage * 1.5);
            if (damage < 0 ) damage = 1;
            player.setHp(Math.max(0, player.getHp() - damage));
            return "暴击：敌人给玩家造成了" + damage + "点法术伤害";
            //不暴击返回计算的伤害值
        } else {
            damage = enemy.getMagicAttack() - player.getMagicDefense();
            if (damage < 0 ) damage = 1;
            player.setHp(Math.max(0, player.getHp() - damage));
            return "敌人给玩家造成了" + damage + "点法术伤害";
        }
    }

    //判断敌人的攻击方式，1位物理攻击，2为法术攻击，3为技能攻击
    public static String enemyAttack(Enemy enemy, Player player) {
        List<Skill> list = enemy.getSkills();

        int val = RandomUtil.random.nextInt(100);
        if(val < 50){
            // 40的概率普通攻击
            return physicalAction(enemy, player);
        }
        else if(val < 80){
            // 30的概率法术攻击
            return magicAction(enemy, player);
        }
        else {
            // 20 的概率进行技能攻击
            // 判断敌人书否拥有技能
            if(list.size() != 0){
                // 技能攻击
                return skillAttack(enemy, player);
            }else {
                // 物理攻击
                return physicalAction(enemy, player);
            }
        }
    }

    //敌人的技能攻击,不计算护甲魔抗
    public static String skillAttack(Enemy enemy,Player player) {
        int damage=0;//伤害值
        int attackAddition=0;//技能伤害倍率
        // 敌人的技能
        List<Skill> skills = enemy.getSkills();

        int i = RandomUtil.random.nextInt(skills.size());

        if(enemy.getMana() < skills.get(i).getMana()){
            return "敌人想释放技能《" + skills.get(i).getSkillName() + "》，但是法力值不足，行动失败！";
        }

        if(skills.get(i).getSkillName().equals("春风吹又生")){
            int HP = Math.min(enemy.getMaxHp(),
                    enemy.getHp() + enemy.getMagicDefense() * skills.get(i).getAttackAddition());

            return "敌人释放技能《春风吹又生》为自己恢复了" + HP + "点生命值";
        }

        if(RandomUtil.isSuccess(player.getDodgeRate())){
            return "敌人闪避了玩家的技能攻击";
        }

        damage = skills.get(i).getAttackAddition() * enemy.getMagicAttack() - player.getPhysicalDefense() - player.getMagicDefense();
        String result = "";
        if (damage < 0 ) damage = 1;

        if(skills.get(i).getSkillName().equals("嗜狼印")){
            int HP = Math.min(enemy.getMaxHp(), enemy.getHp() + (int)(damage * 0.5));
            enemy.setHp(HP);
            result += "敌人恢复了" + HP + "血量，";
        }
        player.setHp(Math.max(0, player.getHp() - damage));
        return result + "敌人给玩家造成了 " + damage + "点伤害";

//        //先计算玩家的闪避概率,若玩家闪避,返回伤害值0；否则计算伤害值
//        if (RandomUtil.isSuccess(player.getDodgeRate())) {
//            return damage;
//            //计算此次攻击是否暴击，若暴击造成两倍伤害
//        } else if (RandomUtil.isSuccess(enemy.getCritRate())) {
//            //获取Skill集合的第一个元素，获取技能倍率
//            List<Skill> list=enemy.getProfession().getSkills();
//            Skill skill=list.get(0);
//            attackAddition=skill.getAttackAddition();
//            damage = enemy.getMagicAttack()*attackAddition;
//            return damage*2;
//            //不暴击返回计算的伤害值
//        } else {
//            damage = enemy.getMagicAttack()*attackAddition;
//            return damage;
//        }
    }
}