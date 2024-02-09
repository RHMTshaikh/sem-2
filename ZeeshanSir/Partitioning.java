package ZeeshanSir;

public class Partitioning {
    public static void main(String[] args) {
        // int[] arr = {2,1,9,4,6,8,3,5,7,0};
        int[] arr = {2,8,3,8,1,7,6,1,4,6,8,1,2,0,1,2,0,1,2,0,0,0,9,7};

        for (int i : partition1(arr, -10)) {
            System.out.print(i+" ");
        }
        // System.out.println();
        // for (int i : partition2(arr, 2)) {
        //     System.out.print(i+" ");
        // }
        // System.out.println();
        // for (int i : partition3(arr, 7)) {
        //     System.out.print(i+" ");
        // }
    }   

    public static int[] partition1(int[] nums, int val){ //how to solve it by computer
        int[] arr = nums;
        int l=0, u=arr.length-1;
        while (l<u && arr[l]<=val) {
            l++;
        }
        while (l<u && arr[u]>val) {
            u--;
        }
        while (l<u) {
            int t = arr[l];
            arr[l]=arr[u];
            arr[u]=t;
            while (l<u && arr[l]<=val) {
                l++;
            }
            while (l<u && arr[u]>val) {// u is the partition index
                u--;
            }
        }
        System.out.println("l= "+l);
        System.out.println("u= "+u);// u is the partition index
        return arr;
    } 



    public static int[] partition2(int[] arr, int index){//working
        int smaller =0, bigger = arr.length-1;
        while(smaller < bigger ) {
            while(arr[smaller]<=arr[index] && smaller<=index){
                smaller++;
            }
            while (arr[bigger]>arr[index] && bigger>index) {
                bigger--;
            }
            if(smaller==index) index=bigger;
            if(bigger==index) index=smaller;

            int temp = arr[smaller];
            arr[smaller]=arr[bigger];
            arr[bigger]=temp;
        }
        int i;
        if(index>smaller){
            i =bigger;
        } else{
            i = smaller;
        }
        int temp = arr[i];
        arr[i] = arr[index];
        arr[index] = temp;
        System.out.println(arr[i]);

        return arr;
    }
}
