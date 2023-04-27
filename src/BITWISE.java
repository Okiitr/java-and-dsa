package DSA.Binary;

import java.util.Scanner;

public class BITWISE {

    public static boolean IsBitSet(int n, int k){
        int temp = 1<<(k-1);
        return (n & temp) != 0;  //  O(1) time complexity
        // or return ((n>>(k-1) & 1) != 0);

        /* if((n & temp) != 0){
            return true;
        }else {
            return false;
        }
        the same thing can we written as return (n & temp) != 0; */


    };
    public static boolean IsBitSet1(int n, int k){
        for (int i=1; i<=(k-1); i++){
            n = n/2;
        }
        return (n & 1) !=0;

    };

    public static int CountSetBits(int n){
        int count = 0;
        while (n>0){
            if ( (n % 2)!=0){
                count++;
                n=n/2;   // n/2 = n>>1  time complexity O(Log(n)) O(d) d is from last to most significant bit
            }
            else n =n/2;
        }
        return count;
    };
    public static int countSetBits1(int n)
    { //Brian and Kerningham Algorithm     O(d) d is from last to most significant bit
        int count = 0;
        while (n > 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    };

    static int []table = new int[256]; /* 256 is 2 power 8 we devide 32 bits in 4 sagments  0xff = 255 */

    // recursive function to count set bits
    public static void initialize() {

        // To initially generate the table algorithmically:
        table[0] = 0;
        for (int i = 1; i < 256; i++)
        {
//            table[i] = (i & 1) + table[i / 2] or;
            table[i] = table[i&(i-1)]+1;
        }
    }

    public static int countSetBits2(int n)
    {  // time complexity is 0(1) no time taken
        return table[n & 255] /* this is counting is first 8 bits which one is set*/ +
                table[(n >> 8) & 0xff] + /* n>>8 is removing last 8 bits and now 24 is left */
                table[(n >> 16) & 0xff] +
                table[n >> 24];
    }

    public static boolean isPowerOfTwo1(int n){
        if (n==0){
            return false;
        }
        while (n>1){
            if (n%2!=0){
                return false;
            }
            n=n/2;  //O(log(n)
        }
        return true;
    };
    public static boolean isPowerOfTwo(int N){
        if (N==0){
            return false;
        }
        return ( (N & (N-1)) == 0); //0(1)
    }

    public static int OneOddOccur( int arr []) {
        int value =0;
        for (int i=0; i<arr.length; i++){  // O(arr.length)
            value = value^arr[i];
        }
        return value;
    }
    public static int findOdd(int arr[])
    {
        for(int i = 0; i < arr.length; i++) //O(n2)
        {
            int count = 0;

            for(int j = 0; j < arr.length; j++)
            {
                if(arr[i] == arr[j])
                    count++;
            }

            if(count % 2 != 0)
                return arr[i];

        }

        return 0;
    }
    public static int getMissingNo(int a[])
    {
        int x1 = a[0];
        int x2 = 1;

        // For xor of all the elements in array
        for (int i = 1; i < a.length; i++)
            x1 = x1 ^ a[i];

        // For xor of all the elements from 1 to n+1
        for (int i = 2; i <= a.length + 1; i++)
            x2 = x2 ^ i;

        return (x1 ^ x2); /* basic rules are x^0=x, x^x=0, x^y^z=z^y^x */
    }

    public static void main(String[] args) {
        System.out.println("hello binary ");
        Scanner num = new Scanner(System.in);
        System.out.println("Enter a number ");
        int n = num.nextInt();
//        System.out.println("Enter value of k  ");
//        int k = num.nextInt();
//        System.out.println(IsBitSet(n,k));
//        System.out.println(IsBitSet1(n,k));
        System.out.println("total set bits in "+n+" is "+CountSetBits(n));
        System.out.println("total set bits in "+n+" is "+ countSetBits1(n));
        initialize(); /* initialising the table */
        System.out.println("total set bits in "+n+" is "+ countSetBits2(n));
        System.out.println("The given number "+n+" is power of 2 "+isPowerOfTwo(n));
        System.out.println("The given number "+n+" is power of 2 "+isPowerOfTwo1(n));

        int arr[] = {2,3,4,2,3,4,2,3,4,2,3};
        System.out.println("odd occurance of in arr is "+ OneOddOccur(arr));
        System.out.println("odd occurance of in arr is "+ findOdd(arr));
        int arr1[] = { 1, 2, 3, 5 };
        System.out.println("missing number in array "+arr1+" is "+getMissingNo(arr1));

    }
}