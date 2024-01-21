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
        if((index <= size && size < capacity)){
            for (int i = size-1; i >= index; i--) {
                array[i+1] = array[i];
            }
            array[index]=val;
            size++;
        }else{
            System.out.println("invalid index or capacity full");
        }
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

    void storeOddThenEven(int n){//1 3 5 7 2 4 6
        if(n>0){
            capacity =n;
            array = new int[capacity];
            int lastIndexOfOdd = (n-1)/2;
            int largestOdd = ((n-1)/2)*2+1;
            for (int i = 0; i < n; i++) {
                insert(2*i+1-((largestOdd)*(i/(lastIndexOfOdd+1))),i);
            }
        }else System.out.println("n must be greater than 0");
    }

    void storeEvenTwice(int n){//1 2 2 3 4 4 5 6 6 7 8 8 9
        if(n>0){
            capacity =3*n/2;
            array = new int[capacity];
            for (int i = 0; i < n; i++) {
                if(i%2==0){
                    insert(i+1, size);
                } else{
                    insert(i+1, size);
                    insert(i+1, size);
                }
            }
        }else System.out.println("n must be greater than 0");
    }

    void deleteDuplicate(int n){
        int m;
        if(n%2==0){
            m = 3*n/2-1;
        }else{
            m = 3*n/2-2;
        }
        for (int i = m; i > 1; i-=3) {
            delete(i);
        }
    }
    
}

class TestMyArray{    
    public static void main(String[] args) {
        MyArray twiceEven = new MyArray();
        MyArray oddThenEven = new MyArray();
        twiceEven.storeEvenTwice(9);       //1 2 2 3 4 4 5 6 6 7 8 8 9 
        oddThenEven.storeOddThenEven(19);   //1 3 5 7 9 2 4 6 8
        twiceEven.display();   
        oddThenEven.display();   
        twiceEven.deleteDuplicate(9);      //1 2 3 4 5 6 7 8 9
        twiceEven.display();

    }
}