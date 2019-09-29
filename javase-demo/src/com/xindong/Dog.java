package com.xindong;

public class Dog {
    public int calculate(int base, int... num) {
        int result = 0;
        result = base;
        if (num != null) {
            for (int n : num
            ) {
                result += n;

            }
        }

        return result;

    }
}
