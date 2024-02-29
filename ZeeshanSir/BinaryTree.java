package ZeeshanSir;

public class BinaryTree {
    int val, depth=0;
    BinaryTree  leftNode, rightNode;

    BinaryTree(){}

    BinaryTree(int val){
        this.val = val;
    }

    static void addLeftNode(BinaryTree currentNode, int val){
        currentNode.leftNode = new BinaryTree(val);
    }
    static void addRightNode(BinaryTree currentNode, int val){
        currentNode.rightNode = new BinaryTree(val);
    }

    static BinaryTree arraryToTree(int[] arr){
        if (arr.length ==0) {
            BinaryTree b = new BinaryTree();
            return b;
        }
        else if (arr.length == 1){
            BinaryTree b = new BinaryTree(arr[0]);
            b.depth++;
            return b;
        } else{
            int l = 0, u = arr.length-1;
            int mid = l + (u-l)/2;
            BinaryTree b = new BinaryTree(arr[mid]);
            b.depth = (int) Math.ceil(Math.log(arr.length+1)/Math.log(2));
            b.leftNode = arraryToTree(arr, l, mid-1);
            b.rightNode = arraryToTree(arr, mid+1, u);
            return b;
        }
        
    }
    static BinaryTree arraryToTree(int[] arr, int l, int u){
        if (u < l) {
            return null;
        }
        if (l == u) {
            BinaryTree b = new BinaryTree(arr[l]);
            return b;
        }
        int mid = l + (u-l)/2;
        BinaryTree b = new BinaryTree(arr[mid]);
        b.leftNode = arraryToTree(arr, l, mid-1);
        b.rightNode = arraryToTree(arr, mid+1, u);
        return b;         
    }
    void display(){
        int width = (int) Math.pow(2,depth-1)*2-1;
        int level =1;
        int numberOfSideSpaces = width/2;
        int numberOfMiddleSpaces = 0;
        MyQueue q = new MyQueue();
        q.push(this);
        
        while (level <= depth) {
            int numOfNodes = (int) Math.pow(2,level-1);
            
            String dashes = "_".repeat(numberOfSideSpaces);
            System.out.print(dashes);
            
            for (int i = 0; i < numOfNodes; i++) {
                if (q.firstNode.element != null) {
                    q.push(q.firstNode.element.leftNode);
                    q.push(q.firstNode.element.rightNode);
                }
                
                if(q.firstNode.element != null){
                    System.out.print(q.firstNode.element.val);
                    q.pop();
                } else{
                    System.out.print("*");
                    q.pop();
                }
                dashes = "_".repeat(numberOfMiddleSpaces);
                if (i != numOfNodes-1) {
                    System.out.print(dashes);
                }
            }
            dashes = "_".repeat(numberOfSideSpaces);
            System.out.print(dashes);

            numberOfMiddleSpaces = numberOfSideSpaces;
            numberOfSideSpaces /=2;

            level++;
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        BinaryTree a = arraryToTree(arr1);
        a.display();
    }
}

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
