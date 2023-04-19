package DSA.math;


import java.util.Scanner;

public class Factorial{
    static int fact1(int n){
        if(n==1 || n==0){
            return 1;
        }
        return n*fact1(n-1);
    }
    static int fact2(int n){
        int fact =1;
        for(int i=1; i<=n; i++){
            fact*=i;
        }
        return fact;
    }
//both the function having theta n time complexity but recursive function has theta n space complexity and other has theta 1
    public static void main(String[] args) {
        System.out.println("enter a number to find factorial");
        Scanner scan =new Scanner(System.in);
        int n = scan.nextInt();
        System.out.format("factorial of %d is %d and %d ",n,fact1(n),fact2(n) );
    }
}
