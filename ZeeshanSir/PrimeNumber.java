package ZeeshanSir;

public class PrimeNumber {
    public static void main(String[] args) {
        int from = 100, upto = 203; // number to find the prime factors of
        primeFactors(upto);
        System.out.println();
        System.out.println();
        primeFactors(from,upto);
    }


    public static void primeFactors(int from,int upto){
        boolean[] numArr = new boolean[upto+1];
        for (int i = 2; i <= upto; i++) {
            if (numArr[i]==false) {
                for (int j = i*i; j <= upto; j+=i) {
                    numArr[j]=true;
                }
            }
        }
        for (int i = from; i <= upto; i++) {
            if(numArr[i]==false){
                System.out.print(i+" ");
            }
        }
    }
    public static void primeFactors(int upto){
        boolean[] numArr = new boolean[upto+1];
        for (int i = 2; i<= upto; i++) {
            if (numArr[i]==false) {
                System.out.print(i+" ");
                for (int j = i*i; j <= upto; j+=i) {
                    numArr[j]=true;
                }
            }
        }
    }
    
}
