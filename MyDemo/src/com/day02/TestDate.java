package com.day02;

public class TestDate {
    public static void main(String[] args) {
//        System.out.println(new Date());
//        System.out.println(new SimpleDateFormat("yy-MM-dd HH-mm-ss" ).format(new Date()));
//        try {
//            System.out.println(new SimpleDateFormat("yyyy年MM月dd日" ).parse("2018年12月11日"));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        Calendar cal = Calendar.getInstance();
//        // 设置年
//        int year = cal.get(Calendar.YEAR);
//        // 设置月
//        int month = cal.get(Calendar.MONTH) + 1;
//        // 设置日
//        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
//
//        cal.set(Calendar.YEAR, 2020);
//        System.out.print(year + "年" + month + "月" + dayOfMonth + "日");
//        System.out.println(System.currentTimeMillis());
        StringBuilder builder = new StringBuilder();
        builder.append("hello");
        builder.append('a');
        builder.append(true);
        builder.append(100);
        builder.append(2.3);
        System.out.println(builder);
    }
}
