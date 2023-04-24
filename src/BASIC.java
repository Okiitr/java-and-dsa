package com.company;


import java.math.BigInteger;
import java.util.Scanner;
import java.util.Vector;

public class BASIC {
    static int CountDigit(int x){
        int num = x;
        int count = 0;
        while(num!=0){
             num = num/10; //O(log(n)) or O(Number of digits in a given number)
             count++;
        }
        return count;
    };

    // TO CHECK TIME COMPLEXITY SEE THE CONDITION IN WHILE OR FOR LOOP
    static boolean IsPalindrome(int n) {
        int num =n;
        int res=0;;
        while ( num!=0){
            res = res*10+num%10;
            num/=10; //O(log(n)) or O(Number of digits in a given number)
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
            return n*Factorial1(n-1); // O(N)
        }
    };
    static int Factorial2(int x){
        int fact=1 ;
//
        for(int i = 1; i <= x; ++i) { // O(N)
            fact *= i;
        }
        return fact;
    };
    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++) { // O(N)
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
            m = m*5;  // time complexity O(log5n)
        }
        return zeros;
    };
    public static boolean IsPrime(int n){
        int value =  (int)(Math.sqrt(n))+1;
        boolean isprime = true ;
        if (n <= 1)
            return false;
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

    public static boolean isPrime(int n)
    {
        if (n <= 1)
            return false;

        // Check if n=2 or n=3
        if (n == 2 || n == 3)
            return true;

        // Check whether n is divisible by 2 or 3  TO make the code more efficient
        if (n % 2 == 0 || n % 3 == 0)
            return false;

        // Check from 5 to square root of n
        // Iterate i by (i+6)
        for (int i = 5; i <= Math.sqrt(n); i = i + 6)     //O(sqrt(n))
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }
    //    ecludien method for gcp
    public static int HCF2(int a ,int b){
        if(b==0){
            return a;
        }
          return HCF2(b,a%b);
    };

    public static int HCF1(int x ,int y){
        while(x!=y){
            if (x>y){
                x =x-y;
            }
            else {
                y=y-x;
            }
        }
        return x;
};
    public static int LCM1(int a, int b){

        return (a*b)/HCF2(a,b);

    };

    public static void PrimeFactors(int n){
        for (int i=2; i*i<=n; i++){ // sqrt(n)*log(n)  0(nlogn)
                    while (n%i==0){
                        System.out.println(i);
                        n=n/i;

            }
        }
        System.out.println(n);
    };
    public static void primeFactors(int n)
    {
        // Print the number of 2s that divide n
        while (n % 2 == 0) {
            System.out.print(2 + " ");
            n /= 2;
        }

        // n must be odd at this point. So we can
        // skip one element (Note i = i +2)
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            // While i divides n, print i and divide n
            while (n % i == 0) {
                System.out.print(i + " ");
                n /= i;
            }
        }

        // This condition is to handle the case when
        // n is a prime number greater than 2
        if (n > 2)
            System.out.print(n);
    };
    static void printDivisors(int n)
    {
        // Vector to store half of the divisors
        Vector<Integer> v = new Vector<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {

                // check if divisors are equal
                if (n / i == i)
                    System.out.printf("%d ", i);
                else {
                    System.out.printf("%d ", i);

                    // push the second divisor in the vector
                    v.add(n / i);
                }
            }
        }

        // The vector will be printed in reverse
        for (int i = v.size() - 1; i >= 0; i--)
            System.out.printf("%d ", v.get(i));
    };


    public static void Print(int n){
        for (int i=2; i<=n; i++){
            if (isPrime(i)){
                System.out.print(" "+i);
            }
        }
    };

    public static int itration(int x, int n){
        while (n>0){
            if(n%2!=0){
                1;
            }
            else { pass;
        }
    };
    public static void main(String[] args) {
        Scanner num = new Scanner(System.in);

/* //      Count digit and palindrome
        System.out.println("Enter a number for count digit");
        int x = num.nextInt();
        System.out.println("Total numbers in "+ x + " is = "+ CountDigit(x));
        System.out.println(IsPalindrome(x));

//       factorial and zeros
        System.out.println("Enter a number for Factorial");
        int n = num.nextInt();
//        System.out.println("M1-factorial of below 25 "+n+" is "+Factorial1(n));51545
        System.out.println("total no of zeros in factorial "+ TotalZero(n));
        System.out.println("factorial of above 25 "+n+" is "+factorial(n));*/

//      Prime number
        System.out.println("enter a num for prime ");
        int p = num.nextInt();
        System.out.println("your given number is prime "+IsPrime(p));
        PrimeFactors(p);
        printDivisors(p);
        Print(p);

//        Hcf AND lCM
//        System.out.println("enter two number for their hcf and lcf");
//        int a = num.nextInt();
//        int b = num.nextInt();
//        System.out.println("HCF of the numbers "+a+" and "+b+" = "+HCF1(a,b));
//        System.out.println("HCF of the numbers "+a+" and "+b+" = "+HCF2(a,b));
//        System.out.println("LCM of the numbers "+a+" and "+b+" = "+LCM1(a,b));

    }
}

