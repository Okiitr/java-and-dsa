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
        int [] arr4={30,1,4,5,4,99};
        System.out.println(largetstElement1(arr4));
        System.out.println(largetstElement2(arr4));
        System.out.println(largetstElement3(arr4));
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
}