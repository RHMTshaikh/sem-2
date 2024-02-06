import java.text.DecimalFormat;
import java.util.Scanner;

class LTM {
    float[] matrix ;
    int len;
    int n;
    // 1 0 0
    // 1 1 0
    // 1 1 1
    LTM(int n){
        this.n =n;
        len = n*(n+1)/2;
        matrix = new float[len];
    
    }
    void read(){
        Scanner scn = new Scanner(System.in);
        for (int i = 0; i < len; i++) {
            matrix[i] = scn.nextFloat();
        }
    }
    int map(int i, int j) {
        return i*(i+1)/2+j;
    }
    void display(){
        DecimalFormat df = new DecimalFormat("#.##");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < j) {
                    System.out.print(0.00+"  ");
                } else{
                    System.out.print(df.format(matrix[map(i,j)])+"  ");
                }
            }System.out.println();
        }
    }
    LTM multiply(DigonalMatrix m2) throws Exception{
        if(len != m2.len) throw new Exception("Product not Possible! Invalid Dimensions");
        LTM product = new LTM(len);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int k =0; k < len; k++){
                    product.matrix[product.map(i,j)] += matrix[map(i,k)] * m2.matrix[m2.map(k,j)];
                }
            }
        }
        return product;
    }
    LTM multiply(LTM m2) throws Exception{
        if(len != m2.len) throw new Exception("Product not Possible! Invalid Dimensions");
        LTM product = new LTM(len);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int k =0; k < len; k++){
                    product.matrix[product.map(i,j)] += matrix[map(i,k)] * m2.matrix[m2.map(k,j)];
                }
            }
        }
        return product;
    }
    Matrix multiply(UTM m2) throws Exception{
        if(len != m2.len) throw new Exception("Product not Possible! Invalid Dimensions");
        Matrix product = new Matrix(len);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int k =0; k < len; k++){
                    product.matrix[i][j] += matrix[map(i,k)] * m2.matrix[m2.map(k,j)];
                }
            }
        }
        return product;
    }
}
class UTM {
    float[] matrix ;
    int len;
    int n;
    // 1 1 1
    // 0 1 1
    // 0 0 1
    UTM(int n){
        this.n =n;
        len = n*(n+1)/2;
        matrix = new float[len];
    
    }
    void read(){
        Scanner scn = new Scanner(System.in);
        for (int i = 0; i < len; i++) {
            matrix[i] = scn.nextFloat();
        }
    }
    int map(int i, int j) {
        return i*(2*n-i-1)/2+j;
    }
    void display(){
        DecimalFormat df = new DecimalFormat("#.##");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i > j) {
                    System.out.print(0+"  ");
                } else{
                    System.out.print(df.format(matrix[map(i,j)])+"  ");
                }
            }System.out.println();
        }
    }
    UTM multiply(DigonalMatrix m2) throws Exception{
        if(len != m2.len) throw new Exception("Product not Possible! Invalid Dimensions");
        UTM product = new UTM(len);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int k =0; k < len; k++){
                    product.matrix[product.map(i,j)] += matrix[map(i,k)] * m2.matrix[m2.map(k,j)];
                }
            }
        }
        return product;
    }
    UTM multiply(UTM m2) throws Exception{
        if(len != m2.len) throw new Exception("Product not Possible! Invalid Dimensions");
        UTM product = new UTM(len);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int k =0; k < len; k++){
                    product.matrix[product.map(i,j)] += matrix[map(i,k)] * m2.matrix[m2.map(k,j)];
                }
            }
        }
        return product;
    }
    Matrix multiply(LTM m2) throws Exception{
        if(len != m2.len) throw new Exception("Product not Possible! Invalid Dimensions");
        Matrix product = new Matrix(len);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int k =0; k < len; k++){
                    product.matrix[i][j] += matrix[map(i,k)] * m2.matrix[m2.map(k,j)];
                }
            }
        }
        return product;
    }
}

class DigonalMatrix {
    float[] matrix ;
    int len;
    int n;
    // 1 1 1
    // 0 1 1
    // 0 0 1
    DigonalMatrix(int n){
        this.n =n;
        len = n;
        matrix = new float[len];
    
    }
    void read(){
        Scanner scn = new Scanner(System.in);
        for (int i = 0; i < len; i++) {
            matrix[i] = scn.nextFloat();
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
                    System.out.print(df.format(matrix[map(i,j)])+"  ");
                } else{
                    System.out.print(0.00+"  ");
                }
            }System.out.println();
        }
    }
    float determinant(){
        float det =1;
        for (int i = 0; i < len; i++) {
            det *= matrix[map(i, i)];
        }
        return det;
    }
    DigonalMatrix invers(){
        DigonalMatrix invers = new DigonalMatrix(len);
        for (int i = 0; i < len; i++) {
            invers.matrix[i] =1/matrix[i];            
        }
        return invers;
    }
    DigonalMatrix multiply(DigonalMatrix m2){
        DigonalMatrix product = new DigonalMatrix(len);
        for (int i = 0; i < len; i++) {
            product.matrix[map(i,i)] = matrix[map(i,i)] * m2.matrix[map(i,i)];
        }
        return product;
    }
    LTM multiply(LTM m2) throws Exception{
        if(len != m2.len) throw new Exception("Product not Possible! Invalid Dimensions");
        LTM product = new LTM(len);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int k =0; k < len; k++){
                    product.matrix[product.map(i,j)] += matrix[map(i,k)] * m2.matrix[m2.map(k,j)];
                }
            }
        }
        return product;
    }
    UTM multiply(UTM m2) throws Exception{
        if(len != m2.len) throw new Exception("Product not Possible! Invalid Dimensions");
        UTM product = new UTM(len);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int k =0; k < len; k++){
                    product.matrix[product.map(i,j)] += matrix[map(i,k)] * m2.matrix[m2.map(k,j)];
                }
            }
        }
        return product;
    }
}

public class ParseMatrix {
    public static void main(String[] args) {
        try {
            DigonalMatrix m =  new DigonalMatrix(4);
            DigonalMatrix m2 =  new DigonalMatrix(4);
            m.read();
            m.invers().display();
            // m2.read();
            m.display();
            m.multiply(m2).display();
            System.out.println(m.determinant());
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

