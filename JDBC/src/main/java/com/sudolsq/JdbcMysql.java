package com.sudolsq;
import java.sql.*;
public class JdbcMysql{
    public static void main(String[] args) throws ClassNotFoundException {
        Connection conn;
        Statement stmt;
        ResultSet rs;
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            String url = "jdbc:mysql://121.43.177.234:3636/db1?"+  //ali_docker_mysql
                            "useSSL=true&serverTimezone=cs" +
                            "t&characterEnconding=utf-8" +
                            "&serverTimezone=Asia/Shanghai";
            String userName = "root";
            String password = "password";
            conn = DriverManager.getConnection(url, userName, password);
            stmt = conn.createStatement();
            String sql = "select * from data";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String dev = rs.getString("Dev");
                String ops = rs.getString("Ops");
                String database = rs.getString("database");
                System.out.println(dev +'\t'+ ops +'\t'+ database +'\t');
            }
            stmt.close();
            rs.close();
            conn.close();


        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
