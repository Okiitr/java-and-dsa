package DSA.math;

import java.util.Scanner;
import java.lang.Math;

public class CountDigits {
    //   first method using loop order of growth is theta log(n)
    static int countDigits(int n) {
        int count = 0;
        while (n > 0) {
            n = n / 10;
            count++;
        }
        return count;
    }

    //    2nd method using formula order of growth is theta 1
    static int countDigit(int n) {
        int c = (int) (java.lang.Math.log10(n) + 1);
        return c;
    }

    static void palindrome(int n) {
        int res = 0;
        int realNum = n;
        int lastDigit;
        while (n > 0) {
            lastDigit = n % 10;
            res = (res * 10 + lastDigit);
            n = n / 10;
        }
        if (res == realNum) {
            System.out.format("given number %d is a palindrome", realNum);
        } else {
            System.out.format("given number %d is not a palindrome", realNum);
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter a number to count digits :");
        Scanner num = new Scanner(System.in);
        int n = num.nextInt();
        System.out.println(countDigit(n));
        System.out.format("Total number of digits in %d = %d \n", n, countDigits(n));
        palindrome(n);
    }
}