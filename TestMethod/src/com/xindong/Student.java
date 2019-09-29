package com.xindong;

public class Student {
    private Integer id;
    private  String  loginName;

    public Student(Integer id, String loginName) {
        this.id = id;
        this.loginName = loginName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
}
