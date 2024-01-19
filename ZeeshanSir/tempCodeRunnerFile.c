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