package DSA.Recursion;

import java.util.Scanner;

public class RECURSION {
    public static void main(String[] args) {
        Scanner num = new Scanner(System.in);
        System.out.println("Enter a number ");
        int N = num.nextInt();
        /* PrintNumbersNto1(N);
        System.out.println(" ");
        PrintNumbers1toN(N);
        System.out.println(" ");
        print1ToN(N,1); */
        System.out.println(SUMofN(N));
        System.out.println(fabonaci(N));
        System.out.println("Enter a number ");
        int n = num.nextInt();
        System.out.println(sumOfDigits(n));
    }

//    tail recursion - recursion in which parent don't left to do something after child fun finished.

    public static void PrintNumbersNto1(int n){
        if (n==0 )
            return;
        System.out.print(n+"\t");  // this will print n to 1 is a tail recursion
        PrintNumbersNto1(n-1);

    }
    public static void PrintNumbers1toN(int n){
        if(n==0){
            return;
        }
        PrintNumbers1toN(n - 1); // recursively print the numbers from 1 to n-1
        System.out.print(n + " "); // print the current number

        //this is non tail recursion will take more time than PrintNumbers

    }
    public static void print1ToN(int n, int k){
        if (n==0)
            return;
        System.out.print(k+" ");
        print1ToN(n-1, k+1); // now this is tail recursion using one extra parameter
    }
    public static int fabonaci(int n){
        if (n<=1)
            return n;
        return fabonaci(n-1)+fabonaci(n-2);

    }
    public static int SUMofN(int n){
        if (n==0){
            return 0;
        }
        return n+SUMofN(n-1); // formula n(n+1)/2
    };
    public static int sumOfDigits(int n){
        if (n==0){
            return 0;
        }
        return (n%10)+sumOfDigits(n/10);
    }
}