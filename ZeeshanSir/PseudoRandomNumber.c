#include <stdio.h>
#define A 1145
#define C 123
#define M 2147

unsigned int seed = 11; // initial seed

unsigned int lcg_rand() {
    seed = (A * seed + C) % M;
    return seed;
}

int main() {
    int i;
    for(i = 0; i < 10; i++) {
        printf("%u\n", lcg_rand());
    }
    return 0;
}
