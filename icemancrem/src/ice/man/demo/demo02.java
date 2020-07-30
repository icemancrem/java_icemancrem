package ice.man.demo;

import java.sql.*;

public class demo02 {
    public static void main(String[] args) {
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        String url = "jdbc:mysql://49.235.38.160/icemancrem";
        String user_name = "root";
        String psd = "Yaochen11";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user_name, psd);
            String sql = "select * from db_test";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            int id = rs.getInt("id");
            String name = rs.getString("name");
            System.out.println("id:"+id+"-and-"+ "name:"+ name);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

