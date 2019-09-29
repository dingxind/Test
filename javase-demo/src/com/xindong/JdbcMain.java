package com.xindong;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class JdbcMain {

    public static void main(String[] args) throws Exception {
        /**
         * 1.加载sql驱动
         * 2.进行数据库连接
         * 3.创建statement 准备sql语句
         * 4.执行sql语句 返回resultset 结果集
         * 5.resultset取得结果进行处理
         * 6.关闭对象 先开后关
         *
         */
        HashMap<Integer, Student> studentMap = new HashMap<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test01" +
                            "?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull",
                    "root", "root");

            preparedStatement = connection .prepareStatement("SELECT  * from  student where sex=?");
            preparedStatement.setString(1,"男");
            rs  = preparedStatement.executeQuery();

            Student st = null;
            while (rs.next()) {
                st = new Student();
                st.setSid(rs.getInt("sid"));
                st.setSname(rs.getString("sname"));
                st.setBirth(rs.getString("birth"));
                st.setSex(rs.getString("sex"));
                st.setPhone(rs.getString("phone"));
                st.setAddress(rs.getString("address"));
                studentMap.put(st.getSid(),st);
            }

        } finally {
            if(connection !=null&& preparedStatement != null && rs != null) {
                rs.close();
                preparedStatement.close();
                connection.close();
            }
        }

        Set<Integer> keySet = studentMap.keySet();
        for (Integer i :keySet
             ) {
            Student student = studentMap.get(i);
            System.out.println(student);

        }

    }

}
