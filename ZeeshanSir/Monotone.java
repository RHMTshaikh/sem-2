public class Monotone {
    public static void main(String[] args) {
       int[] nums = {1,2,3,9,4,7,3,11,8,14,16,23,22}; 
       System.out.println(monotone(nums));
    }

    public static int monotone(int[] arr){
        int l = arr.length;
        int[] mono_arr = new int[l];
        int max_index=0;
        mono_arr[0]=1;
        for (int i = 1; i < l; i++) {
            if(arr[max_index]<arr[i]){
                mono_arr[i] = mono_arr[max_index]+1;
                max_index=i;
            } else {
                int max_index2=0;
                for (int j = 0; j <= i; j++) {
                    if(arr[j]<arr[i] && mono_arr[j]>mono_arr[max_index2]){
                        max_index2=j;
                    }
                }
                mono_arr[i] = mono_arr[max_index2]+1;
                if (mono_arr[max_index2]>mono_arr[max_index]) {
                    max_index=max_index2;
                }
            }
        }
        return mono_arr[max_index];
    }
}