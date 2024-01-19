import java.util.Random;

public class MyArray {
    
    int[] array;
    int len=0;
    int capacity;

    MyArray(){}

    MyArray(int capacity){
        this.capacity=capacity;
        array = new int[capacity];
    }

    MyArray(int[] array){
        this.array=array;
        capacity = array.length;
        len=capacity;
    }

    public void display(){
        for (int i=0; i < len; i++) {
            System.out.print(array[i]+" ");
        }System.out.println();
    }
    
    public void add(int val){
        if(len < capacity){
            array[len]=val;
            len++;
        } else{
            System.out.println("full");
        }
    }

    public void delete(int index){
        if(len > 0 && index < len){
            for(int i = index; i < len-1; i++) {
                array[i] = array[i+1];
            }
            len--;
        }else{
            System.out.println("invalid index or Array is empty");
        }
    }

    public void remove(int val){
        if(len > 0){
            for(int i = 0; i < len; i++) {
                if(array[i]==val){
                    this.delete(i);
                    len--;
                    break;
                }
            }
        } else{
            System.out.println("Array is empty");
        }
    }
    public void removeAll(int val){
        if(len > 0){
            for(int i = 0; i < len; i++) {
                if(array[i]==val){
                    delete(i);
                    i--;
                }
            }
        } else{
            System.out.println("Array is empty");
        }
    }
    
    public boolean isEmpty(){
        if(len==0) return true;
        else return false;
    }

    public void insert(int val, int index){
        if(index < len && len < capacity){
            for (int i = len-1; i >= index; i--) {
                array[i+1] = array[i];
            }
            array[index]=val;
            len++;
        }else{
            System.out.println("invalid index or capacity full");
        }
    }

    public int getRandomElement(){
        Random rdm = new Random();
        int i = rdm.nextInt(len);
        return array[i];
    }

    public int popRandomElement(){
        Random rdm = new Random();
        int k = rdm.nextInt(len);
        int val = array[k];
        delete(k);
        return val;
    }
    
    public int indexOf(int val){
        if(len > 0){
            System.out.println(len);
            for(int i = 0; i < len; i++) {
                if(array[i]==val) return i;
            }
        } else{
            System.out.println("Array is empty or Value is not present");
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] arr = {6,5,4,3,2,1};
        MyArray m = new MyArray(arr);
        System.out.println(m.isEmpty());
        System.out.println(m.len);
        System.out.println(m.capacity);

    } 
}