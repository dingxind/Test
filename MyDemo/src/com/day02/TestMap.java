package com.day02;

public class TestMap {
    public static void main(String[] args) {
        try {
            int i= 5/0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("aaa");
        }
    }
}
