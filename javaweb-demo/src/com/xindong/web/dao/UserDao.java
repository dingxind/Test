package com.xindong.web.dao;

import com.xindong.web.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public User findUserByLoginName(String loginName) {
        User userReturn = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/finance" +
                            "?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull",
                    "root", "root");
//Sql语句
            preparedStatement = connection.prepareStatement("SELECT  * from  user where login_name=? ");
            preparedStatement.setString(1, loginName);
            rs = preparedStatement.executeQuery();
            if (rs != null) {

                if (rs.first()) {
                    rs.beforeFirst();
                    userReturn = new User();
                    while (rs.next()) {
                        userReturn.setId(rs.getInt("id"));
                        userReturn.setLoginName(rs.getString("login_name"));
                        userReturn.setPassword(rs.getString("password"));
                        userReturn.setRealName(rs.getString("real_name"));
                        userReturn.setGender(rs.getInt("gender"));
                        userReturn.setCreateDate(rs.getString("create_date"));
                        userReturn.setUpdateDate(rs.getString("update_date"));

                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (connection != null && preparedStatement != null && rs != null) {
                try {

                    rs.close();
                    preparedStatement.close();
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();

                }
            }
        }
        return userReturn;
    }

    public List<User> findUserByCondition(String sql, Object... params) {

        List<User> userList = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/finance" +
                            "?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull",
                    "root", "root");

//Sql语句

            preparedStatement = connection.prepareStatement(sql);
            if (params != null && params.length > 0) {
                for (int i = 1; i <= params.length; i++) {
                    preparedStatement.setString(i, params[i - 1].toString());
                }
            }
            rs = preparedStatement.executeQuery();
            if (rs != null) {

                if (rs.first()) {
                    rs.beforeFirst();
                    userList = new ArrayList<>();

                    while (rs.next()) {
                        User userData = new User();
                        userData.setId(rs.getInt("id"));
                        userData.setLoginName(rs.getString("login_name"));
                        userData.setPassword(rs.getString("password"));
                        userData.setRealName(rs.getString("real_name"));
                        userData.setGender(rs.getInt("gender"));
                        userData.setCreateDate(rs.getString("create_date"));
                        userData.setUpdateDate(rs.getString("update_date"));

                        userList.add(userData);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (connection != null && preparedStatement != null && rs != null) {
                try {
                    rs.close();
                    preparedStatement.close();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return userList;
    }

    public int userDelete(int id) {
        User userReturn = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/finance" +
                            "?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull",
                    "root", "root");
//Sql语句
            preparedStatement = connection.prepareStatement("delete from user where id=? ");
            preparedStatement.setInt(1, id);
            i = preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (connection != null && preparedStatement != null) {
                try {

                    preparedStatement.close();
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();

                }
            }
        }
        return i;
    }

    public int userAdd(User user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rs = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/finance" +
                            "?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull",
                    "root", "root");
//Sql语句
            preparedStatement = connection.prepareStatement("insert  into  user(id,login_name, password, real_name, gender, create_date, update_date) values (default ,?,?,?,?,?,?)");
            preparedStatement.setString(1, user.getLoginName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getRealName());
            preparedStatement.setString(4, String.valueOf(user.getGender()));
            preparedStatement.setString(5, String.valueOf(user.getCreateDate()));
            preparedStatement.setString(6, String.valueOf(user.getUpdateDate()));
            rs = preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (connection != null && preparedStatement != null) {
                try {

                    preparedStatement.close();
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();

                }
            }
        }
        return rs;
    }

    public User findById(int id) {
        User user = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/finance" +
                            "?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull",
                    "root", "root");
//Sql语句
            preparedStatement = connection.prepareStatement("select  * from user where id=? ");
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                user = new User();
                int id1 = rs.getInt("id");
                String login_name = rs.getString("login_name");
                String password = rs.getString("password");
                String real_name = rs.getString("real_name");
                int gender = rs.getInt("gender");
                String create_date = rs.getString("create_date");
                String update_date = rs.getString("update_date");
                user.setId(id1);
                user.setLoginName(login_name);
                user.setPassword(password);
                user.setRealName(real_name);
                user.setGender(gender);
                user.setCreateDate(create_date);
                user.setUpdateDate(update_date);

            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (connection != null && preparedStatement != null) {
                try {

                    preparedStatement.close();
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();

                }
            }
        }
        return user;
    }

    public int userUpdate(User user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rs = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/finance" +
                            "?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull",
                    "root", "root");
//Sql语句
            preparedStatement = connection.prepareStatement("update user set login_name=?,password=?,real_name=?,gender=?,create_date=?,update_date=? where id=?");
            preparedStatement.setString(1, user.getLoginName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getRealName());
            preparedStatement.setString(4, String.valueOf(user.getGender()));
            preparedStatement.setString(5, String.valueOf(user.getCreateDate()));
            preparedStatement.setString(6, String.valueOf(user.getUpdateDate()));
            preparedStatement.setString(7, String.valueOf(user.getId()));
            rs = preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (connection != null && preparedStatement != null) {
                try {

                    preparedStatement.close();
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();

                }
            }
        }
        return rs;
    }
}

