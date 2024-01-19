//adding to check
public class Merging {
    public static void main(String[] args) {
        int[] a ={15,18,42,51};
        int[] b ={58,71,74,77,77,77};
        int[] c = merge(b,a);
        for (int i : c) {
            System.out.print(i+" ");
        }
    }

    public static int[] merge(int[] a, int[] b){
        int a_length = a.length;
        int b_length = b.length;
        int c_length = a_length+b_length;
        int[] c = new int[c_length];

        if(a[a_length-1]<=b[0]){
            for (int i = 0; i < a_length; i++) {
                c[i] = a[i];
            }
            for (int i = 0; i < b_length; i++) {
                c[a_length + i] = b[i];
            }
        } else if (b[b_length-1]<=a[0]) {
            for (int i = 0; i < b_length; i++) {
                c[i] = b[i];
            }
            for (int i = 0; i < a_length; i++) {
                c[b_length + i] = a[i];
            }
        } else if(a[a_length-1]<b[b_length-1]){
            int i=0, j=0;
            while (i<a_length) {
                if(a[i]<b[j]){
                    c[i+j] = a[i];
                    i++;
                } else{
                    c[i+j] = b[j];
                    j++;
                }
            }
            while (j<b_length) {
                c[i+j] = b[j];
                j++;
            }
        } else{
            int i=0, j=0;
            while (j<b_length) {
                if(a[i]<b[j]){
                    c[i+j] = a[i];
                    i++;
                } else{
                    c[i+j] = b[j];
                    j++;
                }
            }
            while (i<a_length) {
                c[i+j] = a[i];
                i++;
            }
        }
        return c;
    }
}
