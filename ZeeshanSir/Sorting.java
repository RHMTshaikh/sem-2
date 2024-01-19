public class Sorting {
    public static void main(String[] args) {
        int[] array = {9,0,0,8, 5,4,4,4,4,9,9,9,2,2,2,4,8,3,-17,9,3,8,48,2,4, 12, 7,0};
        int[] array1 = {1,3,5,9,10,55,88};
        int[] array2 = {2,3,5,7,8};
        int arrLength = array.length;

        // System.out.println("merge sorted array sort");
        // for (int i : mergeSortedArray(array1,array2)) {
        //     System.out.print(i+" ");
            
        // }System.out.println();
        
        System.out.println("Bubble sort");
        for (int i : bubbleSort(array)) {
            System.out.print(i+" ");

        }System.out.println();

        System.out.println("Selection sort");
        for (int i : selectionSort(array)) {
            System.out.print(i+" ");
            
        }System.out.println();

        System.out.println("Insertion sort");
        for (int i : insertionSort(array)) {
            System.out.print(i+" ");
        }System.out.println();

        System.out.println("Qqick sort");
        for (int i : quickSort(array, 0,arrLength-1)) {
            System.out.print(i+" ");
            
        }System.out.println();

    }

    public static int[] mergeSortedArray(int[] arr1, int[] arr2){
        int[] arr3 = new int[arr1.length+arr2.length];
        int pointer1=0, pointer2=0, pointer3=0;
        while(pointer1 < arr1.length && pointer2 < arr2.length){
            if (arr1[pointer1]<arr2[pointer2]) {
                arr3[pointer3++] =arr1[pointer1++];
            } else {
                arr3[pointer3++] =arr2[pointer2++];
            }
        }
        while (pointer1<arr1.length) {
            arr3[pointer3++]=arr1[pointer1++];
        }
        while (pointer2<arr2.length) {
            arr3[pointer3++]=arr2[pointer2++];
        }
        return arr3;
    }
    
    public static int[] bubbleSort(int[] a){
        int[] arr = new int[a.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=a[i];
        }
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        return arr;
    }

    public static int[] selectionSort(int[] a){
        int[] arr = new int[a.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=a[i];
        }
        int indexMin;
        for (int j = 0; j < arr.length-1; j++) {
            indexMin =j;
            for (int i = j+1; i < arr.length; i++) {
                if(arr[indexMin]>arr[i]){
                    indexMin = i;
                }
            }
            int temp = arr[indexMin];
            arr[indexMin] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }

    public static int[] insertionSort(int[] a){
        int[] arr = new int[a.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=a[i];
        }
        for (int i = 1; i< arr.length; i++) {
            int x= arr[i];
            int j=i;
            for (;j>0;j--){
                if(arr[j-1]>x){
                    arr[j] = arr[j-1];
                } else{
                    arr[j]=x;
                    break;
                }
            }
            if(j==0) arr[j]=x;
        }
        return arr;
    }

    public static int partition(int[] arr, int low, int high){
        int pivot = arr[high]; // rightmost element is always the pivot
        int i = low -1;
        for(int j = low; j<high; j++){
            if(arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[high] = arr[i + 1];
        arr[i + 1] = pivot;

        return i + 1;
    }

    public static int[] quickSort(int[] arr, int low, int high){
        if(low<high){
            int p_index = partition(arr,low,high);

            quickSort(arr, low, p_index-1);
            quickSort(arr, p_index+1, high);
        }
        return arr;
    }


}
