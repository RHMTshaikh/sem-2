
#include <stdio.h>
#include <string.h>
char reVal(char i){
    if(i>=0 && i<=9) 
        return (char)(i + '0');
    else 
        return (char)(i-10+ 'A');
}

void reverse(char* result){
    int start=0, end=strlen(result)-1;
    while(start<end){
        char tmp=result[start];
        result[start++]=result[end];
        result[end--]=tmp;
    }

}

char* fromDecimal(char result[], int num, int base){
    printf("here");
    int index=0;
    while (num>0){
        result[index++] = reVal(num % base);
        num /=base;
    }
    result[index]='\0';
    reverse(result);
    
    return result;
}

int main(){
    int num, base;
    char result[100];
    printf("Enter the number: ");
    scanf("%d",&num);
    printf("Enter the base: ");
    scanf("%d",&base);
    printf("Equivqlent of decimal number %d in base %d is %s\n",num,base,fromDecimal(result,num,base));

    return 0;
}


