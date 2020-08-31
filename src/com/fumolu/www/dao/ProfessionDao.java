package com.fumolu.www.dao;

import com.fumolu.www.model.Profession;

import java.sql.SQLException;

/**
 * @ClassName: ProfessionDao
 * @Description: TODO
 * @author: 王靖
 * @createDate: 2020-08-28 16:27
 */
public class ProfessionDao extends BaseDao {

    public Profession inquiry(int index){
            String sql = "select * from profession where p_id='" + index + "'";	//模糊匹配查询
            Profession profession = new Profession();
            openConnection();
            try{
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while(rs.next()) {
                    profession = new Profession();
                    profession.setID(rs.getInt("p_id"));
                    profession.setProfessionName(rs.getString("professionName"));
                    profession.setPhysicalAttackGrow(rs.getInt("physicalAttackGrow"));
                    profession.setMagicAttackGrow(rs.getInt("magicAttackGrow"));
                    profession.setPhysicalDefenseGrow(rs.getInt("physicalDefenseGrow"));
                    profession.setMagicDefenseGrow(rs.getInt("magicDefenseGrow"));
                    profession.setHpGrow(rs.getInt("hpGrow"));
                    profession.setManaGrow(rs.getInt("manaGrow"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }finally {
                closeConnection();
            }
            return profession;
    }

}
