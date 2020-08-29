package com.fumolu.www.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @ClassName: BaseDao
 * @Description: TODO
 * @author: 王靖
 * @createDate: 2020-08-28 16:07
 */
public class BaseDao {
    public static void main(String[] args) {
        BaseDao b = new BaseDao();
        b.openConnection();
    }

    protected Connection conn = null;
    protected PreparedStatement ps = null;
    protected ResultSet rs = null;

    /**
     * 打开数据库链接
     */
    public void openConnection() {
        String driver = "com.mysql.cj.jdbc.Driver";

        String url = "jdbc:mysql://localhost:3306/fumolu?serverTimezone=GMT&useSSL=true&characterEncoding=utf-8";
        String user = "root";
        String password = "123456";
        try {
            //加载驱动
            Class.forName(driver);
            //链接数据库
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("链接数据库成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭数据库链接
     */
    public void closeConnection() {

        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 添加信息
    public Object insert(){
        return null;
    }

    public Object update(){
        return null;
    }

    // 查询
    public Object inquiry(){
        return null;
    }

}
