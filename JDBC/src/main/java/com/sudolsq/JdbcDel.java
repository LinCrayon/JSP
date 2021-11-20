package com.sudolsq;
import java.sql.*;
/**
 * @author THER
 */
public class JdbcDel {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs;
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            String url = "jdbc:mysql://121.43.177.234:3636/data?" + /*ali_docker_mysql*/
                    "useSSL=true&serverTimezone=cst" +
                    "&characterEnconding=utf-8" +
                    "&serverTimezone=Asia/Shanghai";
            String userName = "root";String password = "password";
            conn = DriverManager.getConnection(url, userName, password);
            stmt = conn.createStatement();
            String sql = "delete from db1 where id > 4";
            int count = stmt.executeUpdate(sql);
            System.out.println(count == 1 ? "删除成功" : "删除成功");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
