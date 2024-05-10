package ZeeshanSir;


class MyQueue{
    Node firstNode, lastNode;
    class Node{
        BinaryTree element;
        Node next;
    }
    void push(BinaryTree element){
        if (lastNode == null) {
            this.lastNode = new Node();
            this.lastNode.element = element;
            firstNode = new Node();
            firstNode = lastNode;
        }else{
            this.lastNode.next = new Node();
            this.lastNode = lastNode.next;
            this.lastNode.element = element;
        }
    }
    BinaryTree pop(){
        Node head = firstNode;
        firstNode = firstNode.next;

        return head.element;
    }
    
}


class CircularQueue {
    int[] queue;
    int capacity;
    int front =-1;
    int rear = -1;
    boolean isEmpty(){
        if (rear == -1) {
            return true;
        }else return false;
    }
    int size(){ //1 2 3 4 5 6 7 8 9 
        if (rear == -1) return 0;
        else if(rear > front) return rear-front+1;
        else return capacity+rear-front+1;
    }
    void push(int val) throws Exception{
        if ((rear+1)%capacity == front) throw new Exception("Queue is full");

        if(rear == -1){
            front =0;
            rear=0;
        }else{
            rear =(rear+1)%capacity;
        }
        queue[rear] = val;
    }
    int pop() throws Exception{
        if(front == -1) throw new Exception("Queue is empty");

        int x = queue[front];
        if (front == rear) {
            front=-1;
            rear=-1;
        }else{
            front = (front+1)%capacity;
        }
        return x;
    }
    void display(){
        int i = front;
        while (i != rear) {
            System.out.print(queue[i]+" ");
            i = (i+1)%capacity;
        }
        System.out.print(queue[i]+" ");
    }

}