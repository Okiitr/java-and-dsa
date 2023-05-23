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
        print1ToN(N,1);
        System.out.println(SUMofN(N));
        System.out.println(fabonaci(N));
        System.out.println("Enter a number ");
        int n = num.nextInt();
        System.out.println(sumOfDigits(n));
        String str ="oommoou";
        System.out.println(isPalindrome(str,0,6));
        System.out.println(maxPiece(23,12,5,6));
        String sets = "abc";
        String curr = " ";
        printSubSets(sets,0,curr);
        toh(4,'A','C','B');*/
        System.out.println(josephus1(5,3));
        System.out.println(josephus0(5,3));
        System.out.println(myJos(5,3));
        System.out.println(powerOfItsReverse(12,21));
    }
    public static long powerOfItsReverse(int N,int R)
    {    long MOD =1000000007;
        if (R == 0)
            return 1;
        long temp = powerOfItsReverse(N, R / 2) % MOD;
        long result = (temp * temp) % MOD; // from end we start squring (so that we can cover all powers)

        if (R % 2 == 0)
            return (long) result;
        else
            return (long) ((N * result) % MOD);

    }

    // JOSEPHUS PROBLEM
    public static int josephus1(int n , int k){
        if (n==1){ // if your count starts with 1;
            return 1;
        }
        return ((josephus1(n-1,k)+k-1)%n) + 1;
         /*We add k because we shifted the positions by k after the first killing.
        The problem with the above solution is that the value of (josephus(n-1, k) + k) can become n and overall solution can become 0.
        But positions are from 1 to n. To ensure that, we never get n, we subtract 1 and add 1 later. This is how we get*/
    }
    public static int josephus0(int n , int k){
        if (n==1){ // if your count starts with 1;
            return 0;
        }
        return (josephus0(n-1,k)+k)%n;  // in every cycle numbering chnges kth person become zeroth person
    }
    static int myJos(int n, int k)
    { // if position start with 1
        return josephus0(n, k) + 1;
    }
    public static void toh(int N, char A, char C, char B) { //most imp
        // in tower of hanoi
        if(N==1){ //moving very first disc from a to c
            System.out.println("move disk 1 from rod "+A+" to rod "+ C);
            return;
        }
        toh(N-1,A,B,C); // moving all other  n-1 disc from a to b using c
        System.out.println("move disk "+N +" from rod "+ A+" to rod "+ C);  // then moving last disc from a to c
        toh(N-1,B,C,A);  // then moving all n-1 that are at b from b to c using a

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
    public static boolean isPalindrome(String str,int s, int e){
        if (s>=e){ // in case of odd string and for even when s cross e return true 0(n)  time complexity
            return true;
        } // we checking the end points of string everytime and
        return ((str.charAt(s)) == (str.charAt(e)) && isPalindrome(str,s+1,e-1));
    }
    public static int maxPiece(int n,int a, int b, int c){
        if(n == 0)
            return 0;
        if(n <= -1)
            return -1;
        int res = Math.max(maxPiece(n-a, a, b, c), Math.max(maxPiece(n-b, a, b, c), maxPiece(n-c, a, b, c)));

        if(res == -1)
            return -1;
        //Time Complexity : O(3^n)
//  Space Complexity : O(n), due to recursive call stack.


        return res + 1;
    }
    public static void printSubSets(String str, int index, String curr){
        if(index==str.length()){
            System.out.println(curr);
            return;}
        // Two cases for every character
        // (i) We consider the character
        // as part of current subset
        // (ii) We do not consider current
        // character as part of current
        // subset
        printSubSets(str,index+1,curr);
        printSubSets(str, index+1,curr+str.charAt(index));

    }
}