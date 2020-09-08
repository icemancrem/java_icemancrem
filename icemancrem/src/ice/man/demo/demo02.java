package ice.man.demo;

import ice.man.utils.JDBCUtils;

import java.sql.*;

public class demo02 {
    public static void main(String[] args) {
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
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
            JDBCUtils.close(rs, stmt, conn);
        }
    }
}

