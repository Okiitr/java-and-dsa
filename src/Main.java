package com.company;

import java.util.Scanner;
class Student{
    int roll;
    String name;
    Student(int r, String nam){
        roll = r;
        name =nam;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Student oman = new Student(411, "Oman");
        System.out.println(oman.roll);
        
        int x =235;
        byte y=100;
        short z = 10;
        char name = 'o';
        float f = 284384.9f;
        double d= 555656d;
        long num= 3893439849034l;
        System.out.printf("%05d %n",x);
        System.out.printf("%-4.2s", "Hi there!");
        System.out.printf("%2d",x);
        System.out.println(x+y);
        System.out.println(z*f);

//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        System.out.println(str);
//
//        Scanner nam =new Scanner(System.in);
//        String n = nam.nextLine();
//        System.out.println(n);




    }
}