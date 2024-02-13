// package ZeeshanSir;

import java.util.Random;
import java.util.Scanner;
//adding a comment to check

public class Matrix {
    float[][] matrix;
    int rows;
    int columns;

    Matrix(int n) throws Exception {
        if(n <1) throw new Exception("dimension must be greater than zero");
        rows=n;
        columns = n;
        Random rdm = new Random();
        matrix = new float [rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = rdm.nextInt(9)+1;
            }
        }
    }
    Matrix(int r, int c) throws Exception {
        if(r < 1 || c <1) throw new Exception("dimension must be greater than zero");
        rows=r;
        columns = c;
        Random rdm = new Random();
        matrix = new float [rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = rdm.nextInt(9)+1;
            }
        }
    }
    Matrix(int r, int c, int constant) throws Exception {
        if(r < 1 || c <1) throw new Exception("dimension must be greater than zero");
        rows=r;
        columns = c;
        matrix = new float[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = constant;
            }
        }
    }
    void read(){
        Scanner scn = new Scanner(System.in);
        System.out.println("input "+ rows*columns + " numbers in the terminal");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = scn.nextFloat();
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
    void transpose() {
        for (int i = 0; i < rows-1; i++) {
            for (int j = i+1; j < columns; j++) {
                float temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    Matrix add(Matrix m2) throws Exception {
        if(rows != m2.rows || columns != m2.columns) throw new Exception("dimensions are not equal!");
        Matrix sum = new Matrix(rows,columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sum.matrix[i][j] = matrix[i][j] + m2.matrix[i][j];
            }
        }
        return sum;
    }
    Matrix subtract(Matrix m2) throws Exception {
        if(rows != m2.rows || columns != m2.columns) throw new Exception("dimensions are not equal!");
        Matrix diffMatrix = new Matrix(rows,columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                diffMatrix.matrix[i][j] = matrix[i][j] - m2.matrix[i][j];
            }
        }
        return diffMatrix;
    }
    Matrix multiply(Matrix m2) throws Exception {
        if(columns != m2.rows) throw new Exception("Product not Possible! Invalid Dimensions");

        int m2_col = m2.columns;
        Matrix product =  new Matrix(rows,m2_col,0);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < m2_col; j++) {
                for (int k =0; k < columns; k++){
                    product.matrix[i][j] += matrix[i][k] * m2.matrix[k][j];
                }
            }
        }
        return product;
    }
    float determinant() throws Exception{
        if (columns != rows) throw new  Exception("not square matrix");

        Matrix UTM_matrix =  new Matrix(rows,columns,0);//made this to dont alter the original matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                UTM_matrix.matrix[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < rows-1; i++) {
            float x = UTM_matrix.matrix[i][i];
            for (int j = i+1; j < rows; j++) {
                float y = UTM_matrix.matrix[j][i];
                for (int k = 0; k < rows; k++) {
                    UTM_matrix.matrix[j][k] = UTM_matrix.matrix[j][k]-UTM_matrix.matrix[i][k]*y/x;
                }
            }
        }
        float d =1;
        for (int i = 0; i < matrix.length; i++) {
            d *= UTM_matrix.matrix[i][i];
        }
        return d;
    }
    Matrix inverse() throws Exception{
        if (columns!=rows) throw new Exception("inverse: not squar matrix");
        if (this.determinant() == 0.0) throw new Exception("inverse: singular matrix");
        
        Matrix dummy = new Matrix(rows);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                dummy.matrix[i][j] = matrix[i][j];
            }  
        }
        Matrix invers = new Matrix(rows);
        //converting to unit matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                if(i!=j) invers.matrix[i][j] =0;
                else invers.matrix[i][j] = 1;
            }  
        }
        //making lower part 0
        for (int i = 0; i < rows-1; i++) {
            float x = dummy.matrix[i][i];
            for (int j = i+1; j < rows; j++) {
                float y = dummy.matrix[j][i];
                for (int k = 0; k < rows; k++) {
                    dummy.matrix[j][k] = dummy.matrix[j][k]-dummy.matrix[i][k]*y/x;
                    invers.matrix[j][k] = invers.matrix[j][k]-invers.matrix[i][k]*y/x;
                }
            }
        }
        //making upper part 0
        for (int i = rows-1; i > 0; i--) {
            float x = dummy.matrix[i][i];
            for (int j = i-1; j >= 0; j--) {
                float y = dummy.matrix[j][i];
                dummy.matrix[j][i] -= dummy.matrix[i][i]*y/x;
                invers.matrix[j][i] -= invers.matrix[i][i]*y/x;
                for (int k = rows-1; k >= 0; k--) {
                }
            }
        }
        //making digonal 1
        for (int i = 0; i < rows; i++) {
            float x = dummy.matrix[i][i];
            for (int j = 0; j < rows; j++) {
                dummy.matrix[i][j] = dummy.matrix[i][j]/x;
                invers.matrix[i][j] = invers.matrix[i][j]/x;
            }
        }
        return invers;
    }
    void sumOFRows() {
        for (int i = 0; i < rows; i++) {
            float sum = 0;
            for (int j = 0; j < columns; j++) {
                sum += matrix[i][j];
            }
            System.out.print(sum+" ");
        }
        System.out.println();
    }
    void sumOFColumns() {
        for (int i = 0; i < columns; i++) {
            float sum = 0;
            for (int j = 0; j < rows; j++) {
                sum += matrix[j][i];
            }
            System.out.print(sum+" ");
        }
        System.out.println();
    }
    //in codespace 
    public static void main(String[] args) {
        try {
            Matrix m = new Matrix(3);
            Matrix m1 = new Matrix(3);
            System.out.println("matrix1");
            m.display();
            System.out.println("matrix2");
            m1.display();

            System.out.println("Multiplication of matrices.");
            m.multiply(m1).display();

            System.out.println("determinant");
            System.out.println(m.determinant());
            
            System.out.println("sum of rows");
            m.sumOFRows();

            System.out.println("sum of columns");
            m.sumOFColumns();

            System.out.println("determinant");
            m.determinant();

            System.out.println("inverse");
            m.inverse().display();

            m.read();
            m.display();
            m.read();
            m.display();
            System.out.println(m.determinant());
 
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
