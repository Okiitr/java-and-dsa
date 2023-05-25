package java_practice;


import java.util.Scanner;

public class Factorial{
    static double fact1(int n){
        if(n==1 || n==0){
            return 1;
        }
        return n*fact1(n-1);
    }
    static double fact2(int n){
        int fact =1;
        for(int i=1; i<=n; i++){
            fact*=i;
        }
        return fact;
    }
    public static int TotalZero(int n){
        int zeros =0;
        int m =5;
        while (n!=0){
            zeros =zeros+n/m;
            m*=5;
        }
        return zeros;
    };
//both the function having theta n time complexity but recursive function has theta n space complexity and other has theta 1
    public static void main(String[] args) {
        System.out.println("enter a number to find factorial");
        Scanner scan =new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println("factorial "+fact1(n)+" and "+ fact2(n)+ " total zeros "+ TotalZero(n));
    }
}
