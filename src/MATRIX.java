package DSA.Matrix;

class MATRIX{
    public static void main(String[] args) {
        int [] [] matrix= {{1,2,3},{4,5,6},{7,8,9}};
       /* snakePattern(matrix);
        transposeOfMatrix(matrix);
        printMatrix(matrix);
        boundaryTraversal(matrix);
        rotate90AntiClock(matrix);
        printMatrix(matrix);

        int [][] arr = {{1,1},{2,2}};
        int [][] brr = {{1,2,3},{1,1,1}};
        printMatrix(multiplicationOfMatrix(arr,brr));*/

        int a[][] = {{1, 1, 1, 4},
            {5, 6, 7, 8},
            {6, 10, 11, 12},
            {13, 14, 15, 16}};
        System.out.println(determinantOfMatrix(a,4));

//        spiralTraversal(a);
//        System.out.println(findElementInRow_ColSortedMatrix(a,9));
    }

    public static void printMatrix(int [] [] arr){
        int n = arr.length;
        int m = arr[0].length;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println( );
        }
    }

    public static void snakePattern(int [][] arr){
        for(int i = 0; i< arr.length; i++){
            if(i%2==0){
                for (int j = 0 ; j< arr[i].length;j++ ){  //m*n time complexity
                    System.out.print(arr[i][j]+" ");
                }
            }
            else {
                for (int j =  arr[i].length-1 ; j>=0; j--){
                    System.out.print(arr[i][j]+" ");
                }
            }

        }
    }
    public static void transposeOfMatrix(int [][] arr){
        int n = arr.length;
        int m = arr[0].length;
        for(int i = 0; i< n; i++){
                for (int j = i ; j< m; j++ ) { //m*n
                    {
                        int temp = arr[i][j];
                        arr[i][j] = arr[j][i];
                        arr[j][i] = temp;

                    }
                }
        }

    }

    public static void rotate90AntiClock(int [][] arr){
        int row = arr.length;
        int col = arr[0].length;

        transposeOfMatrix(arr);
        //reverse all columns now
        int i =0 , j = row-1;
        while (i<j){
            for (int k = 0; k<col; k++){  // for reversing all columns
                int tmp = arr[i][k];
                arr[i][k] =arr[j][k];
                arr[j][k] = tmp;
            }
            i++;
            j--;
        }
    }
    public static void boundaryTraversal(int[][]arr){
        int row = arr.length;
        int col = arr[0].length;

        if(row==1 || col==1)
        {
            if(col==1)
                for (int i=0; i<row; i++)
                    System.out.print(arr[i][0]+" ");
            else
                for (int i=0; i<col; i++)
                    System.out.print(arr[0][i]+" ");
        }
        else {
            for(int i =0; i<col; i++)
                System.out.print(arr[0][i]+" ");
            for(int i =1; i<row; i++)
                System.out.print(arr[i][col-1]+" ");
            for(int i =col-2; i>=0; i--)
                System.out.print(arr[row-1][i]+" ");
            for(int i =row-2; i>0; i--)
                System.out.print(arr[i][0]+" ");
        }
    }
    public static void spiralTraversal(int[][]arr){
        int row = arr.length , col = arr[0].length;
        int top = 0, right = col-1, bottom = row-1 , left =0;

        // Time Complexity: O(m*n).

        while (top<bottom && left<right){

            for(int i =left; i<=right; i++){   // printing top row
                System.out.print(arr[top][i]+" ");}
            top++;

            for(int i =top; i<=bottom; i++){     // printing left column
                System.out.print(arr[i][right]+" ");}
            right--;

            if(top<=bottom) {
            for(int i =right; i>=left; i--)
                System.out.print(arr[bottom][i]+" ");
            bottom--;
            }

            if(left<=right) {
                for (int i = bottom; i >= top; i--)
                    System.out.print(arr[i][left] + " ");
                left++;
            }
        }
    }

    public static int [][] multiplicationOfMatrix (int [] []arr, int [][] brr){ //O(r1*c2*c1)
        int r1 = arr.length, c1 = arr[0].length , r2 = brr.length , c2 = brr[0].length;
        int [][] result = new int[r1][c2];
        if(c1==r2){
            for(int i  = 0;  i < r1; i++){

                for( int j = 0;  j < c2; j++){

                    for ( int k =0; k<c1; k++){
                        result[i][j] += arr[i][k]*brr[k][j];
                    }
                }
            }
        }
        else{
            System.out.println("multiplication of matrixes are not possible");
        }
        return result;
    }

    public static boolean findElementInRow_ColSortedMatrix (int [] [] arr, int x){

        int row = arr.length,  col= arr[0].length;
        int top =0 , right =col-1;

        while (top<row && right>=0){
            if(arr[top][right]==x){
                return true;
            }
            else if(arr[top][right]<x){
                top++;
            }
            else {
                right--;
            }

        }

        return false;
    }

    static int determinantOfMatrix(int [][] mat, int n)
    {
        int  det = 0;
        if(n ==1){
            det = mat[0][0];
            return det;
        }
        if(n == 2){
            det = ((mat[0][0]*mat[1][1])-(mat[0][1]*mat[1][0]));
            return det;
        }
        int sign = 1;
        for (int i = 0 ; i<n; i++){

            int  [][] CofactorMatrix = getCofactorMatrix(mat,i,n);

            det += mat[0][i] * sign * determinantOfMatrix(CofactorMatrix,n-1);
            sign = -sign;
        }
        return det;
    }
    public static int [][] getCofactorMatrix(int [][] mat , int j , int n){
        int [] [] cofactor = new int [n-1][n-1];
        for(int i  = 1 ; i<n; i++){
            int index =0;
            for (int k = 0 ; k <n; k++){
                if (k!=j){
                    cofactor[i-1][index++] = mat [i][k];
                }

            }
        }
        return cofactor;
    }
}