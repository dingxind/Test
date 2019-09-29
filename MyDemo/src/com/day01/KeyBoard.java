package com.day01;

public class KeyBoard implements  Usb {
    @Override
    public void open() {
        System.out.println("键盘打开");
    }

    @Override
    public void close() {
        System.out.println("键盘关闭");

    }

    public void type(){
        System.out.println("键盘打字");
    }
}
