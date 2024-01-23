import java.util.Random;
//adding a comment to check

public class Matrix{
    int[][] matrix;
    int rows;
    int columns;
    Matrix(int n){
        rows=n;
        columns = n;
        Random rdm = new Random();
        matrix = new int [rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = rdm.nextInt(9)+1;
            }
        }
    }
    Matrix(int r, int c){
        rows=r;
        columns = c;
        Random rdm = new Random();
        matrix = new int [rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = rdm.nextInt(9)+1;
            }
        }
    }
    Matrix(int r, int c, int constant){
        rows=r;
        columns = c;
        matrix = new int [rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = constant;
            }
        }
    }

    void transpose(){
        for (int i = 0; i < rows-1; i++) {
            for (int j = i+1; j < columns; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    Matrix multiply(Matrix m1){
        int[][] matrix1 = m1.matrix;
        int m1_row = m1.rows;
        int m1_col = m1.columns;

        Matrix product =  new Matrix(rows,m1_col,0);

        if (columns == m1_row){
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < m1_col; j++) {
                    product.matrix[i][j]=0; 
                    for (int k =0; k < columns; k++){
                        product.matrix[i][j] += matrix[i][k] * matrix1[k][j];
                    }
                }
            }
        }
        else{
            System.out.println("Product not Possible! \nInvalid Dimensions");
        }
        return product;
    }
    
    
    void display(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j]+" ");
            }System.out.println();
        }

    }
    public static void main(String[] args) {
        Matrix m = new Matrix(4);
        Matrix m1 = new Matrix(4);

        System.out.println("matrix1");
        m.display();
        System.out.println("matrix2");
        m1.display();
        System.out.println("Multiplication of matrices.");
        m.multiply(m1).display();
        System.out.println(3*5/3);
    }
}
