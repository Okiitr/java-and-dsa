package DSA.Arrays;

import java.util.Arrays;

class ARRAYS{
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
    public static int[] reverse(int[] arr,int l, int h)
    {
        int low = l;
        int high = h;

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
    public static int [] moveZerosToEnd(int []arr){
        int count=0;// count of non zero elements
        for (int i=0; i<arr.length; i++){
            if(arr[i]!=0){  // we searching non zero element and replacing it with 1st zero
                arr[count++]=arr[i];  // the index of zeroth element is count of non zero element
            }
        }
        for (int i=count; i<arr.length; i++){
           arr[i]=0;   // seting all last element as 0
        }return arr;

    }
    public static int [] leftRotate(int[]arr){
        int fist = arr[0];
        for (int i = 1; i< arr.length; i++){
            arr[i-1]=arr[i];
        }
        arr[arr.length-1]=fist;
        return arr;
    }
    public static int [] leftRotateD1 (int[]arr,int d){
        for(int i=0; i<d; i++){
            leftRotate(arr);
        }    // time complexity 0(N*D)
        return arr;
    }

    public static int [] leftRotateD2 (int[]arr,int d){
      /*  int intArray[];    //declaring array
        intArray = new int[20];  // allocating memory to array*/
        int[] first = new int[d]; // combining both statements in one
        for (int i = 0; i<d; i++){ // coping initial d elements
            first[i]=arr[i];
        }               // time complexity is 0(N) AND 0(d) extra space
        for(int i=d; i< arr.length; i++){  // shifting rest elements
            arr[i-d]=arr[i];
        }
        for(int i= 0; i<d; i++){
            arr[arr.length-d+i]=first[i];
        }

        return arr;
    }
    public static int [] leftRotateD3 (int[]arr,int d){
        int n = arr.length;
        reverse(arr,0, d-1);   // reversing first d element
        reverse(arr,d,n-1);      // reversing last d to n element
        reverse(arr,0,n-1);   // reversing the whole array now
                                   // time complexity 0(N) zero extra space
        return arr;
    }
    public static void leader(int[] arr){
        for(int i=0; i<arr.length; i++){
            boolean flag = true;
            for(int j =i+1; j<arr.length; j++){
                if(arr[i]<=arr[j]){
                    flag = false;
                }
            }
            if(flag){
                System.out.print(arr[i]+" ");
            }
        }
    }
    public static void leader2(int[] arr){
        int n = arr.length;
        int curr_leader =arr[n-1];
        System.out.print(curr_leader+" ");
        for (int i=n-2; i>=0; i--){   // traversing from last element 0(N) time complexity
            if(arr[i]>curr_leader){
                curr_leader =arr[i];
                System.out.print(curr_leader+" ");
            }
        }
    }

    public static int maxdifference(int [] arr){
        int n = arr.length;
        int max = 0;
        for (int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                max=Math.max(arr[j]-arr[i],max);  //O(N2)
             //   max= arr[j]-arr[i]>max? arr[j]-arr[i]:max;  // using lamda function
            }
        }
        return max;
    }
    public static int maxdifference1(int [] arr){
        int n = arr.length;
        int max = arr[0]-arr[1];
        int minmum_value =arr[0];
        for (int i=1; i<n; i++){
            max = Math.max(max,arr[i]-minmum_value);
            minmum_value = Math.min(arr[i],minmum_value);
        }
        return max;
    }
    public static void frequency(int []arr){
        int freq =1;
        int n= arr.length;
        int i =1;
        while(i<n){
            while (i<n && arr[i-1]==arr[i]){
                freq++;
                i++;
            }
            System.out.println(arr[i-1]+" "+freq);
            i++;
            freq=1;
        }
        if(n==1 || arr[n-1]!=arr[n-2]){
            System.out.println(arr[n-1]+" "+1);
        }
    }

   public static int maxProfit(int price[], int start, int end)
    {
        if(end <= start)
            return 0;

        int profit = 0;

        for(int i = start; i < end; i++)
        {
            for(int j = i + 1; j <= end; j++)
            {
                if(price[j] > price[i])
                {
                    int curr_profit = price[j] - price[i]
                            + maxProfit(price, start, i - 1)   // claulating profit left of i
                            + maxProfit(price, j + 1, end);  // calculatint profit right of j

                    profit = Math.max(profit, curr_profit);
                }
            }
        }

        return profit;
    }
    public static int stockBuySell(int []arr){
        int profit =0;
        for(int i=1; i<arr.length; i++){
            if(arr[i]>arr[i-1]){
                profit = profit+arr[i]-arr[i-1];  //O(n) time complexity commulative profit
            }
        }return profit;
    }
    public static int maxConsicutiveOne(int []arr){
        int ones =0;
        int res=0;
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i]==1){
                ones++;
            }
            else{
                res =Math.max(res,ones);  // before resetting count compare  previous count with max
                ones =0;
            }
        }return res;
    }

    public static int trappingRainWater(int[]arr){
        int total = 0;
        int n = arr.length;

        for(int i = 1; i < n-1; i++)  // O(N2) time complexity and O(1) SPACE COMPLEXITY
        {
            int lmax= arr[0];
            for (int j = 0; j<=i; j++)
            {
                if( arr[j]>=lmax){
                    lmax =arr[j];
                }
            }

            int rmax= arr[n-1];
            for (int j = n-1; j>=i; j--)
            {
                if( arr[j]>=rmax){
                    rmax =arr[j];
                }
            }

            total = total+Math.min(lmax,rmax)-arr[i];

        }
        return total;
    }
    public static int trappingRainWater1(int[]arr){
        int total = 0;
        int n = arr.length;
        int[] lmax = new int[n];
        int[] rmax = new int[n];

        lmax[0]= arr[0];
        for (int j = 1; j<n; j++)
        {
            if( arr[j]>=lmax[j-1]){  // find lmax and rmax separately
                lmax[j] =arr[j];
            }
            else {
                lmax[j]=lmax[j-1];
            }
        }
        System.out.println(Arrays.toString(lmax));

        rmax[n-1]= arr[n-1];
        for (int j = n-2; j>=0; j--)
        {
            rmax[j] = Math.max(arr[j], rmax[j + 1]);
        }
        System.out.println(Arrays.toString(rmax));

        for(int i = 1; i < n-1; i++)  // O(N) time complexity and O(n) SPACE COMPLEXITY
        {
            total = total+Math.min(lmax[i],rmax[i])-arr[i];

        }
        return total;
    }

    public static int maxSumOfSubarrys(int []arr){
        int result=arr[0];
        int curr_max=0;
        for (int i =1; i<arr.length; i++){
            curr_max = Math.max(curr_max+arr[i],arr[i]); // sum of upto that element or that element itself
            result=Math.max(result,curr_max);
        }return result;
    }
    public static int maxSumOfCircularSubArrays(int arr[])
    {   int n = arr.length;
        int max_normal = maxSumOfSubarrys(arr);

        if(max_normal < 0)
            return max_normal;

        int arr_sum = 0;

        for(int i = 0; i < n; i++)
        {
            arr_sum += arr[i]; // total sum of the array

            arr[i] = -arr[i];  //  changing the sign of element so that we can get the min  sum of the sub arrar
        }

        // max sum of circular array is array sum - min sum of sub array
        int max_circular = arr_sum + maxSumOfSubarrys(arr);  // after changing the sign maxSumOfSubarrys will give min value in negetive

        return Math.max(max_circular, max_normal);
    }
    static int maxSumOfCircularSubArrays1(int arr[])
    {  // nevie solution n2
        int n = arr.length;
        int res = arr[0];

        for(int i = 0; i < n; i++)
        {
            int curr_max = arr[i];
            int curr_sum = arr[i];

            for(int j = 1; j < n; j++)
            {
                int index = (i + j) % n;  // to get all circular sub array

                curr_sum += arr[index];

                curr_max = Math.max(curr_max, curr_sum);
            }

            res = Math.max(res, curr_max);
        }
        return res;
    }
    public static int longestOddEvenSubArray(int[]arr){
        int len=1;
        int res=1;
        for(int i = 1; i < arr.length; i++){
            if((arr[i-1]%2==1 && arr[i]%2==0) || (arr[i-1]%2==0 && arr[i]%2==1)){
                len++;
            }
            else{
                res=Math.max(len,res);
                len=1;
            }
        }
        return res;
    }
    public static boolean isEqualibrium(int [] arr){
        int n = arr.length;
        int sum_left;
        int sum_right;

        for( int i = 0; i < n; i++){
            sum_left = 0;
            sum_right = 0;
            for ( int j = 0; j < i; j++){
                sum_left+=arr[j];
            }
            for ( int k = i+1; k <n ; k++){
                sum_right+=arr[k];
            }
            if(sum_right==sum_left)
                return true;
        } return false;
    }
    public static int majorityElement(int []arr){
        int count = 1;
        for (int i = 0; i < arr.length; i++){
            count=1;
            for (int j = i+1; j < arr.length; j++){
                if ( arr[i] == arr[j]){
                    count++;
                }
                if (count>(arr.length/2)){
                    return arr[i];
                }
            }

        }
        return -1;
    }
    public static int majorityElement1(int []arr){  //Moore’s Voting Algorithm: (O(n)
        int count = 1;
        int n = arr.length;
        int res =0;
        for (int i = 1; i < arr.length; i++){
                if ( arr[i] == arr[res]){
                    count++;
                }
                else{
                    count--;}
                if (count==0){   // find the candidate for Majority */
                    res =i;
                    count=1;
                }
            }
        count = 0;

        for(int i = 0; i < n; i++)
            if(arr[res] == arr[i])
                count++;  //

        if(count <= n /2)  // check if the candidate occurs more than n/2 times *
            res = -1;

        return arr[res];
    }
    public static void main(String[] args) {
      /*  int [] arr1 = {11,5,31,45, };
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
        System.out.println(Arrays.toString(reverse(arr5,0,5)));
        System.out.println(Arrays.toString(reverseArray(arr5)));

        int [] arr6={10,20,20,30,30,30};
        System.out.println(removeDuplicates(arr6));

        int [] arr7={10,0,0,30,40,0};
        System.out.println(Arrays.toString(moveZerosToEnd(arr7)));
        System.out.println(Arrays.toString(leftRotate(arr7)));
        System.out.println(Arrays.toString(moveZerosToEnd(arr7)));

        int [] arr8={1,2,3,4,5};
        System.out.println(Arrays.toString(leftRotateD1(arr8,2)));
        System.out.println(Arrays.toString(leftRotateD2(arr8,3)));
        int [] arr9={10,5,30,15};
        System.out.println(Arrays.toString(leftRotateD1(arr9,3)));
        System.out.println(Arrays.toString(leftRotateD3(arr9,2)));

        int [] arr10={10,5,40,30,15,5,7};
        leader(arr10);
        leader2(arr10);
        System.out.println(maxdifference(arr10));
        System.out.println(maxdifference1(arr10));

        int [] arr11={5,5,5,10,15,15,7};
        frequency(arr11);

        int []arr12 ={1,5,3,8,12};
        System.out.println(stockBuySell(arr12));
        System.out.println(maxProfit(arr12,0,4));

        int []arr13 ={0,1,1,1,1,0,1,1,0,1};
        System.out.println(maxConsicutiveOne(arr13));

        int []arr14={4,1,3,2,6};
        System.out.println(trappingRainWater(arr14));
        System.out.println(trappingRainWater1(arr14)); */

        int []arr14={1,2,3,-8,7,4,-1,2,3};
        System.out.println(maxSumOfSubarrys(arr14));
        System.out.println(maxSumOfCircularSubArrays(arr14));
        System.out.println(maxSumOfCircularSubArrays1(arr14));
        System.out.println(longestOddEvenSubArray(arr14));

        int []arr15={3,1,2,2,3,3,3,3};
        System.out.println(isEqualibrium(arr15));
        System.out.println(majorityElement(arr15));
        System.out.println(majorityElement1(arr15));


    }
}