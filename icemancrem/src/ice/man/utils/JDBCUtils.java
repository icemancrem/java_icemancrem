package ice.man.utils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String url;
    private static String user;
    private static String psd;
    private static String dirver;
    static {
        // 读取资源文件
        try {
            Properties pro = new Properties();
            // 获取src路径下的文件的方式 ===> classloader 类加载器
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            URL res = classLoader.getResource("jdbc.properties");
            String path = res.getPath();
//            System.out.println(path);
            pro.load(new FileReader(path));
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            psd = pro.getProperty("psd");
            dirver = pro.getProperty("driver");
            Class.forName(dirver);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    /**
     *
     *  获取连接
     * @return 连接对象
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, psd);
    }
    public static void close(Statement stmt, Connection coon) {
        if(stmt != null) {
            try{
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(coon != null) {
            try{
                coon.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(ResultSet rs, Statement stmt, Connection coon) {
        if(rs != null) {
            try{
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stmt != null) {
            try{
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(coon != null) {
            try{
                coon.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
