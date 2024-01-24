public class K_Smallestnumber {
    public static void main(String[] args) {
        int nums[] = {0,1,8, 0,2, 3, 4};
        System.out.println(k_Smallestnumber(nums, 5));
    }

    public static int k_Smallestnumber(int[] arr, int k){
        k--;//to make it the index
        int l=0, u=arr.length-1;
        while (l<u) {
            int i=l,j=u, x=arr[k];
            while (i<j && arr[i]<x) {
                i++;
            }
            while (i<j && arr[j]>x) {
                j--;
            }
            while (i<j) {
                int t = arr[i];
                arr[i]=arr[j];
                arr[j]=t;
                
                //i++;
                //j--; //the new element came by swaping may be equal to the partitioning value, and it was ignoring it and was moving on further 
                while (i<j && arr[i]<x) {
                    i++;
                }
                while (i<j && arr[j]>x) {
                    j--;
                }
            }
            if(j==k) return arr[k];
            if(j>k) u=j;
            if(i<k) l=i;
        }
        return arr[k];
    }
}
