package com.fumolu.www.dao;

import com.fumolu.www.model.Enemy;
import com.fumolu.www.model.Profession;

import java.sql.SQLException;

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

    public Enemy inquiry(int index) {
        String sql = "SELECT * FROM `enemy`, skill, `character`,profession where enemy.c_id=`character`.c_id and enemy.skill_id=skill.skill_id and skill.p_id=profession.p_id and enemy.id="+index;
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

                Profession profession = new Profession();
                profession.setID(rs.getInt("p_id"));
                profession.setProfessionName(rs.getString("professionName"));
                profession.setPhysicalAttackGrow(rs.getInt("physicalAttackGrow"));
                profession.setMagicAttackGrow(rs.getInt("magicAttackGrow"));
                profession.setPhysicalDefenseGrow(rs.getInt("physicalDefenseGrow"));
                profession.setMagicDefenseGrow(rs.getInt("magicDefenseGrow"));
                profession.setHpGrow(rs.getInt("hpGrow"));
                profession.setManaGrow(rs.getInt("manaGrow"));

                enemy.setProfession(profession);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return enemy;
    }


}
