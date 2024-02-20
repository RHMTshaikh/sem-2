package ZeeshanSir;

import java.util.Scanner;

public class TriDigonalMatrix {
    float[] matrix;
    int n, len;
    TriDigonalMatrix(int n){
        this.n = n;
        len = 3*n-2;
        matrix = new float[len];
    }
    int map(int i, int j){
        return 2*i+j;
    }
    void read(){
        Scanner scn = new Scanner(System.in);
        System.out.println("Entere "+ len + " elements.");
        for (int i = 0; i < len; i++) {
            matrix[i] = scn.nextFloat();
        }
    }
    void display(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(Math.abs(i-j) <=1){
                    System.out.format("%1.2f\t",matrix[map(i,j)]);
                } else{
                    System.out.format("%1.2f\t",0.0);
                }
            }System.out.println();
        }
    }
    TriDigonalMatrix add(TriDigonalMatrix m2) throws Exception{ 
        if (n != m2.n) throw new Exception("invalid dimensions!");
        
        TriDigonalMatrix result = new TriDigonalMatrix(n);
        for (int i = 0; i < len; i++) {
            result.matrix[i] = matrix[i] + m2.matrix[i];
        }
        return result;
    }
    float determinant(){
        TriDigonalMatrix dummy = new TriDigonalMatrix(n);
        for (int i = 0; i < len; i++) {
            dummy.matrix[i] = matrix[i];   
        }
        
        for (int i = 0; i < n-1; i++) {
            float x = dummy.matrix[map(i,i)];
            float y = dummy.matrix[map(i+1,i)];
            for (int j = i; j < i+2 ; j++) {
                dummy.matrix[map(i+1,j)] -= dummy.matrix[map(i, j)]*y/x; 
            }
        }
        
        int d =1;
        for (int i = 0; i < n; i++) {
            d *= dummy.matrix[map(i, i)];
        }
        return d;
    }
    Matrix inverse() throws Exception{
        if (this.determinant() == 0.0) throw new Exception("inverse: singular matrix");
        
        TriDigonalMatrix dummy = new TriDigonalMatrix(n);
        for (int i = 0; i < len; i++) {
            dummy.matrix[i] = matrix[i];
        }
        System.out.println();
        dummy.display();
        Matrix invers = new Matrix(n);
        //converting to unit matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i!=j) invers.matrix[i][j] =0;
                else invers.matrix[i][j] = 1;
            }  
        }
        System.out.println();
        invers.display();
        //making lower part 0
        for (int i = 0; i < n-1; i++) {
            float x = dummy.matrix[map(i, i)];
            for (int j = i+1; j < n; j++) {
                float y = dummy.matrix[map(j, i)];
                for (int k = 0; k < n; k++) {
                    if(Math.abs(i-k) <= 1 ){
                        dummy.matrix[map(j, k)] -= dummy.matrix[map(i, k)]*y/x;
                    }
                    invers.matrix[j][k] -= invers.matrix[i][k]*y/x;
                }
            }
        }
        System.out.println();
        dummy.display();
        //making upper part 0
        for (int i = n-1; i > 0; i--) {
            float x = dummy.matrix[map(i, i)];
            for (int j = i-1; j >= 0; j--) {
                float y = dummy.matrix[map(j, i)];
                for (int k = 0; k < n; k++) {
                    if(Math.abs(i-k) <= 1 ){
                        dummy.matrix[map(j, k)] -= dummy.matrix[map(i, k)]*y/x;
                    }
                    invers.matrix[j][k] -= invers.matrix[i][k]*y/x;
                }
            }
        }
        System.out.println();
        dummy.display();
        //making digonal 1
        for (int i = 0; i < n; i++) {
            float x = dummy.matrix[map(i, i)];
            for (int j = 0; j < n; j++) {
                dummy.matrix[map(i, j)] = dummy.matrix[map(i, j)]/x;
                invers.matrix[i][j] = invers.matrix[i][j]/x;
            }
        }
        invers.matrix[0][0] = 22;
        return invers;
    }
    
    public static void main(String[] args) {
        try {
            TriDigonalMatrix TM = new TriDigonalMatrix(4);
            TM.read();
            TM.display();
            System.out.println(TM.determinant());
            TM.inverse().display();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
