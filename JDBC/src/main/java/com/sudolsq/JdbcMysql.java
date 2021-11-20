package com.sudolsq;
import java.sql.*;
/**
 * @author THER
 */
public class JdbcMysql{
    public static void main(String[] args) {
        Connection conn;
        Statement stmt;
        ResultSet rs;
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            String url = "jdbc:mysql://121.43.177.234:3636/data?"+  //ali_docker_mysql
                            "useSSL=true&serverTimezone=cst" +
                            "&characterEnconding=utf-8" +
                            "&serverTimezone=Asia/Shanghai";
            String userName = "root";
            String password = "password";
            conn = DriverManager.getConnection(url, userName, password);
            stmt = conn.createStatement();
            String sql = "select * from db1";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String pframe = rs.getString("frame");
                String psql= rs.getString("sql");
                String protocol = rs.getString("protocol");
                int pid =rs.getInt("id");
                System.out.println(pframe +"-----"+ psql +"-----"+ protocol +"-----" + "pid");
            }
            stmt.close();
            rs.close();
            conn.close();
        } catch(Exception e){
            e.printStackTrace();
        }

    }
}
