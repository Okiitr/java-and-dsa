package DSA.Sorting;

import java.util.*;

class SORTING {
    public static void main(String[] args) {
       /* int [] arr = {3,2,33,4,5,44,5,666,5,4,33,7,8};
        inBuiltSortingFunctions(arr);*/

        // bubble sort
        int [] bubble_arr = { 23,4,55,30,44,3,55,33,87,90};
        bubbleSort(bubble_arr);

        // selection sort
        int [] selection_arr = { 23,40,55,30,44,30,55,33,87,90};
        selectionSort(selection_arr);

        //insetion sort
        int [] insert_arr = { 23,40,55,3,4,30,5,33,87,90};
        insertionSort(insert_arr);

        //merge two sorted array
        int [] arr ={2,4,9,33,44,90};
        int [] brr ={20,41,44,95};
        int [] mer ={2,4,9,33,44,90, 20,41,44,95};
        int [] mer1 ={2,4,9,33,44,90, 22,43,44,100};
        mergeTwoSortedArrays(arr,brr);
        merge(mer,0,5,9);
        mergeSort(mer1,0,9);
        System.out.println(Arrays.toString(mer1));
}
    public static void inBuiltSortingFunctions(int [] arr){
        // for arrays only Arrays.sort()  time complexity is O(n log(n)) same for collection.sort

        Arrays.sort(arr,2,5);
        System.out.println(Arrays.toString(arr));

        Integer[] arrr = {5, 20, 10, 12};  // non primitive array
        Arrays.sort(arrr, Collections.reverseOrder());
         // [fromindex , toindex)   // Sort subarray from index 2 to 4, i.e.,

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arrr));

        // Array of 3 objects
        //Sorting an array of Non-Primitive types by implementing Comparable interface.
        Point [] arr1 = {new Point(10, 20), new Point(3, 12),new Point(5, 7) };
        Arrays.sort(arr1);
        for(int i = 0; i < arr1.length; i++)
        {System.out.println(arr1[i].x + " " + arr1[i].y);}


        // Sorting the object containing the array
        // by passing the array and object MyCmp
        Point1 [] arr2 = {new Point1(8,20), new Point1(5,12),new Point1(0,7) };
        Arrays.sort(arr2, new MyCmp());

        // Displaying the sorted array
        for(int i = 0; i < arr2.length; i++)
            System.out.println(arr2[i].x + " " + arr2[i].y);

    }
    /* Bubble sort -  algorithm that works by repeatedly swapping the adjacent elements if they are in the wrong order.
     This algorithm is not suitable for large data sets as its average and worst case time complexity is quite high.
     */
    public static void bubbleSort(int []arr){
        // stable inplace and (n2)
        int n = arr.length;
        // total n-1 pass in worst case reverse
        for(int i = 0; i< n-1; i++){
            for(int j = 1; j<n-1-i; j++) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /*The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order)
    from unsorted part and putting it at the beginning. The algorithm maintains two subarrays in a given array.
    */
    //selection sort

    public static void selectionSort(int []arr){
        // unstable , inplace  and N2
        int n = arr.length;
        int min_index;
        for(int i =0; i<n-1; i++){
            min_index =i;
            for(int j =i+1; j<n; j++){
                if(arr[j]<arr[min_index]){
                    min_index=j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] =temp;

        }
        System.out.println(Arrays.toString(arr));
    }


    /* Insertion sort is efficient for small data values ,
     is appropriate for data sets which are already partially sorted.
     */

    public static void insertionSort(int []arr){
        // stable , inplace  and N2
        int n = arr.length;
        int j , key;
        for(int i =1; i<n; i++){
            key = arr[i];
            j = i-1;
            while (j >= 0 && arr[j] > key)
            {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void mergeTwoSortedArrays(int []arr, int []brr){
        int n = arr.length;
        int m = brr.length;
        int i=0,j=0;
        while (i<n && j<m){
            if(arr[i]<=brr[j]){
                System.out.println(arr[i]);
                i++;
            }
            else {
                System.out.println(brr[j]);
                j++;
            }
        } // time complexity O(m+n)
        while (i<n){
            System.out.println(arr[i]);
            i++;
        }
        while (j<m){
            System.out.println(brr[j]);
            j++;
        }
    }

    public static void merge(int []arr, int low, int mid, int high){
        int n1 =mid-low+1, n2 = high-mid;
        int [] left =new int[n1];
        int [] right= new int[n2];

        for(int i=0; i<n1; i++){
            left[i]=arr[i+low];
        }
        for(int i=0; i<n2; i++){
            right[i]=arr[i+mid+1];
        }
        int i=0,j=0 , k = low;
        while (i<n1 && j<n2 ){
            if(left[i]<=right[j]){
                arr[k]=left[i];
                k++;
                i++;
            }
            else {
                arr[k]=right[j];
                k++;;
                j++;
            }
        } // time complexity O(n) ans space also O(n);
        while (i<n1){
            arr[k]=left[i];
            k++;
            i++;
        }
        while (j<n2){
            arr[k]=right[j];
            k++;;
            j++;
        }
//        System.out.println(Arrays.toString(arr));
    }

    //merge sort
    public static void mergeSort(int arr[], int l, int r)
    { //Θ(nLogn)
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

}

// A user-defined Point class implementing
// Comparable interface
class Point implements Comparable<Point>
{
    int x, y;

    // Costructor intialising x & y
    Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    // compareTo() function defining the
    // nature of sorting i.e., according to
    // x-coordinate
    public int compareTo(Point P)
    {
        // Comparing two objects by
        // Subtracting the passed object
        // from current object
        return this.y - P.y;
    }
}


// Point class which does not implement
// Comparable interface. Thus the objects
// of this class are not comparable.
class Point1
{
    int x, y;
    Point1(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}

// This class implements
// Comparator interface to compare
class MyCmp implements Comparator<Point1>
{
    // Sorts the Point objects according
    // to x-coordinates in natural order

    public int compare(Point1 p1, Point1 p2) {
        return p1.x - p2.x;
    }
}