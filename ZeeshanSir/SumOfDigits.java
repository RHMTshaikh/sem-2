package ZeeshanSir;

public class SumOfDigits{
    public static void main(String[] args) {
        int num = 123456789;
        System.out.println("Sum of digits of number "+num+" is "+sumOfDigits(num));
    }

    public static int sumOfDigits(int num){
        int sum=0;
        while (num != 0){
            sum = sum + num % 10;
            num /=10;
        }
        return sum;
    }
}