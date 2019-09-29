package com.day01;

import java.util.Objects;
public class TestLaplop extends Object {

    public class Person {
        private String name;
        private int age;

        @Override
        public boolean equals(Object o) {
            // 如果对象地址一样，则认为相同
            if (this == o)
                return true;
            // 如果参数为空，或者类型信息不一样，则认为不同
            if (o == null || getClass() != o.getClass())
                return false;
            // 转换为当前类型
            Person person = (Person) o;
            // 要求基本类型相等，并且将引用类型交给java.util.Objects类的equals静态方法取用结果
            return age == person.age && Objects.equals(name, person.name);
        }
    }

    public static void main(String[] args) {
        Laptop l = new Laptop();
        l.run();
        l.linkUsb(new Mouse());
        l.linkUsb(new KeyBoard());
        l.close();


    }
}
