package com.company;


import java.math.BigInteger;
import java.util.Scanner;

public class BASIC {
    static int CountDigit(int x){
        int num = x;
        int count = 0;
        while(num!=0){
             num = num/10;
             count++;
        }
        return count;
    };
    static boolean IsPalindrome(int n) {
        int num =n;
        int res=0;;
        while ( num!=0){
            res = res*10+num%10;
            num/=10;
        }
        num =n;
        if(num==res) {
            System.out.println("your number "+num+" is a palindrome");
            return true;
        }else {System.out.println("your number "+num+" NOT a palindrome");
            return false;}

    };
    static int Factorial1(int n){
        if(n==0 || n==1){
            return 1;
        }
        else {
            return n*Factorial1(n-1);
        }
    };
    static int Factorial2(int x){
        int fact=1 ;
//
        for(int i = 1; i <= x; ++i) {
            fact *= i;
        }
        return fact;
    };
    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    };
    public static int TotalZero(int n){
        int zeros = 0;
        int m = 5;
        int x = n;
        while (x>0){
            zeros = zeros+n/m;
            x=x/m;
            m = m*5;
        }
        return zeros;
    };
    public static boolean IsPrime(int n){
        int value =  (int)(Math.sqrt(n))+1;
        boolean isprime = true ;
        for(int i=2; i<value; i++){
            if (n==2 || n==3){
                isprime= true;
            } else if (n>=4) {
                if (n%i==0){
                    isprime =false;
                    break;
                }else{
                    isprime= true;
                }
            }
        }
        return isprime;
    };
//    public static int HCF(int x ,int y){
//        int fact = 1;
//        int min = Math.min(x,y);
//        for(int i=1; i<=min; i++){
//            if(x%i==0 && y%i==0 && IsPrime(i)){
//                fact*=i;
//            }
//        }
//        return fact;
//    };
//    public static int HCF(int x ,int y){
//        int fact = 1;
//        int min = Math.max(x,y);
//        for(int i=1; i<=min; i++){
//            if(x%i==0 && y%i==0){
//                fact*=i;
//            }
//        }
//        return fact;
//    };
    public static void main(String[] args) {
        Scanner num = new Scanner(System.in);
        System.out.println("Enter a number for count digit");
        int x = num.nextInt();
        System.out.println("Enter a number for Factorial");
        int n = num.nextInt();
        System.out.println("Total numbers in "+ x + " is = "+ CountDigit(x));
        System.out.println(IsPalindrome(x));
//        System.out.println("M1-factorial of below 25 "+n+" is "+Factorial1(n));51545
        System.out.println("total no of zeros in factorial "+ TotalZero(n));
        System.out.println("factorial of above 25 "+n+" is "+factorial(n));
        System.out.println("enter a num for prime ");
        int p = num.nextInt();
        System.out.println("your given number is prime "+IsPrime(p));
//        System.out.println("enter two number for their hcf and lcf");
//        int a = num.nextInt();
//        int b = num.nextInt();
//        System.out.println("HCF of the numbers "+a+" and "+b+" "+HCF(a,b));

    }
}

