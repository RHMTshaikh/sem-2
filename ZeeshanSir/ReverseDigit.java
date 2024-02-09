package ZeeshanSir;

class Zeeshan{
    static int reverseDigitIter(int a){
        int b=0;
        while(a>0){
            int r = a%10;
            a/=10;
            b = b*10 + r;
        }
        return b;
    }
    // static int reverseDigitRecur(int a){
    //     if (a<10) {
    //         return a;
    //     } else {
    //         int r = a%10;
    //         a/=10;
    //         b = b*10 + r;            
    //     }

    //     return reverseDigitRecur(a);
    // }


static int reverseNumber(int a) {
    // Base case: If the number is a single digit, return it
    if (a < 10) {
        return a;
    } else {
        // // Get the last digit (remainder when divided by 10)
        // int lastDigit = number % 10;

        // // Recursively reverse the remaining digits (integer division by 10)
        // int reversed = reverseNumber(number / 10);

        // // Construct the reversed number by adding the last digit in the front
        int r = a%10;
        // a/=10;
        // b = b*10 + r;

        return reverseNumber(a/=10)*10 +a%10;
    }
}



    public static void main(String[] args) {
        // Zeeshan Z = new Zeeshan();
        System.out.println(reverseDigitIter(12345));
        System.out.println(reverseNumber(12345));
    }
}