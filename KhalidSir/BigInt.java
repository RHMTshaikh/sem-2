package KhalidSir;
import java.math.BigInteger;
import javax.swing.JOptionPane;
class BigInt{
     static BigInteger factorialBigInt(int n){  //limit is 12800!, System: intel(64bit) i3 11gen 8gbRAM 
        BigInteger factorial = BigInteger.ONE;
        if (n>1){
            factorial = (BigInteger.valueOf(n)).multiply(factorialBigInt(n-1));
        }
        return factorial;
    }
    public static void main(String[] args) {
        int n = Integer.parseInt(JOptionPane.showInputDialog("Enter your number(should be <=12800):"));

        JOptionPane.showMessageDialog(null, "Factorial of " + n + " is: " + 
            factorialBigInt(n)+".","null", JOptionPane.INFORMATION_MESSAGE);
    } 
}
/*Since BigInteger represents integers with an arbitrary number of digits, 
you can store integers of practically unlimited size. 
The only constraint is the amount of memory available to your Java application. 
The more memory your system has, the larger integers you can store in a BigInteger.*/