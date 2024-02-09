package ZeeshanSir;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(10));
    }

    public static double fibonacci(int n){
        if(n==1) return 0;
        if(n==2) return 1;
        else{
            if(n%2==0){
                n = n/2;
                double A=fibonacci(n), B=fibonacci(n+1);
                return Math.pow(A,2) + Math.pow(B,2) ;
            } else{
                n = n/2;
                double A=fibonacci(n), B=fibonacci(n+1);
                return 2*A*B+ Math.pow(B,2);
            }
        }
        
    }
}
