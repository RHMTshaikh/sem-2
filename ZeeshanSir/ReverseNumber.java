public class ReverseNumber {
    public static void main(String[] args) {
        System.out.println(reverseNumber(9852));
    }
    public static int reverseNumber(int n){
        System.out.println(n);
        int rev=0;
        while (n!=0) {
            rev*=10;
            rev+=n%10;
            n/=10;
        }
        return rev;
    }
}
