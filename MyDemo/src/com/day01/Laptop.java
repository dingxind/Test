package com.day01;

public class Laptop {
    public void run(){
        System.out.println("笔记本运行!!");
    }

    public void linkUsb(Usb usb){
        if (usb !=null){

            if (usb instanceof Mouse){
                usb.open();
                ((Mouse) usb).click();
                usb.close();

            }else if (usb instanceof  KeyBoard){
                usb.open();
                ((KeyBoard) usb).type();
                usb.close();
            }
        }

    }
    public void close(){
        System.out.println("笔记本关闭!!");
    }
}
