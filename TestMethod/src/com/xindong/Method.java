package com.xindong;

public class Method {
    public Student  getStudentByid(Student student){
        if(student !=null){
            if(student.getId()==1){
                student.setLoginName("zhangsan");
            }else if(student.getId()==2 ){
                student.setLoginName("lisi");
            }
        }
        return student;
    }
}
