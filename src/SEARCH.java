package DSA.Search;

class SEARCH
{
    public static void main(String[]args)
    {
        int []arr1={1,4,9,9,9,9,9,11,34,54,54,54,65,90};
        System.out.println(binarySearchIterative(arr1,54));
//        System.out.println(binarySearchRecursive(arr1,0,9,54));
        System.out.println(finding1stOccurIndex(arr1,54));
        System.out.println(findingLastOccurIndex(arr1,9));


    }

    //Binary search (devide into two parts)
    // search in normal way takes O(n) time
    //binarySearchIterative takes 0(Log(n)) time and O(1) space  best
    //binarySearchRecursive takes 0(Log(n)) time and O(N) space
    public static int binarySearchIterative(int []sorted_arr,int x)
    {
        int n = sorted_arr.length;
        int low=0, high=n-1;
        int mid;

        while (low<=high){
            mid = (low+high)/2;
            if(sorted_arr[mid]==x)
                return mid;
            else if(sorted_arr[mid]<x)
                low=mid+1;
            else
                high=mid-1;
        }
        return -1;


    }
    public static int binarySearchRecursive(int []sorted_arr,int low, int high,int num)
    {

        if(low > high){
            return -1;
        }
        int mid = (low+high)/2;
        if(sorted_arr[mid]==num)
            return mid;
        else if(num > sorted_arr[mid])
            return binarySearchRecursive(sorted_arr,mid+1, high,num);
        else
            return binarySearchRecursive(sorted_arr,low,mid-1,num);

    }

    // this fun will find the 1st occurrence index of given element
    public static int finding1stOccurIndex(int []sorted_arr,int x)
    {
        int n = sorted_arr.length;
        int low=0, high=n-1;
        int mid;

        while (low<=high){
            mid = (low+high)/2;
            if(sorted_arr[mid]==x)
                if(mid==0 || sorted_arr[mid-1]!=x)
                    return mid;
                else
                    high=mid-1;
            else if(sorted_arr[mid]<x)
                low=mid+1;
            else
                high=mid-1;


        }
        return -1;


    }

    // this fun will find the 1st occurrence index of given element
    public static int findingLastOccurIndex(int []sorted_arr,int x)
    {
        int n = sorted_arr.length;
        int low=0, high=n-1;
        int mid;

        while (low<=high){
            mid = (low+high)/2;
            if(sorted_arr[mid]==x)
                if(mid==n-1 || sorted_arr[mid+1]!=x)
                    return mid;
                else
                    low=mid+1;
            else if(sorted_arr[mid]<x)
                low=mid+1;
            else
                high=mid-1;


        }
        return -1;


    }
}