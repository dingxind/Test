package com.day02;

public class TestThread {
    public static void main(String[] args) {
        MyThread myThread = new MyThread("新的方法");
        myThread.start();
        for (int i = 0;i<5;i++){

            System.out.println("mian方法" +i);
        }
    }
}
