package DSA.Matrix;

class MATRIX{
    public static void main(String[] args) {
        int [] [] matrix= {{1,2,3},{4,5,6},{7,8,9}};
//        snakePattern(matrix);
//        transposeOfMatrix(matrix);
        printMatrix(matrix);
//        boundaryTraversal(matrix);
        rotate90AntiClock(matrix);
        printMatrix(matrix);
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
}