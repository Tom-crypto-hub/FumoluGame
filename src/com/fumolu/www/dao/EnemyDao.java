package com.fumolu.www.dao;

import com.fumolu.www.model.Enemy;
import com.fumolu.www.model.Profession;
import com.fumolu.www.model.Skill;

import java.nio.channels.SelectionKey;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: EnemyDao
 * @Description: TODO
 * @author: 王靖
 * @createDate: 2020-08-28 19:17
 */
public class EnemyDao extends BaseDao {

//    public static void main(String[] args) {
//        System.out.println(new EnemyDao().inquiry(1).toString());
//    }

    public Enemy inquiryEnemy(int index) {
        String sql = "SELECT * FROM `character` where `character`.c_id="+index;
        Enemy enemy = new Enemy();
        openConnection();
        try{
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                enemy = new Enemy();
                enemy.setID(rs.getInt("c_id"));
                enemy.setCharacterName(rs.getString("characterName"));
                enemy.setLevel(rs.getInt("level"));
                enemy.setExp(rs.getInt("exp"));
                enemy.setMaxExp(rs.getInt("maxExp"));
                enemy.setMoney(rs.getInt("money"));
                enemy.setPhysicalAttack(rs.getInt("physicalAttack"));
                enemy.setMagicAttack(rs.getInt("magicAttack"));
                enemy.setPhysicalDefense(rs.getInt("magicAttack"));
                enemy.setMagicDefense(rs.getInt("magicAttack"));
                enemy.setHp(rs.getInt("hp"));
                enemy.setMaxHp(rs.getInt("maxHp"));
                enemy.setMana(rs.getInt("mana"));
                enemy.setMaxMana(rs.getInt("maxMana"));
                enemy.setDodgeRate(rs.getInt("dodgeRate"));
                enemy.setMaxDodgeRate(rs.getInt("dodgeRate"));
                enemy.setCritRate(rs.getInt("critRate"));
                enemy.setMaxCritRate(rs.getInt("maxCritRate"));
                enemy.setSpeed(rs.getInt("speed"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }finally {
            closeConnection();
        }
        return enemy;
    }

    public List<Skill> inqueryEnemySkill(int enemyID){
        String sql = "SELECT * FROM `enemy`, skill where enemy.skill_id=skill.skill_id and enemy.c_id=" + enemyID;
        List<Skill> list = new ArrayList<>();
        openConnection();
        try{
            Skill skill = null;
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                skill = new Skill();
                skill.setID(rs.getInt("skill_id"));
                skill.setSkillName(rs.getString("skillName"));
                skill.setSkillMoney(rs.getInt("skillMoney"));
                skill.setAttackAddition(rs.getInt("attackAddition"));
                skill.setSkillInstruction(rs.getString("skillInstruction"));
                skill.setMana(rs.getInt("mana"));
                list.add(skill);
            }
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }finally {
            closeConnection();
        }
        return list;
    }

}
