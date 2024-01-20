import java.util.Random;

public class MyArray {
    
    int[] array;
    int size=0;
    int capacity;

    MyArray(){}

    MyArray(int capacity){
        this.capacity=capacity;
        array = new int[capacity];
    }

    MyArray(int[] array){
        this.array=array;
        capacity = array.length;
        size=capacity;
    }

    int getSize(){
        return size;
    }

    int length(){
        return capacity;
    }

    int getElement(int index){
        return array[index];
    }
    
    public void display(){
        for (int i=0; i < size; i++) {
            System.out.print(array[i]+" ");
        }System.out.println();
    }
    
    public void add(int val){
        if(size < capacity){
            array[size]=val;
            size++;
        } else{
            System.out.println("full");
        }
    }

    public void delete(int index){
        if(size > 0 && index < size){
            for(int i = index; i < size-1; i++) {
                array[i] = array[i+1];
            }
            size--;
        }else{
            System.out.println("invalid index or Array is empty");
        }
    }

    public void remove(int val){
        if(size > 0){
            for(int i = 0; i < size; i++) {
                if(array[i]==val){
                    this.delete(i);
                    size--;
                    break;
                }
            }
        } else{
            System.out.println("Array is empty");
        }
    }
    public void removeAll(int val){
        if(size > 0){
            for(int i = 0; i < size; i++) {
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
        if(size==0) return true;
        else return false;
    }

    public void insert(int val, int index){
        if(index < size && size < capacity){
            for (int i = size-1; i >= index; i--) {
                array[i+1] = array[i];
            }
            array[index]=val;
            size++;
        }else{
            System.out.println("invalid index or capacity full");
        }
    }

    public int getRandomElement(){
        Random rdm = new Random();
        int i = rdm.nextInt(size);
        return array[i];
    }

    public int popRandomElement(){
        Random rdm = new Random();
        int k = rdm.nextInt(size);
        int val = array[k];
        delete(k);
        return val;
    }
    
    public int indexOf(int val){
        if(size > 0){
            System.out.println(size);
            for(int i = 0; i < size; i++) {
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
        System.out.println(m.size);
        System.out.println(m.capacity);

    } 
}