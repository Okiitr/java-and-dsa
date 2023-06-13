package DSA.Sorting;

import java.util.*;

class SORTING {
    public static void main(String[] args) {
       /* int [] arr = {3,2,33,4,5,44,5,666,5,4,33,7,8};
        inBuiltSortingFunctions(arr);

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
        int [] mer ={2,4,9,33,90, 20,41,44,95};
        int [] mer1 ={2,4,9,33,44,90,43,44,100};
        mergeTwoSortedArrays(arr,brr);
        merge(mer,0,5,9);
        mergeSort(mer1,0,9);
        System.out.println(Arrays.toString(mer1));

        int [] inverse ={20,40,9,13,34,12};
        System.out.println(countInversion(inverse,0,5));

        int [] sorted_array1 = { 2,4,4,5,9,11,24,24,45,50};
        int [] sorted_array2 = { 2,3,7,9,15,24,45,45 ,60};
        intersectionOfTwoSortedArrays(sorted_array1,sorted_array2);
        System.out.println( );
        unionOfTwoSortedArrays(sorted_array1,sorted_array2);


        //partition and quick sort

        int [] naive ={ 2,11,45,15,32,4,15,10,6,16};
        int n = naive.length;
        naivePartition(naive,0,n-1,n-1);
        System.out.println(Arrays.toString(naive));

        int [] lomuto ={ 2,11,45,15,32,4,15,10,6,12};
        int n1 = lomuto.length;
        lomutoPartion(lomuto,0,n-1);
        System.out.println(Arrays.toString(lomuto));

        int [] hoare ={13 ,11,45,15,32,4,15,10,6,12};
        int n2 = hoare.length;
        hoarePartion(hoare,0,n2-1);
        System.out.println(Arrays.toString(hoare));
        lomutoPartion(hoare,0,n2-1); // in lomuto pivot will be always in middle but in hoare its at random position
        System.out.println(Arrays.toString(hoare));  */

        int[] quick_sortl = {34, 3, 43, 29, 89, 33, 4, 20, 56};
        int[] quick_sorth = {11, 45, 34, 55, 8, 90, 56, 23, 17};
        quickSortLomuto(quick_sortl, 0, 8);
        quickSortHoare(quick_sorth, 0, 8);
        System.out.println(Arrays.toString(quick_sortl));
        System.out.println(Arrays.toString(quick_sorth));
        int[] small = {23, 4, 55, 3, 44, 40, 6, 75, 40};
        System.out.println(kthSmallestElement(small, 5));


    }

    public static void inBuiltSortingFunctions(int[] arr) {
        // for arrays only Arrays.sort()  time complexity is O(n log(n)) same for collection.sort

        Arrays.sort(arr, 2, 5);
        System.out.println(Arrays.toString(arr));

        Integer[] arrr = {5, 20, 10, 12};  // non primitive array
        Arrays.sort(arrr, Collections.reverseOrder());
        // [fromindex , toindex)   // Sort subarray from index 2 to 4, i.e.,

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arrr));

        // Array of 3 objects
        //Sorting an array of Non-Primitive types by implementing Comparable interface.
        Point[] arr1 = {new Point(10, 20), new Point(3, 12), new Point(5, 7)};
        Arrays.sort(arr1);
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i].x + " " + arr1[i].y);
        }


        // Sorting the object containing the array
        // by passing the array and object MyCmp
        Point1[] arr2 = {new Point1(8, 20), new Point1(5, 12), new Point1(0, 7)};
        Arrays.sort(arr2, new MyCmp());

        // Displaying the sorted array
        for (int i = 0; i < arr2.length; i++)
            System.out.println(arr2[i].x + " " + arr2[i].y);

    }

    /* Bubble sort -  algorithm that works by repeatedly swapping the adjacent elements if they are in the wrong order.
     This algorithm is not suitable for large data sets as its average and worst case time complexity is quite high.
     */
    public static void bubbleSort(int[] arr) {
        // stable inplace and (n2)
        int n = arr.length;
        // total n-1 pass in worst case reverse
        for (int i = 0; i < n - 1; i++) {
            for (int j = 1; j < n - 1 - i; j++) {
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

    public static void selectionSort(int[] arr) {
        // unstable , inplace  and N2
        int n = arr.length;
        int min_index;
        for (int i = 0; i < n - 1; i++) {
            min_index = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;

        }
        System.out.println(Arrays.toString(arr));
    }


    /* Insertion sort is efficient for small data values ,
     is appropriate for data sets which are already partially sorted.
     */

    public static void insertionSort(int[] arr) {
        // stable , inplace  and N2
        int n = arr.length;
        int j, key;
        for (int i = 1; i < n; i++) {
            key = arr[i];
            j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }

        System.out.println(Arrays.toString(arr));
    }

    /* merge sort starts from here
     * T(n) = 2T(n/2) + Θ(n)
     * Time complexity of Merge Sort is Θ(nLogn) in all 3 cases (worst, average and best)
     * as merge sort always divides the array in two halves and take linear time to merge two halves */
    public static void mergeTwoSortedArrays(int[] arr, int[] brr) {
        int n = arr.length;
        int m = brr.length;
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (arr[i] <= brr[j]) {
                System.out.println(arr[i]);
                i++;
            } else {
                System.out.println(brr[j]);
                j++;
            }
        } // time complexity O(m+n)
        while (i < n) {
            System.out.println(arr[i]);
            i++;
        }
        while (j < m) {
            System.out.println(brr[j]);
            j++;
        }
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1, n2 = high - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = arr[i + low];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = arr[i + mid + 1];
        }
        int i = 0, j = 0, k = low;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                k++;
                i++;
            } else {
                arr[k] = right[j];
                k++;
                ;
                j++;
            }
        } // time complexity O(n) ans space also O(n);
        while (i < n1) {
            arr[k] = left[i];
            k++;
            i++;
        }
        while (j < n2) {
            arr[k] = right[j];
            k++;
            ;
            j++;
        }
//        System.out.println(Arrays.toString(arr));
    }

    //merge sort
    public static void mergeSort(int arr[], int l, int r) { //Θ(nLogn)
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

    public static int countAndMerge(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1, n2 = high - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = arr[i + low];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = arr[i + mid + 1];
        }
        int res = 0, i = 0, j = 0, k = low;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                k++;
                i++;
            } else {  // when right element is smaller then update the res
                arr[k] = right[j];
                res = res + (n1 - i);
                k++;
                ;
                j++;
            }
        } // time complexity O(n) ans space also O(n);
        while (i < n1) {
            arr[k] = left[i];
            k++;
            i++;
        }
        while (j < n2) {
            arr[k] = right[j];
            k++;
            j++;
        }
        return res;
//        System.out.println(Arrays.toString(arr));
    }

    public static int countInversion(int arr[], int l, int r) { //Θ(nLogn)
        int res = 0;
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            res += countInversion(arr, l, m);
            res += countInversion(arr, m + 1, r);

            // Merge the sorted halves
            res += countAndMerge(arr, l, m, r);
        }
        return res;
    }

    public static void intersectionOfTwoSortedArrays(int[] arr, int[] brr) {
        int n = arr.length, m = brr.length;

        int i = 0, j = 0;
        while (i < n && j < m) {
            if (i > 0 && arr[i] == arr[i - 1]) {  // to avoid duplicates  O(N + M)  O(max(m*log(m), n*log(n)) + min(m, n) )
                i++;
                continue;
            }
            if (arr[i] == brr[j]) {
                System.out.print(arr[i] + " ");
                i++;
                j++;
            } else if (arr[i] < brr[j]) {
                i++;
            } else {
                j++;
            }
        }

    }

    public static void unionOfTwoSortedArrays(int[] arr, int[] brr) {
        int n = arr.length, m = brr.length;
        // O(n+m).
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                i++;
                continue;
            }
            if (j > 0 && brr[j] == brr[j - 1]) {  // we have to check duplicates for both the arrays
                j++;
                continue;
            }
            if (arr[i] == brr[j]) {
                System.out.print(arr[i] + " ");
                i++;
                j++;
            } else if (brr[j] < arr[i]) {
                System.out.print(brr[j] + " ");
                j++;
            } else {
                System.out.print(arr[i] + " ");
                i++;
            }
        }
        while (i < n) {   // to print rest elements
            if (arr[i] == arr[i - 1]) {
                i++;
            } else {
                System.out.print(arr[i] + " ");
                i++;
            }
        }

        while (j < m) {
            if (brr[j] == brr[j - 1]) {
                j++;
            } else {
                System.out.print(brr[j] + " ");
                j++;
            }
        }

    }


    /*Naive partition: In this partition helps to maintain the relative order of the elements but this partition takes O(n) extra space.
    Lomuto partition: In this partition, The last element chooses as a pivot in this partition.
    The pivot acquires its required position after partition but more comparison takes place in this partition.
    Hoare's partition: In this partition, The first element chooses as a pivot in this partition.
    The pivot displaces its required position after partition but less comparison takes place as compared to the Lomuto partition.*/


    public static void naivePartition(int[] arr, int l, int h, int p) {

        int n = arr.length;
        int[] temp = new int[h - l + 1];
        int index = 0;

        for (int i = l; i <= h; i++) {
            if (arr[i] <= arr[p] && i != p) {
                temp[index++] = arr[i];

            }
        }

        temp[index] = arr[p];  // temp[index++]=arr[p];
        index++;
        // here we are assigning pivot on index+1 position and increasing value of index also same
        for (int i = l; i <= h; i++) {
            if (arr[i] > arr[p]) {
                temp[index] = arr[i];
                index++;
            }
        }

        for (int i = l; i <= h; i++) {
            arr[i] = temp[i - l];
        }

    }

    public static int lomutoPartion(int[] arr, int l, int h) {
        // consider that the pivot is arr[h]
        // for the best case use random pivot
       /* int p = (int)(Math.random() * (h-l+1)) + l;   this case will always take time nlogn in every case;
        int tmp = arr[h];
        arr[h] =arr[p];
        arr[p] = tmp;
        int pivot = arr[p]; */

        int pivot = arr[h];
        int i = l - 1; // this is out  <pivot band
        for (int j = l; j <= h; j++) {
            if (arr[j] < pivot) {
                int tmp = arr[i + 1];
                arr[i + 1] = arr[j];
                arr[j] = tmp;
                i++;
            }
        }
        int position = i + 1;
        int tmp = arr[i + 1];
        arr[i + 1] = pivot;
        arr[h] = tmp;
        return position;
    }

    static int kthSmallestElement(int arr[], int k) {
        int n = arr.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int p = lomutoPartion(arr, l, r);
            if (p == k - 1)
                return arr[p];
            else if (p > k - 1)
                r = p - 1;
            else
                l = p + 1;
        }
        return -1;
    }

    public static int hoarePartion(int[] arr, int l, int h) {
        // consider that the pivot is arr[h]
        int pivot = arr[l];
        int i = l - 1;     // this is out  <= pivot band
        int j = h + 1;   // this is out  >pivot band
        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j--;
            } while (arr[j] > pivot);
            if (i >= j) {
                return j;
            }
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    /*Best Case: The best case occurs when the partition process always picks the middle element as pivot.
       Following is recurrence for best case.   T(n) = 2T(n/2) + Θ(n)   Θ(nLogn).
    */
    /* the worst case would occur when the array is already sorted in increasing or decreasing order.
    Following is recurrence for worst case.
     T(n) = T(n-1) + Θ(n)    Θ(n2).
     here 0(N) time is required for partions

     it requires 0(logn ) space for recursion call its inplace algo that don't use any extra array to copy element
     but extra space it will take
     */
    public static void quickSortLomuto(int[] arr, int l, int h) {
        if (l < h) {
            int p = lomutoPartion(arr, l, h); // it will return to position of pivot
            quickSortLomuto(arr, l, p - 1);  // we sort before pivot
            quickSortLomuto(arr, p + 1, h);  // then we sort after pivot

        }
    }

    /* for tail elimination in quict sort*/
    public static void quickSortLomutoTailElimination(int[] arr, int l, int h) {
        if (l < h) {
            int p = lomutoPartion(arr, l, h); // it will return to position of pivot
            if (p - l < h - p) {
                quickSortLomutoTailElimination(arr, l, (p - 1));
                l = p + 1;
            } else {
                quickSortLomutoTailElimination(arr, p + 1, h);
                h = p - 1;
            }

        }
    }

    public static void quickSortHoare(int[] arr, int l, int h) {
        if (l < h) {
            int p = hoarePartion(arr, l, h);  //this will give the index upto all are less than pivot
            quickSortHoare(arr, l, p);  // sorting less then pivot values
            quickSortHoare(arr, p + 1, h);  // sorting equal or greater than pivot values

        }
    }

    static void cycleSortDistinct(int[] arr, int n) {
        for (int cs = 0; cs < n - 1; cs++) {
            int item = arr[cs];
            int pos = cs;
            for (int i = cs + 1; i < n; i++)
                if (arr[i] < item)
                    pos++;
            //swap(item,arr[pos])

            int temp = item;
            item = arr[pos];
            arr[pos] = temp;
            while (pos != cs) {
                pos = cs;
                for (int i = cs + 1; i < n; i++)
                    if (arr[i] < item)
                        pos++;

                //swap(item,arr[pos])
                temp = item;
                item = arr[pos];
                arr[pos] = temp;
            }

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