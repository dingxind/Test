package com.xindong;

public class TestMain {
    public static void main(String[] args) {
        Method method = new Method();
        System.out.println(method.getStudentByid((new Student(1,""))).getLoginName());

    }
}
