package com.fumolu.www.dao;

import com.fumolu.www.model.Enemy;
import com.fumolu.www.model.Player;
import com.fumolu.www.model.Profession;
import com.fumolu.www.model.Skill;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: PlayerDao
 * @Description: TODO
 * @author: 王靖
 * @createDate: 2020-08-28 16:27
 */
public class PlayerDao extends BaseDao {

    public static void main(String[] args) {
//        Player player = new Player();
//        player.setUsername("1213");
//        player.setPassword("21321");
//        player.setID(1);
//        Profession profession = new Profession();
//        profession.setID(0);
//        player.setProfession(profession);
//        System.out.println(new PlayerDao().inquiry("123").toString());
//        System.out.println(new PlayerDao().insert(player));

//        Player player = new Player(1, 1, "小鸟", 0, 100, 100, 200, 60, 30, 25, 25, 200, 200, 60, 60, 5, 5, 5, 5, 10,null, "123", "123", null);
//        System.out.println(new PlayerDao().update(player));
//        System.out.println(new PlayerDao().insertUserSkill(1,2));
    }

    // 玩家的注册时的插入
    public int insert(Player player) {
        String sql = "insert into `user`(username, `password`, p_id, c_id, img_id) values(?,?,?,?,?)";
        int result = -1;
        try {
            openConnection();
            //操作相对应表的sql语句
            ps = conn.prepareStatement(sql);
            ps.setString(1, player.getUsername());
            ps.setString(2, player.getPassword());
            ps.setInt(3, player.getProfession().getID());
            ps.setInt(4, player.getID());
            ps.setInt(5, player.getImg_id());
            result = ps.executeUpdate();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection();
        }
        return result;
    }

    public Integer inquiryCharacterID(String username){
        String sql = "select c_id from `character` where characterName='" + username+"'";
        int result = -1;
        openConnection();
        try{
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                result = rs.getInt("c_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }finally {
            closeConnection();
        }
        return result;
    }

    // 玩家登陆
    public Player inquiry(String username){
        String sql = "SELECT * FROM `user`, `character`,profession where `user`.c_id=`character`.c_id and `user`.p_id=profession.p_id and `user`.username='"+username + "'";
        Player player = null;
        openConnection();
        try{
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                player = new Player();
                player.setID(rs.getInt("c_id"));
                player.setUserID(rs.getInt("u_id"));
                player.setImg_id(rs.getInt("img_id"));
                player.setCharacterName(rs.getString("characterName"));
                player.setLevel(rs.getInt("level"));
                player.setExp(rs.getInt("exp"));
                player.setMaxExp(rs.getInt("maxExp"));
                player.setMoney(rs.getInt("money"));
                player.setPhysicalAttack(rs.getInt("physicalAttack"));
                player.setMagicAttack(rs.getInt("magicAttack"));
                player.setPhysicalDefense(rs.getInt("physicalDefense"));
                player.setMagicDefense(rs.getInt("magicDefense"));
                player.setHp(rs.getInt("hp"));
                player.setMaxHp(rs.getInt("maxHp"));
                player.setMana(rs.getInt("mana"));
                player.setMaxMana(rs.getInt("maxMana"));
                player.setDodgeRate(rs.getInt("dodgeRate"));
                player.setMaxDodgeRate(rs.getInt("maxDodgeRate"));
                player.setCritRate(rs.getInt("critRate"));
                player.setMaxCritRate(rs.getInt("maxCritRate"));
                player.setSpeed(rs.getInt("speed"));
                player.setUsername(rs.getString("username"));
                player.setPassword(rs.getString("password"));

                Profession profession = new Profession();
                profession.setID(rs.getInt("p_id"));
                profession.setProfessionName(rs.getString("professionName"));
                profession.setPhysicalAttackGrow(rs.getInt("physicalAttackGrow"));
                profession.setMagicAttackGrow(rs.getInt("magicAttackGrow"));
                profession.setPhysicalDefenseGrow(rs.getInt("physicalDefenseGrow"));
                profession.setMagicDefenseGrow(rs.getInt("magicDefenseGrow"));
                profession.setHpGrow(rs.getInt("hpGrow"));
                profession.setManaGrow(rs.getInt("manaGrow"));

                player.setProfession(profession);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }finally {
            closeConnection();
        }
        return player;
    }

    public Integer insert(String username){
        int result = -1;
        try {
            openConnection();
            //操作相对应表的sql语句
            String sql = "insert into `character`(characterName) values(?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            result = ps.executeUpdate();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection();
        }
        return result;
    }

    // 玩家数据的更新
    public Boolean update(Player player){
        int n = -1;
        String sql = "update `user`, `character` set " +
                " img_id=" + player.getImg_id() +
                ", characterName='" + player.getCharacterName() +
                "', `level`=" + player.getLevel() +
                ", exp=" + player.getExp() +
                ", maxExp=" + player.getMaxExp() +
                ", money=" + player.getMoney() +
                ", physicalAttack=" + player.getPhysicalAttack() +
                ", magicAttack=" + player.getMagicAttack() +
                ", physicalDefense=" + player.getPhysicalDefense() +
                ", magicDefense=" + player.getMagicDefense() +
                ", hp=" + player.getHp() +
                ", maxHp=" + player.getMaxHp() +
                ", mana=" + player.getMana() +
                ", maxMana=" + player.getMaxMana() +
                ", dodgeRate=" + player.getDodgeRate() +
                ", maxDodgeRate=" + player.getMaxDodgeRate() +
                ", critRate=" + player.getCritRate() +
                ", maxCritRate=" + player.getMaxCritRate() +
                ", speed=" + player.getSpeed() +
                " where `user`.c_id=`character`.c_id " +
                " and `user`.username = '" + player.getUsername() + "'";
        openConnection();
        try {
            Statement stmt = conn.createStatement();
            n = stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection();
        }
        if(n == -1)return false;
        return true;
    }

    // 玩家学会技能
    public int insertUserSkill(int playerID, int skillID){
        int result = -1;
        try {
            openConnection();
            //操作相对应表的sql语句
            String sql = "insert into user_skill(u_id, skill_id) values(?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, playerID);
            ps.setInt(2, skillID);
            result = ps.executeUpdate();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        finally {
            closeConnection();
        }
        return result;
    }

    public List<Skill> inquiry(int playerID) {
        String sql = "SELECT * FROM skill, user_skill where user_skill.skill_id=skill.skill_id and user_skill.u_id="+playerID;
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
