package KhalidSir;
import java.util.Random;
import java.util.Scanner;


class Matrix {
    int[][] m;
    static void print(int[][] m){
        int m_row_l = m.length;
        int m_col_l = m[0].length;
        for (int i = 0; i < m_row_l; i++) {
            
            for (int j = 0; j <  m_col_l; j++) {
                System.out.print(m[i][j] + " ");
            }System.out.println();
        }System.out.println();
    }
//__________________________________________________________________
    // Matrix(){}
//__________________________________________________________________

    Matrix(int row, int col){
        Random rdm = new Random();
        m = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // System.out.print("Enter Number: ");
                m[i][j] = rdm.nextInt(10)+1;
            }
        }
        print(m);
    }
//____________________________________________________________________________________    

    int[][] create(){
        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of Rows: ");
        int rows = input.nextInt();

        System.out.print("Enter number of Columns: ");
        int cols = input.nextInt();

        int[][] arr = new int[rows][cols];
            
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++){
                System.out.print("Enter Number: ");
                arr[i][j] = input.nextInt();
            }
        }
        print(arr);
        return arr; 
    }
//____________________________________________________________________________________    

    int[][] add(int[][] m1){
        int m_row_l = m.length;
        int m1_row_l = m1.length;
        int m_col_l = m[0].length;
        int m1_col_l = m1[0].length;

        int[][] sum = new int[m1_row_l][m1_col_l];

        if ((m1_row_l == m_row_l) && (m1_col_l == m_col_l)){
            System.out.println("Sum of Matrices.");
            for (int i = 0; i < m1_row_l; i++) {
                for (int j = 0; j < m1_col_l; j++) {
                    sum[i][j] = m[i][j] + m1[i][j];
                }
            }
        }
        else{
            System.out.println("Sum not Possible \nDimesions are not equal!");
        }
        return sum;
    }
//____________________________________________________________________________________    

    int[][] add(int[][] m1,int[][] m2){
        int m1_row_l = m1.length;
        int m2_row_l = m2.length;
        int m1_col_l = m1[0].length;
        int m2_col_l = m2[0].length;

        int[][] sum = new int[m1_row_l][m1_col_l];

        if ((m1_row_l == m2_row_l) && (m1_col_l == m2_col_l)){
            System.out.println("Sum of Matrices.");
            for (int i = 0; i < m1_row_l; i++) {
                for (int j = 0; j < m1_col_l; j++) {
                    sum[i][j] = m1[i][j] + m2[i][j];
                    
                }
            }
        }
        else{
            System.out.println("Sum not Possible \nDimesions are not equal!");
        }
        return sum;
    }
//____________________________________________________________________________________    

    int[][] subtract(int[][] m1,int[][] m2){
        int m1_row_l = m1.length;
        int m2_row_l = m2.length;
        int m1_col_l = m1[0].length;
        int m2_col_l = m2[0].length;

        int[][] sum = new int[m1_row_l][m1_col_l];

        if ((m1_row_l == m2_row_l) && (m1_col_l == m2_col_l)){
            System.out.println("Subtraction of Matrices.");
            for (int i = 0; i < m1_row_l; i++) {
                for (int j = 0; j < m1_col_l; j++) {
                    sum[i][j] = m1[i][j] - m2[i][j];
                    
                }
            }
        }
        else{
            System.out.println("Sum not Possible \nDimesions are not equal!");
        }
        return sum;
    }
//______________________________________________________________________________________
    int[][] subtract(int[][] m1){
        int m_row_l = m.length;
        int m1_row_l = m1.length;
        int m_col_l = m[0].length;
        int m1_col_l = m1[0].length;

        int[][] sum = new int[m1_row_l][m1_col_l];

        if ((m1_row_l == m_row_l) && (m1_col_l == m_col_l)){
            System.out.println("Subtraction of Matrices.");
            for (int i = 0; i < m1_row_l; i++) {
                for (int j = 0; j < m1_col_l; j++) {
                    sum[i][j] = m[i][j] + m1[i][j];
                    
                }
            }
        }
        else{
            System.out.println("Sum not Possible \nDimesions are not equal!");
        }
        return sum;
    }
//____________________________________________________________________________________    
    int[][] multiply(int[][] m1, int[][] m2){
        int m1_row_l = m1.length;
        int m2_row_l = m2.length;
        int m1_col_l = m1[0].length;
        int m2_col_l = m2[0].length;

        int[][] product = new int[m1_row_l][m2_col_l];

        if (m1_col_l == m2_row_l){
            System.out.println("Multiplication of matrices.");
            for (int i = 0; i < m1_row_l; i++) {
                for (int j = 0; j < m2_col_l; j++) {
                    for (int k =0; k < m1_col_l; k++){
                        product[i][j] += m1[i][k] * m2[k][j];
                    }
                }
            }
        }
        else{
            System.out.println("Product not Possible! \nInvalid Dimensions");
        }
        return product;
    }
//_________________________________________________________________________________________________________
     int[][] multiply(int[][] m1){
        int m_row_l = m.length;
        int m1_row_l = m1.length;
        int m_col_l = m[0].length;
        int m1_col_l = m1[0].length;

        int[][] product = new int[m_row_l][m1_col_l];

        if (m_col_l == m1_row_l){
            System.out.println("Multiplication of matrices.");
            for (int i = 0; i < m_row_l; i++) {
                for (int j = 0; j < m1_col_l; j++) {
                    for (int k =0; k < m_col_l; k++){
                        product[i][j] += m[i][k] * m1[k][j];
                    }
                }
            }
        }
        else{
            System.out.println("Product not Possible! \nInvalid Dimensions");
        }
        return product;
    }
//_________________________________________________________________
    int Determinant(int[][] matrix){
        int det =0;
        int d = matrix.length;
        if(d == matrix[0].length){
            if(d==1) {return matrix[0][0];}
            for(int n =0; n <d; n++){
                det += Math.pow(-1,n)*matrix[0][n]*Determinant(Submatrix(matrix, 0, n));
            }
        }
        else{
            System.out.println("Not a square matrix!, Returning default value 0");
        }
        return det;
    }
//_____________________________________________________________________________________________
    int[][] Submatrix(int[][] matrix, int rowToRemove, int colToRemove){
        int d = matrix.length;
        int newRow =0, newCol;
        int[][] submatrix = new int[d-1][d-1];
        
        for(int m =0;m<d; m++ ){
            if(m==rowToRemove) continue;
            newCol=0;
            for(int n=0; n<d; n++){
                if(n==colToRemove) continue;

                submatrix[newRow][newCol] = matrix[m][n];
                newCol++;
            }
            newRow++;
        }
        return submatrix;
    }

//_______________________________________________________________________________

    void rotate(int[][] m){
        int[][] arr = new int[m.length][m[0].length] ;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                arr[i][j] = m[j][m.length-i-1];
            }
        }
        print(arr);
    }
                                                                                                          
//____________________________________________________________________________-
    public static void main(String[] args) {
        // Available methods:
        //     Create matrix by constructor by passing number of rows and columns and populate randomly.
        //     Create matrix by "create' method and manually input the rows , columns and elements.
        //     Add the matrices.
        //     Subtract the matrices.
        //     Multiply the matrices.
        //     Determinant of matrices.
        System.out.println("Matrix by constructor call.");
        Matrix M = new Matrix(3,3); // Random elements 1 to 10
        System.out.println("For matrix1:");
        int[][] matrix1 = M.create();
        System.out.println("For matrix2:");
        int[][] matrix2 = M.create();

        print(M.add(matrix1,matrix2));
        print(M.add(matrix1));
        print(M.subtract(matrix2, matrix1));
        print(M.subtract(matrix1));
        print(M.multiply(matrix2, matrix1));
        print(M.multiply(matrix1));
        System.out.println("Determinant of M.m: " + M.Determinant(M.m));
        System.out.println("Determinant of matrix1: " + M.Determinant(matrix1));
        System.out.println("Determinant of matrix2: " + M.Determinant(matrix2));

        M.rotate(M.m);
    }
}
