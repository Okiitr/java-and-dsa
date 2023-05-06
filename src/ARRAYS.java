package DSA.Arrays;

import java.util.Arrays;

class ARRAYS{
    public static void main(String[] args) {
        int [] arr1 = {11,5,31,45, };
        System.out.println(Arrays.toString(insertingEnd(arr1, 50)));
        int [] arr2 = new int[6];
        arr2= new int[]{1, 2, 3, 4, 4};
        System.out.println(Arrays.toString(insertingAtIndex(arr2, 3,8 )));
        int [] arr3={11,5,31,45,36,60};
        System.out.println(Arrays.toString(deleteItem(arr3, 31)));
        int [] arr4={10,3,36,4,5,6};
        System.out.println(largetstElement1(arr4));
        System.out.println(largetstElement2(arr4));
        System.out.println(largetstElement3(arr4));
        System.out.println(secondLargetstElement(arr4));
        System.out.println(isArraySorted(arr4));
//        System.out.println(Arrays.toString(swap(arr4, 0, 60)));
        int [] arr5={10,3,36,4,5,6};
        System.out.println(Arrays.toString(reverse(arr5)));
        System.out.println(Arrays.toString(reverseArray(arr5)));
        int [] arr6={10,20,20,30,30,30,30};
        System.out.println(removeDuplicates(arr6));


    }

    // Operations on arrays

    //1. inserting an element
    public static int [] insertingEnd(int arr[], int k){
        arr[arr.length-1]=k;
        return arr;  // constant time O(1)
    }
    public static int [] insertingAtIndex(int arr[],int index, int k){
       for(int i=arr.length-1; i>index; i--){ //takes O(N) Time in worst case;
           arr[i]=arr[i-1];
       }
       arr[index]=k;
       return arr;
    }
    public static int [] deleteItem(int arr[], int k){
        int index = 0;
        for(int i=0; i<arr.length-1; i++){ //takes O(N) Time in worst case;
            if(arr[i]==k){
                index = i;
            }
        }
        for (int i=index+1;  i<arr.length; i++){
            arr[i-1]=arr[i];
        }
       return arr;
    }

    public static int largetstElement1(int [] arr){
        int largest = 0;
        for(int i=0;i<arr.length; i++){
            largest=Math.max(arr[i],largest);  //O(N)
        }
        return largest;
    }
    public static int largetstElement3(int [] arr){
        int largest = 0;
        for(int i=1;i<arr.length; i++){
            if(arr[i]>=arr[largest]){
                largest = i;  //0(n)
            }
        }
        return arr[largest];
    }
    public static int largetstElement2(int [] arr){
        int largest = 0;
        for(int i=0;i<arr.length; i++){
            boolean flag = true;
           for (int j=i; j<arr.length; j++){
               if(arr[j]>arr[i]){  //O(n2)
                   flag =false;
                   break;
               }
           }
           if (flag){
               return arr[i];
           }
        }
        return -1;
    }

    public static int secondLargetstElement(int [] arr){
        int largest = 0;
        int res = -1;
        for(int i=1;i<arr.length; i++){
            if(arr[i]>arr[largest]){
                res = largest;
                largest = i;  //0(n)
            }
            else if( arr[i]!=arr[largest]  ){ // ith element is less than largest then loop run
                if(res ==-1 || arr[i]>arr[res]){
                        res = i; // if upto now res -1 then the element lesser then largest will become second largest
                }
            }
        }
        if (res==-1)  // all elements are same
            return res;
        return arr[res];
    }
    public static boolean isArraySorted(int [] arr){

        for(int i=1; i< arr.length; i++){
            if(arr[i]<arr[i-1]){
                return false;
            }
        }return true;
    }
   public static int [] swap(int [ ] arr,int a,int b){
        int x=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]==a){
                arr[i]=b;
                x=i;}
        }
        for(int j=x+1; j<arr.length; j++){
            if (arr[j] == b) {
                arr[j] = a;
                break;
            }
        }
        return arr;
    }
    public static int [] reverseArray(int []arr){

        int n = arr.length;
        for(int i=0; i<n/2; i++){
            swap(arr,arr[i],arr[n-1-i]);
        }
        return arr;
    }
    public static int[] reverse(int[] arr)
    {
        int low = 0, high = arr.length - 1;

        while(low < high)
        {   // this is the best way to swap two number using 3rd variable  O(N)
            int temp = arr[low];

            arr[low] = arr[high];

            arr[high] = temp;

            low++;
            high--;
        }
        return arr;
    }
    public static int removeDuplicates(int []arr){
        int res=1;
        for (int i=1; i<arr.length; i++){
            if(arr[i]!=arr[res-1]){ // checking last element is not equal to next element only distinct elements
                arr[res]=arr[i];   //O(n) time complexity ane o(1) space complexity.
                res++;
            }
        }return res;
    }
}