public class MyQueue {
    int len=0;
    Node frontNode, rareNode;
    class Node{
        int value;
        Node nextNode;
        Node(int val){
            value = val;
        }
    }

    public void add(int val){
        Node newNode = new Node(val);
        if(frontNode==null) {
            this.frontNode = newNode;
            this.rareNode = newNode;
        } else{
            rareNode.nextNode = newNode;
            rareNode = newNode;
        }
        len++;
    }

    int out(){
        int val = frontNode.value;
        frontNode = frontNode.nextNode;
        len--;
        return val;
    }

    void display(){
        if(len > 0){
            int l = len;
            Node firstNode = frontNode;
            while (l>0) {
                System.out.print(firstNode.value+" ");
                l--;
                firstNode= firstNode.nextNode;
            } System.out.println();
        } else{
            System.out.println("queue is empty");
        }
    }
}

class TestMyQueue{
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.add(1);
        q.display();
        
    }

}
