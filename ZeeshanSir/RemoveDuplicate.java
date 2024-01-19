public class RemoveDuplicate {
    public static void main(String[] args) {
        int arr1[] = {0,1,2,2,2,3,3,4,5,5,5,6,6,6};
        for (int i : removeDuplicate1(arr1)) {
            System.out.print(i);
        }
        System.out.println();
        for (int i : removeDuplicate2(arr1,3)) {
            System.out.print(i);
        }
    }
    public int removeDuplicates(int[] nums){
        int j=1;
        for (int i = 1; i <nums.length; i++) {
            if (nums[j]!=nums[i]) {
                nums[++j]=nums[i];

            }
        }
        return j+1;
    }

    public static int[] removeDuplicate1(int[] arr1){
        int[] arr2 = new int[arr1.length];
        int j=0 ,i=0;
        arr2[j]=arr1[i];
        for (i = 1; i < arr1.length; i++) {

            if(arr2[j]!=arr1[i]){
                j++;
                arr2[j]=arr1[i];
            }
        }
        return arr2;
    }

    public static int[] removeDuplicate2(int[] arr1, int repeat){
        int j =0;
        int atMaxDuplicateItemCount=repeat;
        int duplicateItemCount=1;
        for (int i = 1; i < arr1.length; i++) {
            if (arr1[j]!=arr1[i]) {
                duplicateItemCount=1;
                j++;
                if(j < i){
                    arr1[j] = arr1[i];
                }
            } 
            else{
                duplicateItemCount++;
                if(duplicateItemCount<=atMaxDuplicateItemCount){
                    j++;
                    arr1[j] = arr1[i];
                }
            }
        }

        int[] arr2 =new int[j+1];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i]=arr1[i];
        }
        return arr2;
    }
}
