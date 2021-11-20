package com.sudolsq;
import java.sql.*;
public class JdbcSqlserver{
    public static void main(String[] args) throws ClassNotFoundException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            Class.forName(driver);
            String url = "jdbc:sqlserver://localhost:1433;databaseName=data";
            String userName = "sa";
            String password = "password";
            conn = DriverManager.getConnection(url, userName, password);
            stmt = conn.createStatement();
            String sql = "select * from db1";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String dev = rs.getString("develop");
                String ops = rs.getString("ops");
                String linux = rs.getString("linux");
                System.out.println(dev +'\t'+ ops +'\t'+ linux +'\t');
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
