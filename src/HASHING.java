package DSA.Hashing;
import java.util.*;

class MyHashChaining
{
    int BUCKET;
    ArrayList<LinkedList<Integer>> table;
    MyHashChaining(int b)
    {
        BUCKET = b;
        table = new ArrayList<LinkedList<Integer>>();
        for (int i=0; i<b; i++)
            table.add(new LinkedList<Integer>());
    }
    void insert(Integer k)
    {
        int i = k % BUCKET;
        table.get(i).add(k);
    }
    boolean search(Integer k)
    {
        int i = k % BUCKET;
        return table.get(i).contains(k);
    }
    void delete(Integer k)
    {
        int i = k % BUCKET;
        table.get(i).remove(k);
    }
}

class MyHashOpenAd
{
    int cap ,size;
    int [] arr;
    MyHashOpenAd(int c)
    {
        cap = c;
        size = 0;
        arr = new int[cap];
        for (int i =0; i<cap; i++){
            arr[i]=-1;
        }
    }
    int hash (int key){
        System.out.println(Arrays.toString(arr));
        return key % cap;
    }
    boolean insert(int key)
    {
        if (size == cap) {
            return false; // already full array cant insert
        }
        int i = hash(key);
        while (arr[i]!=-1 && arr[i]!= -2 && arr[i]!=key) {
            // when the slot is not empty and not delete and already some element is there
            i = (i+1)%cap;
        }
        if(arr[i]==key) { // key is already inserted
            return false;
        }
        else { // slot is empty or deleted
            arr[i] = key;
            size ++;
            return true;
        }

    }

    boolean search(int key)
    {   int h = hash(key);
        int i =h;
        while (arr[i]!=-1) {
            if(arr[i]==key){ // when we find the key
                return true;}

            i = (i+1)%cap; // traversing whole array circularly
            if (i==h){
                return false; }
        }
        return false; //when arr[i] is empty
    }
    boolean delete(int key)
    {
        int h = hash(key);
        int i =h;
        while (arr[i]!=-1) {
            if(arr[i]==key){ // when we find the key
                arr[i] = -2;
                return true;}

            i = (i+1)%cap; // traversing whole array circularly
            if (i==h){
                return false; }
        }
        return false; //when arr[i] is empty
    }
}

class HASHING
{
    public static int countDistinctElement(int []arr){

        //O(N) BOTH TIME AND SPACE
        HashSet<Integer> hash  = new  HashSet<Integer>();

        for(int i=0; i<arr.length; i++){
            hash.add(arr[i]);
        }
        System.out.println(hash);
        return hash.size();
    }

    public static void  frequency ( int [] arr){
        Map<Integer,Integer> hashmap = new HashMap<Integer, Integer>();

        // puting values in hash map
        for (int i = 0 ; i<arr.length; i++){
            if(hashmap.containsKey(arr[i])){ // if already exit add 1 more in value
                hashmap.put(arr[i], (hashmap.get(arr[i])+1));
            }
            else {
                hashmap.put(arr[i],1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : hashmap.entrySet()) {

            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }

    public static int intersactionOfTwoArrays ( int [] arr, int [] brr){
        HashSet<Integer> hbase = new HashSet<Integer>();
        HashSet<Integer> hfinal = new HashSet<Integer>();
        // O(n+m) TIME and space both 
        int n =arr.length, m= brr.length;
        for (int i = 0; i<n; i++){
            hbase.add(arr[i]);
        }
        for (int i = 0; i<m; i++){
            if(hbase.contains(brr[i])) {
                hfinal.add(brr[i]);
            }
        }
        System.out.println(hfinal);
        return hfinal.size();
    }
    public static int unionOfTwoArrays ( int [] arr, int [] brr){
        // O(n+m) TIME and space both
        HashSet<Integer> hset = new HashSet<Integer>();
        int n =arr.length, m= brr.length;
        for (int i = 0; i<n; i++){
            hset.add(arr[i]);
        }
        for (int i = 0; i<m; i++){
            hset.add(brr[i]);
        }
        System.out.println(hset);
        return hset.size();
    }
    // Driver method to test Map class
    public static void main(String[] args)
    {   //chaining
      /*  MyHashChaining mh = new MyHashChaining(7);
        mh.insert(10);
        mh.insert(20);
        mh.insert(15);
        mh.insert(7);
        System.out.println(mh.search(10));
        mh.delete(15);
        System.out.println(mh.search(15));

        //linear probing
        MyHashOpenAd liner = new MyHashOpenAd(7);
        liner.insert(10);
        liner.insert(17);
        liner.insert(20);
        liner.insert(27);
        liner.insert(15);
        liner.insert(7);
        System.out.println(liner.insert(30));
        System.out.println(liner.search(20));
        System.out.println(liner.delete(15));
        System.out.println(liner.search(15));*/

        int [] distinct = {2,4,5,3,2,4,2,1,5};
        System.out.println(countDistinctElement(distinct));
        frequency(distinct);

        int []arr ={ 2 , 38, 29,3};
        int []brr = {3,5,4,2};
        unionOfTwoArrays(arr,brr);
        intersactionOfTwoArrays(arr,brr);



    }
}