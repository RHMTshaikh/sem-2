#include <stdio.h>

int main() {
    int arr[] = {1,1,1,2,2,3,3,4,5,5};
    int n = sizeof(arr) / sizeof(arr[0]);
    int currentElement= arr[0];
    printf("%d ",currentElement);

    for (int i = 0; i < n; i++) {
        if(currentElement!= arr[i]){
            currentElement = arr[i];
            printf("%d ",currentElement);
        }
    }
    return 0;
}
