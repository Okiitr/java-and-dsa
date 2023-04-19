package com.company;

import java.util.Scanner;
//java loops and function here used and recursion method also

public class Loop {
    static void Pettern(int n) {
        for (int i = n; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("enter a number: ");
        int n = scan.nextInt();
        Pettern(n+10);
        factorial(n);
        System.out.print("\n");
        System.out.println(recursion(n));

    }

    static void factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        System.out.format("factorial of %d is %d", n, fact);
    }
    static int recursion(int n){
        if (n==0 || n==1){
            return 1;
        }
        else {
            return n*recursion(n-1);
        }
    }

}

