#include <stdio.h>
int i;
double power(double x, long long n) {
    double result = 1.0;
    while (n > 0) {
        if (n % 2 == 1) {
            result *= x;
        }
        x *= x;
        n /= 2;
    }
    return result;
}
int main() {
    double x= 2;
    long long n = 23;
    // printf("Enter the base (x): ");
    // scanf("%lf", &x);
    // printf("Enter the exponent (n): ");
    // scanf("%lld", &n);
    if (n < 0) {
        printf("Exponent should be a non-negative integer.\n");
    } else {
        double result = power(x, n);
        printf("%.3lf^%lld = %.6lf\n", x, n, result);
    }
    return 0;
}
