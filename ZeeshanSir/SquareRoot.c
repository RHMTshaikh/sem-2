#include <stdio.h>
#include <math.h>
double sqroot(double m, double error) {
    // int steps =1;
    double g1, g2;
    g1 = m / 2.0;
    g2 = (g1 + m/g1)/2;
    while (fabs(g1 - g2) >= error) {
        // steps++;
        g1 = g2;
        g2 = (g1 + m / g1) / 2.0;
    }
    // printf("Number of iterations: %d\n",steps);
    return g2;
}
int main() {
    double number = 98452; 
    double tolerance = 1e-6; 
    double result = sqroot(number, tolerance);
    printf("Square root of %.2f is approximately %.6f\n", number, result);
    return 0;
}
