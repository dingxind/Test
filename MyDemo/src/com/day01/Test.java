package com.day01;

public class Test {
    public static void main(String[] args) {
//        showAniaml(new Cat());
//        showAniaml(new Dog());

        Animal a = new Cat();
        a.eat();
        //向下转型
        ((Cat) a).catchMouse();


    }

    public  static  void  showAniaml(Animal animal){
        animal.eat();
    }
}
