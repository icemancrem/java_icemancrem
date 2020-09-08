package ice.man.demo;

import ice.man.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class demo03 {
    public static void main(String[] args) {
        Connection coon = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        try {
            coon = JDBCUtils.getConnection();
            // 开启事务
            coon.setAutoCommit(false);

//            icemancrem - 400
            String sql1 = "update account set money = money - ? where name = ?";
//            suoge + 400
            String sql2 = "update account set money = money + ? where name = ?";
            pstmt1 = coon.prepareStatement(sql1);
            pstmt2 = coon.prepareStatement(sql2);
            pstmt1.setDouble(1, 400);
            pstmt1.setString(2, "icemancrem");
            pstmt2.setDouble(1, 400);
//            pstmt2.setDouble(2, 400);
            pstmt2.setString(2, "suoge");
            // 执行sql
            pstmt1.executeUpdate();
//            int i = 3/0; // 手动制造异常
            pstmt2.executeUpdate();

            // 提交事务
            coon.commit();
        } catch (SQLException e) {
            // 事务的回滚
            try {
                if (coon != null) {
                    coon.rollback();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt1,coon);
            JDBCUtils.close(pstmt2,null);
        }
    }
}
