import java.util.Random;

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
    void display(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j]+" ");
            }System.out.println();
        }

    }
    public static void main(String[] args) {
        Matrix m = new Matrix(4);
        m.display();
    }
}
