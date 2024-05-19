package ZeeshanSir;

import java.util.Arrays;

public class PowerSet {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int i=1;
        for (int[] set  : powerSet(arr)) {
            System.out.print(i+++". ");
            System.out.println(Arrays.toString(set));
        }
    }
    static int[][] powerSet(int[] list){
        int numberOfSets = 1<<list.length;
        int[][] powerSet = new int[numberOfSets][];
        
        int n ;
        int position =-1;
        int count = -1;
        for (int i = 0; i < numberOfSets; i++) {
            powerSet[i] = new int[numberOfOnes(i)];
            n=i;
            while (n>0) {
                position++;
                if((n&1)==1){
                    powerSet[i][++count] = list[position];
                }
                n=n>>1;
            }
            position = -1;
            count = -1;
        }
        return powerSet;
    }
    static int numberOfOnes(int n){
        int count =0;
        while (n>0) {
            n = n & n-1;
            count++;
        }
        return count;
    }
    static int positionOfLastSetBit(int n){
        int position=-1;
        while (n>0) {
            if((n&1)==1){
                position++;
                return position;
            }
            position++;
            n = n>>1;
        }
        return position;
    }
}
