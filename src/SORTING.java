package DSA.Sorting;

import java.util.*;

class SORTING {
    public static void main(String[] args) {
        int [] arr = {3,2,33,4,5,44,5,666,5,4,33,7,8};
        inBuiltSortingFunctions(arr);
}
    public static void inBuiltSortingFunctions(int [] arr){
        // for arrays only Arrays.sort()

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