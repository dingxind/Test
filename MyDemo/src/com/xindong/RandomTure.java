package com.xindong;

import java.util.Random;
import java.util.Scanner;

public class RandomTure {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int number = random.nextInt(101);
        int min = 0;
        int max = 100;
        while (true) {
            System.out.println("请输入一个数!!");
            int i = sc.nextInt();
            if (i == number) {
                System.out.println("恭喜您，答对了！！");
                break;
            } else if (i < number) {
                if (min < i) {
                    min = i;
                }
                System.out.println("您猜的" + i + "猜小了!!");
                System.out.println("数在" + min + "-" + max + "之间");
            } else if (i > number) {
                if (max > i) {
                    max = i;
                }
                System.out.println("您猜的" + i + "猜大了!!");
                System.out.println("数在" + min + "-" + max + "之间");
            }
        }

    }
}
