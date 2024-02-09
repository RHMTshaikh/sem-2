package ZeeshanSir;

import java.text.DecimalFormat;
import java.util.Scanner;

class LTM {
    double[] matrix ;
    int len;
    int n;
    // 1 0 0
    // 1 1 0
    // 1 1 1
    LTM(int n){
        this.n =n;
        len = n*(n+1)/2;
        matrix = new double[len];
    
    }
    void read(){
        System.out.println("Enter "+len+" elements.");
        Scanner scn = new Scanner(System.in);
        for (int i = 0; i < len; i++) {
            matrix[i] = scn.nextDouble();
        }
    }
    int map(int i, int j) {
        return i*(i+1)/2+j;
    }
    void display(){
        // DecimalFormat df = new Deci/malFormat("#.##");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < j) {
                    System.out.format("%1.2f\t",0.0);
                } else{
                    System.out.format("%1.2f\t",matrix[map(i,j)]);
                }
            }System.out.println();
        }
    }

    double determinant(){
        double d =1;
        for (int i = 0; i < n; i++) {
            d *= matrix[map(i, i)];
        }
        return d;
    }
    LTM inverse() throws Exception{
        if (this.determinant() == 0.0) throw new Exception("inverse: singular matrix");
        
        LTM duplicate = new LTM(len);
        for (int i = 0; i < len; i++) {
            duplicate.matrix[i] = matrix[i];
        }
        LTM invers = new LTM(n);
        //converting to unit matrix
        for (int i = 0; i < len; i++) {
            for (int j = i; j >= 0; j--) {
                if(i!=j) 
                    invers.matrix[map(i, j)] = 0;
                else 
                    invers.matrix[map(i, j)] = 1;
            }  
        }
        //making lower part 0
        for (int i = 0; i < n-1; i++) {
            double x = duplicate.matrix[map(i, i)];
            for (int j = i+1; j < n; j++) {
                double y = duplicate.matrix[map(j, i)];
                for (int k = 0; k < n; k++) {
                    duplicate.matrix[map(j, k)] = duplicate.matrix[map(j, k)]-duplicate.matrix[map(i, k)]*y/x;
                    invers.matrix[map(j, k)] = invers.matrix[map(j, k)]-invers.matrix[map(i, k)]*y/x;
                }
            }
        }
        //making digonal 1
        for (int i = 0; i < n; i++) {
            double x = duplicate.matrix[map(i, i)];
            for (int j = 0; j < n; j++) {
                duplicate.matrix[map(i, j)] = duplicate.matrix[map(i, j)]/x;
                invers.matrix[map(i, j)] = invers.matrix[map(i, j)]/x;
            }
        }
        return invers;
    }
    LTM multiply(DigonalMatrix m2) throws Exception{
        if(n != m2.n) throw new Exception("Product not Possible! Invalid Dimensions");
        LTM product = new LTM(n);
        for (int i = 0; i < len; i++) {
            product.matrix[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                product.matrix[product.map(i,j)] += matrix[map(i,j)] * m2.matrix[j];
            }
        }
        return product;
    }
    LTM multiply(LTM m2) throws Exception{
        if(len != m2.len) throw new Exception("Product not Possible! Invalid Dimensions");
        LTM product = new LTM(n);
        for (int i = 0; i < len; i++) {
            product.matrix[i] = 0;
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j <= i; j++) {
                product.matrix[map(i, j)] = 0;
                for (int k =j; k <= i; k++){
                    product.matrix[product.map(i,j)] += matrix[map(i,k)] * m2.matrix[m2.map(k,j)];
                }
            }
        }
        return product;
    }
    Matrix multiply(UTM m2) throws Exception{
        if(n != m2.n) throw new Exception("Product not Possible! Invalid Dimensions");
        Matrix product = new Matrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                product.matrix[i][j] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k =0; k <= i && k <= j; k++){
                    product.matrix[i][j] += matrix[map(i,k)] * m2.matrix[m2.map(k,j)];
                }
            }
        }
        return product;
    }
}
class UTM {
    double[] matrix ;
    int len;
    int n;
    // 1 1 1
    // 0 1 1
    // 0 0 1
    UTM(int n){
        this.n =n;
        len = n*(n+1)/2;
        matrix = new double[len];
    
    }
    void read(){
        System.out.println("Enter "+len+" elements.");
        Scanner scn = new Scanner(System.in);
        for (int i = 0; i < len; i++) {
            matrix[i] = scn.nextDouble();
        }
    }
    int map(int i, int j) {
        return i*(2*n-i-1)/2+j;
    }
    void display(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i > j) {
                    System.out.format("%1.2f\t",0.0);
                } else{
                    System.out.format("%1.2f\t",matrix[map(i,j)]);
                }
            }System.out.println();
        }
    }
    double determinant(){
        double d =1;
        for (int i = 0; i < matrix.length; i++) {
            d *= matrix[map(i, i)];
        }
        return d;
    }
    LTM inverse() throws Exception{
        if (this.determinant() == 0.0) throw new Exception("inverse: singular matrix");
        
        LTM duplicate = new LTM(n);
        for (int i = 0; i < len; i++) {
            duplicate.matrix[i] = matrix[i];
        }
        LTM invers = new LTM(n);
        //converting to unit matrix
        for (int i = 0; i < len; i++) {
            for (int j = i; j >= 0; j--) {
                if(i!=j) 
                    invers.matrix[map(i, j)] = 0;
                else 
                    invers.matrix[map(i, j)] = 1;
            }  
        }
        //making upper part 0
        for (int i = n-1; i > 0; i--) {
            double x = duplicate.matrix[map(i, i)];
            for (int j = i-1; j >= 0; j--) {
                double y = duplicate.matrix[map(j, i)];
                for (int k = n-1; k >= 0; k--) {
                    duplicate.matrix[map(j, k)] -= duplicate.matrix[map(i, k)]*y/x;
                    invers.matrix[map(j, k)] -= invers.matrix[map(i, k)]*y/x;
                }
            }
        }
        //making digonal 1
        for (int i = 0; i < n; i++) {
            double x = duplicate.matrix[map(i, i)];
            for (int j = 0; j < n; j++) {
                duplicate.matrix[map(i, j)] = duplicate.matrix[map(i, j)]/x;
                invers.matrix[map(i, j)] = invers.matrix[map(i, j)]/x;
            }
        }
        return invers;
    }
    UTM multiply(DigonalMatrix m2) throws Exception{
        if(n != m2.n) throw new Exception("Product not Possible! Invalid Dimensions");
        UTM product = new UTM(n);
        for (int i = 0; i < len; i++) {
            product.matrix[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k =0; k < n; k++){
                    product.matrix[product.map(i,j)] += matrix[map(i,k)] * m2.matrix[m2.map(k,j)];
                }
            }
        }
        return product;
    }
    UTM multiply(UTM m2) throws Exception{
        if(n != m2.n) throw new Exception("Product not Possible! Invalid Dimensions");
        UTM product = new UTM(n);
        for (int i = 0; i < len; i++) {
            product.matrix[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k =i; k <= j; k++){
                    product.matrix[product.map(i,j)] += matrix[map(i,k)] * m2.matrix[m2.map(k,j)];
                }
            }
        }
        return product;
    }
    Matrix multiply(LTM m2) throws Exception{
        if(n != m2.n) throw new Exception("Product not Possible! Invalid Dimensions");
        Matrix product = new Matrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                product.matrix[i][j] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = (i<j)?(j):(i); k < n; k++){
                    product.matrix[i][j] += matrix[map(i,k)] * m2.matrix[m2.map(k,j)];
                }
            }
        }
        return product;
    }
}

class DigonalMatrix {
    double[] matrix ;
    int len;
    int n;
    // 1 0 0
    // 0 1 0
    // 0 0 1
    DigonalMatrix(int n){
        this.n =n;
        len = n;
        matrix = new double[len];
    
    }
    void read(){
        System.out.println("Enter "+len+" elements.");
        Scanner scn = new Scanner(System.in);
        for (int i = 0; i < len; i++) {
            matrix[i] = scn.nextDouble();
        }
    }
    int map(int i, int j) {
        return i;
    }
    void display(){
        DecimalFormat df = new DecimalFormat("#.##");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    System.out.format("%1.2f\t",matrix[map(i,j)]);
                } else{
                    System.out.format("%1.2f\t",0.0);
                }
            }System.out.println();
        }
    }
    double determinant(){
        double det =1;
        for (int i = 0; i < len; i++) {
            det *= matrix[map(i, i)];
        }
        return det;
    }
    DigonalMatrix invers(){
        DigonalMatrix invers = new DigonalMatrix(n);
        for (int i = 0; i < len; i++) {
            invers.matrix[i] =1/matrix[i];            
        }
        return invers;
    }
    DigonalMatrix multiply(DigonalMatrix m2) throws Exception{
        if(n != m2.n) throw new Exception("Product not Possible! Invalid Dimensions");
        DigonalMatrix product = new DigonalMatrix(n);
        for (int i = 0; i < len; i++) {
            product.matrix[i] = 0;
        }
        for (int i = 0; i < len; i++) {
            product.matrix[i] = matrix[i] * m2.matrix[i];
        }
        return product;
    }
    LTM multiply(LTM m2) throws Exception{
        if(n != m2.n) throw new Exception("Product not Possible! Invalid Dimensions");
        LTM product = new LTM(n);
        for (int i = 0; i < len; i++) {
            product.matrix[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                product.matrix[product.map(i,j)] += matrix[i] * m2.matrix[m2.map(i,j)];
            }
        }
        return product;
    }
    UTM multiply(UTM m2) throws Exception{
        if(n != m2.n) throw new Exception("Product not Possible! Invalid Dimensions");
        UTM product = new UTM(n);
        for (int i = 0; i < len; i++) {
            product.matrix[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                product.matrix[product.map(i,j)] += matrix[i] * m2.matrix[m2.map(i,j)];
            }
        }
        return product;
    }
}

public class ParseMatrix {
    public static void main(String[] args) {
        try {
            DigonalMatrix d1 =  new DigonalMatrix(3);
            DigonalMatrix d2 =  new DigonalMatrix(3);
            LTM l1 = new LTM(3);
            LTM l2 = new LTM(3);
            UTM u1 = new UTM(3);
            UTM u2 = new UTM(3);
            
            System.out.println("matrix1");
            u1.read();
            System.out.println("matrix2");
            l2.read();
            System.out.println("matrix1");
            u1.display();
            System.out.println("matrix2");
            l2.display();
            System.out.println("multiplication");
            u1.multiply(l2).display();


        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

