package DSA.Search;

class SEARCH
{   //Binary search (devide into two parts)
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
                    return  mid;
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
    public static int totalCount(int []arr , int x){ //logn
       return  (findingLastOccurIndex(arr,x)-finding1stOccurIndex(arr,x)+1);
    }
//    public static int totalCountOfOne(int []arr , int x){
//        return (finding1stOccurIndex(arr,x)-findingLastOccurIndex(arr,x)+1);
//    }

    public static int squareRoot(int num){//log (n)
        int low=1, high= num, mid ,ans=0;
        while (low<=high){
            mid=(low+high)/2;
            if(mid*mid==num){
                return mid;
            }
            else if(mid*mid>num){
                high=mid-1;
            }
            else{
                low=mid+1;
                ans=mid;
            }
        }return ans;
    }

    // every we are doubling the index and when arr[i]>x for that time we come out of loop and will check if the
    // element is present in the range of i/2+1 to i-1;

    // this method is called unbound binary search will take O(logN) time
    public static int serchingElementInInfiniteArray(int []arr, int x){
        if(arr[0]==x){
            return 0;
        }
        int i=1;
        while (arr[i]<x){
            i=i*2;
        }
        if(arr[i]==x){
            return i;
        }
        else {
            return binarySearchRecursive(arr,(i/2)+1,i-1,x);
        }
    }
    /* a element is peak element if it is greater of equal both the side element;
    (mid==0 || arr[mid]>=arr[mid-1] ) && (mid==arr.length-1 || arr[mid]>=arr[mid+1])==
    (mid==0 && arr[mid]>=arr[mid+1]) || (mid==arr.length-1 &&  arr[mid]>=arr[mid-1]) || ( arr[mid]>=arr[mid-1] && arr[mid]>=arr[mid+1]) */
    public static int peakElement(int[]arr){
        int low =0, high =arr.length-1,mid;
        while (low<=high){
            mid=(low+high)/2;
            if( (mid==0 || arr[mid]>=arr[mid-1] ) && (mid==arr.length-1 || arr[mid]>=arr[mid+1]) ){
                return arr[mid];
            }
            else if( mid>0 &&  arr[mid]<=arr[mid-1]){
                high=mid-1;
            }
            else {
                low =mid+1;
            }

        }
        return -1;
    }

    public static int searchInSortedRotatedArray(int arr[], int x){
        int low =0, high=arr.length-1,mid;
        while (low<=high){
            mid=(low+high)/2;
            if(arr[mid]==x){
                return mid;
            }
            if(arr[low]<=arr[mid]){ // if left half is sorted or not
                if(x>=arr[low] && x<arr[mid]){
                    high =mid-1;
                }
                else{
                    low=mid+1;
                }
            }
            else{ // if right half is sorted or not
                if(x>arr[mid] && x<=arr[high]){
                    low =mid+1;
                }
                else{
                    high=mid-1;
                }
            }

        }
        return -1;
    }
    public static int minNumberRotatedArray(int arr[], int low, int high)
    {
        int mid,min=0;
        // Arrays.sort(arr);
        // return arr[low];
        if(arr[low]<arr[high]){
            return arr[low];
        }
        while(low<=high){
            mid=(low+high)/2;
            if(arr[mid]<arr[mid-1]){
                min= arr[mid];
                break;
            }
            if(arr[0]<arr[mid] ){
                low=mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return min;
    }

    // this method called as two pointer approach
    public static boolean pairSumInSortedArray(int []arr, int low, int high, int x){  //O(n) time complexity
//        int low=0, high =arr.length-1;
        while (low<=high)
        {
            if(arr[low]+arr[high]==x)
                return true;
           if(arr[low]+arr[high] >x) // if sum of low and high then again need to change high--
               high=high-1;
           else     // if less then we need to change low++
               low=low+1;
        }
        return false;
        }

    public static boolean tripletSumInSortedArray(int []arr, int x)
    {   int n =arr.length;
        for(int i=0; i<n; i++){ // O(N2)
            if(pairSumInSortedArray(arr,i+1,n-1,(x-arr[i])))
                return true;
        }
        return false;
    }
    public static int repeat(int arr[], int n)
    {  //O(N) TIME AND SPACE BOTH COMPLEXITIES
        boolean [] visit = new boolean[n];

        for(int i = 0; i < n; i++)
        {
            if(visit[arr[i]])
                return arr[i];
            visit[arr[i]] = true;
        }
        return -1;
    }
    public static int searchRepeatingElement(int [] arr, int n)
    {//O(n) and array start with 1
        int slow = arr[0], fast = arr[0];

        do{
            slow = arr[slow];
            fast = arr[arr[fast]];

        }while(slow != fast);

        slow = arr[0];

        while(slow != fast)
        {
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;
    }

    public static int sum(int arr[],int b, int e){
        int s=0;
        for(int i=b;i<=e;i++)
            s+=arr[i];
        return s;
    }

    public static int minPages(int arr[],int n, int k){
        if(k==1)
            return sum(arr,0,n-1);
        if(n==1)
            return arr[0];
        int res=Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            res=Math.min(res,Math.max(minPages(arr,i,k-1),sum(arr,i,n-1)));
        }
        return res;
    }

    public static boolean isFeasible(int []arr,int n,int k, int ans){
        int req=1,sum=0;
        for(int i=0;i<n;i++){
            if(sum+arr[i]>ans){
                req++;
                sum=arr[i];
            }
            else{
                sum+=arr[i];
            }
        }
        return (req<=k);
    }

    public static int minPages1(int [] arr,int n, int k){  //(nlog(sum)
        int sum=0,mx=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            mx=Math.max(mx,arr[i]);
        }
        int low=mx,high=sum,res=0;

        while(low<=high){
            int mid=(low+high)/2;
            if(isFeasible(arr,n,k,mid)){
                res=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return res;
    }

    public static double getMed(int a1[], int a2[], int n1, int n2)
    {  //O(logn1)
        int begin1 = 0, end1 = n1;

        while(begin1 <= end1)
        {
            int i1 = (begin1 + end1) / 2;
            int i2 = ((n1 + n2 + 1) / 2 )- i1;

            int min1 = (i1 == n1)?Integer.MAX_VALUE:a1[i1];
            int max1 = (i1 == 0)?Integer.MIN_VALUE:a1[i1 - 1];

            int min2 = (i2 == n2)?Integer.MAX_VALUE:a2[i2];
            int max2 = (i2 == 0)?Integer.MIN_VALUE:a2[i2 - 1];

            if(max1 <= min2 && max2 <= min1)
            {
                if((n1 + n2) % 2 == 0)
                    return ((double)Math.max(max1, max2) + Math.min(min1, min2)) / 2;
                else
                    return (double) Math.max(max1, max2);
            }
            else if(max1 > min2)
                end1 = i1 - 1;
            else
                begin1 = i1 + 1;
        }

        return -1;
    }

    public static void main(String[]args)
    {
        int []arr1={1,4,9,9,9,9,9,11,34,54,54,54,65,90};
       /* System.out.println(binarySearchIterative(arr1,54));
//        System.out.println(binarySearchRecursive(arr1,0,9,54));
        System.out.println(finding1stOccurIndex(arr1,54));
        System.out.println(findingLastOccurIndex(arr1,9));*/
        System.out.println(totalCount(arr1,54));
        System.out.println(squareRoot(49));
        int [] infinite_sorted_arr ={2,4,5,8,10,15,16,30,50,60,90,100,200,300,400};
        System.out.println(serchingElementInInfiniteArray(infinite_sorted_arr,36));

        int [] find_peak = {10,12,12,12,8,2,10};
        System.out.println(peakElement(find_peak));
        int [] rotated_arr ={16,30,50,60,90,100,200,300,400,2,4,5,8,10,15};
        System.out.println(searchInSortedRotatedArray(rotated_arr,90));
        System.out.println(pairSumInSortedArray(infinite_sorted_arr,0,14,600));
        System.out.println(tripletSumInSortedArray(infinite_sorted_arr,600));
        int [] arr2 ={65, 80, 83, 7, 19, 29, 35, 44, 52};
        System.out.println(minNumberRotatedArray(arr2,0,8));

        int arr3[] = {1, 3, 2, 4, 6, 5, 7, 3}, n= 8;
        System.out.println(repeat(arr3, n));
        System.out.println(searchRepeatingElement(arr3, n));

        int arr4[]={10,20,10,30};
        n=arr4.length;
        int k=2;
        System.out.println(minPages(arr4,n,k));
        System.out.println(minPages1(arr4,n,k));

        int a1[] = {10, 20, 30, 40, 50};
        int n1 = 5, n2 = 5;
        int [] a2 = {5, 15, 25, 35, 45};

        System.out.println(getMed(a1, a2, n1, n2));

    }


}