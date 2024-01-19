#include <stdio.h>
int calculateGCD(int a, int b) {
    if (b == 0) {
        return a;
    } else {
        return calculateGCD(b, a % b);
    }
}
int calculateLCM(int a, int b) {
    return (a * b) / calculateGCD(a, b);
}
int main() {
    int num1, num2;
    
    printf("Enter the first number: ");
    scanf("%d", &num1);

    printf("Enter the second number: ");
    scanf("%d", &num2);

    int gcd = calculateGCD(num1, num2);
    int lcm = calculateLCM(num1, num2);

    printf("GCD of %d and %d is %d\n", num1, num2, gcd);
    printf("LCM of %d and %d is %d\n", num1, num2, lcm);

    return 0;
}
