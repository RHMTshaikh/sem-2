package ZeeshanSir;

class MyStack {
    int[] stack ;
    int top=-1;
    int length;

    MyStack(int length){
        this.length = length;
        stack = new int[length];
    }
    void push(int element) throws Exception{
        if (top == length-1) throw new Exception("stack is full");       
        top++;
        stack[top] = element;
    }
    int pop(){
        if(top < 0) throw new IllegalArgumentException("Stack is empty");

        return stack[top--];
    }
    int peep(int index){
        if(index<0 || index>top) throw new IllegalArgumentException("invalid index");
        return stack[top-index];
    }
    int peek(){
        return stack[top];
    }
    boolean isEmpty(){
        if (top == -1) {
            return true;
        }else{
            return false;
        }
    }
    int size(){
        return top+1;
    }
    void display(){
        for (int i = 0; i < stack.length; i++) {
            System.out.print(stack[i]+" ");
        }
    }
     public static void main(String[] args) {
        MyStack m = new MyStack(10);
        try {
            m.push(4);
            m.push(5);
            m.push(6);
            m.push(6);
            m.push(6);
            m.push(6);
            m.push(6);
            m.push(6);
            m.push(6);
            m.push(6);
            m.push(6);
            m.push(6);
            m.push(6);
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println(m.stack[0]);
        System.out.println(m.stack[1]);
        System.out.println(m.stack[2]);
     }
}