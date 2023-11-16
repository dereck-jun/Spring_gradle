package com.example.demo.chap03.used;

public class EveningGreet implements Greet{
    @Override
    public void greeting() {
        System.out.println("===================");
        System.out.println("    좋은 아침입니다");
        System.out.println("===================");
    }
}
