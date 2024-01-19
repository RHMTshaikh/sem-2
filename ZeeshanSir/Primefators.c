// #include<stdio.h> 
// #include<math.h> 
// void primeFactors(int n) { 
//     int i; while(n % 2 == 0) {
//         printf("%d, ", 2); 
//         n = n/2; //reduce n by dividing this by 2 } 
//         for(i = 3; i <= sqrt(n); i=i+2){ //i will increase by 2, to get only odd numbers 
//             while(n % i == 0) { 
//             printf("%d, ", i); 
//             n = n/i; } 
//         } 
//         if (n > 2) { 
//             printf("%d, ", n); 
//         }
//     } 
// }

// int main() { 
// int n; 
// printf("Enter a number: "); 
// scanf("%d", &n); 
// primeFactors(n); 
// return 0;
// }

#include <stdio.h>

void printPrimeFactors(int n) {
    // Print the number of 2s that divide n
    while (n % 2 == 0) {
        printf("2 ");
        n = n / 2;
    }

    // n must be odd at this point, so a skip of 2 ( i = i + 2) can be used
    for (int i = 3; i * i <= n; i = i + 2) {
        // While i divides n, print i and divide n
        while (n % i == 0) {
            printf("%d ", i);
            n = n / i;
        }
    }

    // If n is still greater than 1, then it's a prime factor
    if (n > 1) {
        printf("%d ", n);
    }
}

int main() {
    int n;
    
    printf("Enter an integer: ");
    scanf("%d", &n);

    if (n <= 1) {
        printf("Prime factors are not defined for numbers less than or equal to 1.\n");
    } else {
        printf("Prime factors of %d are: ", n);
        printPrimeFactors(n);
        printf("\n");
    }

    return 0;
}
