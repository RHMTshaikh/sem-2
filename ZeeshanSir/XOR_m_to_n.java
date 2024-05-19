package ZeeshanSir;
public class XOR_m_to_n { // this question is not on leetcode
    public static void main(String[] args) {
        XOR_m_to_n x = new XOR_m_to_n();
        System.out.println(x.xor_m_to_n(1, 2));
    }
    int xor_m_to_n(int n, int m){
        return XORUptoN(n-1)^XORUptoN(m);
    }
    int XORUptoN(int n){
        if (n%4 ==0) {
            return n;
        } else if(n%4==1) {
            return 1;
        } else if(n%4==2) {
            return n+1;
        } else{
            return 0;
        }
    }
}
