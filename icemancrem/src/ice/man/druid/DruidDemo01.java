package ice.man.druid;

import ice.man.utils.JDBCUtils;
import ice.man.utils.JDBCUtils_druid;

import java.sql.*;

/**
 * use the new utils class
 */
public class DruidDemo01 {
    public static void main(String[] args) {
        // 1. add method
        PreparedStatement pstmt = null;
        Connection conn = null;
        try {
            // connect to the mysql
            conn = JDBCUtils_druid.getConnetion();
            // write a sql
            String sql = "insert into account values(null, ?, ?)";
            // creat a pstmt Object
            pstmt = conn.prepareStatement(sql);
            // write the params to ? in the sql
            pstmt.setString(1, "boss qiu");
            pstmt.setDouble(2, 10000);
            // run the sql
            int i = pstmt.executeUpdate();
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils_druid.close(pstmt, conn);
        }
    }
}
