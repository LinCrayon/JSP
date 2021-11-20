package com.sudolsq;
import java.sql.*;
/**
 * @author THER
 */
public class MysqlPreparestatement {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement prestmt = null;
        ResultSet rs = null;
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            String url = "jdbc:mysql://121.43.177.234:3636/data?" + /*ali_docker_mysql*/
                    "useSSL=true&serverTimezone=cst" +
                    "&characterEnconding=utf-8" +
                    "&serverTimezone=Asia/Shanghai";
            String userName = "root";String password = "password";
            conn = DriverManager.getConnection(url, userName, password);
            String sql = "SELECT * FROM db1 WHERE  price < ? AND date  > ?";
            prestmt = conn.prepareStatement(sql);
            prestmt.setFloat(1,80);
            prestmt.setString(2,"2021.11.10");
            rs = prestmt.executeQuery();
            while (rs.next()){
                String frame   = rs.getString("frame");
                String sqllanguage = rs.getString("sqllanguage");
                String container = rs.getString("container");
                String protocol = rs.getString("protocol");
                Float price = rs.getFloat("price");
                Date date = rs.getDate("date");
                System.out.println(frame + "-------" + sqllanguage + "-------" + container
                        + "-------" +protocol + "-------" + price + "-------" + date );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (prestmt != null) {
                try {
                    prestmt.close();
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
