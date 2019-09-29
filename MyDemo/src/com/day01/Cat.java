package com.day01;

public class Cat extends Animal {
    @Override
    public void eat() {
        System.out.println("喵喵叫！！");
    }
    public void catchMouse(){
        System.out.println("我会抓老鼠！！");
    }
}
