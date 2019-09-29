package com.xindong.web.service;

import com.xindong.web.dao.UserDao;
import com.xindong.web.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private UserDao userDao=new UserDao();

    public List<User> findUserByCondition(User user) {
        StringBuilder stringBuilder =new StringBuilder();
        stringBuilder.append("select * from user where 1=1");
        List params =new ArrayList<>();
        if(user != null) {
            if(user.getLoginName()!= null ){
                stringBuilder.append(" and login_name like ?");
                params.add("%"+user.getLoginName()+"%");

            }
            if(user.getRealName() != null ){
                stringBuilder.append(" and real_name like ?");
                params.add("%"+user.getRealName()+"%");

            }
        }
        return userDao.findUserByCondition(stringBuilder.toString(),params.toArray());
    }

    public User findUserByLoginName(String loginName) {
        return userDao.findUserByLoginName(loginName);

    }
    public int userDelete(int id){
        return  userDao.userDelete(id);

    }
    public  int  userAdd(User user){
        return userDao.userAdd(user);
    }
    public  User findById(int id){
        return  userDao.findById(id);

    }
    public  int userUpdate(User user){
        return  userDao.userUpdate(user);


    }}
