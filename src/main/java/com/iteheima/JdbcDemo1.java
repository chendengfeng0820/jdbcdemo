package com.iteheima;

import java.sql.*;

/**
 * @author: cdf
 * @create: 2020-01-13 00:03
 **/
public class JdbcDemo1 {
    public static void main(String[] args) throws SQLException {
        // 1.注册驱动
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());

        // 2.获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring", "root", "820820");

        // 3.获得数据库的预处理对象
        PreparedStatement pstm = conn.prepareStatement("select * from account");

        // 4.执行SQl，获得结果集
        ResultSet rs = pstm.executeQuery();

        // 5.遍历结果集
        while (rs.next()) {
            System.out.println(rs.getString("name"));
            System.out.println(rs.getString("money"));
        }

        // 6.释放资源
        rs.close();
        pstm.close();
        conn.close();
    }
}
