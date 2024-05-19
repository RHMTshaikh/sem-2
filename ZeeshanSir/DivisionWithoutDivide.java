package ZeeshanSir;

public class DivisionWithoutDivide {
    public static void main(String[] args) {
        DivisionWithoutDivide d = new DivisionWithoutDivide();
        System.out.println(d.divide(30, 3));
        
    }
    // >> preserves the sign bit
    // << does not preservs the sign bit
    // >>> does not preservs the sign bit
    // <<< this does not exist
    
    int divide(int divident, int divisor){
        int m = Math.abs(divident);
        int n = Math.abs(divisor);
        boolean negetive = (divident >=0 && divisor >=0)||(divident <0 && divisor <0) ? false : true;
        int count = 1;
        int ans = 0;
        while (m >= n) {
            while (n*count <= m) {
                count<<=1;
            }
            count>>=1;
            m -= n*count;
            ans += count;
            count = 1;
        }
        return negetive ? -ans : ans;
    }
}
