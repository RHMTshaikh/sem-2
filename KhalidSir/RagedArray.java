package KhalidSir;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class RagedArray {
    static Scanner scn = new Scanner(System.in);

    
    public static void main(String[] args){
        

        System.out.print("Enter number of rows: ");
        int row = scn.nextInt();
        
        System.out.print("Do you want to populate Randomly or Manually(type 'R' or 'M'): ");
        char method = Character.toUpperCase(scn.next().charAt(0));

        generateRaggedArray(row,method);
    }

    static void generateRaggedArray(int row,char method){
        int[][] arr = new int[row][];
        if(method=='R'){
            Random rdm = new Random();
            // Scanner scn = new Scanner(System.in);

            System.out.print("Enter lower bound: ");
            int lowerBound = scn.nextInt();

            System.out.print("Enter upper bound: ");
            int upperBound = scn.nextInt();

            int width = upperBound-lowerBound;

            for(int i =0; i < row; i++){
                arr[i] = new int[i+1];
                for(int j =0; j<i+1; j++){
                    arr[i][j] = rdm.nextInt(width+1)+lowerBound;
                }
            } 
        }
        else{
            // Scanner scn = new Scanner(System.in);
            System.out.println("Enter only integer value.");

            for(int i =0; i < row; i++){
                arr[i] = new int[i+1];
                for(int j =0; j<i+1; j++){
                    arr[i][j] = scn.nextInt();
                }
            }
        }
        for(int z =0; z<row; z++){
            System.out.println(Arrays.toString(arr[z]));
        }
        
    }
}