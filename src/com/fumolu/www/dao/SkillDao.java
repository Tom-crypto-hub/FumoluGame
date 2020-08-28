package com.fumolu.www.dao;

import com.fumolu.www.model.Enemy;
import com.fumolu.www.model.Profession;
import com.fumolu.www.model.Skill;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: SkillDao
 * @Description: TODO
 * @author: 王靖
 * @createDate: 2020-08-28 16:28
 */
public class SkillDao  extends BaseDao{

    public static void main(String[] args) {
        List<Skill> list = new SkillDao().inquiry(1);
        for(int i =0 ; i < list.size(); i++){
            System.out.println(list.get(i).toString());
        }
    }

    public List<Skill> inquiry(int professionID) {
        String sql = "SELECT * FROM skill where skill.p_id="+professionID;
        List<Skill> list = new ArrayList<>();
        openConnection();
        try{
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                Skill skill = new Skill();
                skill.setID(rs.getInt("skill_id"));
                skill.setSkillName(rs.getString("skillName"));
                skill.setSkillMoney(rs.getInt("skillMoney"));
                skill.setAttackAddition(rs.getInt("attackAddition"));
                skill.setSkillInstruction(rs.getString("skillInstruction"));
                skill.setMana(rs.getInt("mana"));
                list.add(skill);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }finally {
            closeConnection();
        }
        return list;
    }
}
