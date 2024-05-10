package ZeeshanSir;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> {
    T val;
    int height=0;
    BinaryTree<T>  leftNode, rightNode;

    BinaryTree(){}

    BinaryTree(T val){
        this.val = val;
    }

    void addLeftNode( T val){
        this.leftNode = new BinaryTree<T>(val);
    }
    void addRightNode( T val){
        this.rightNode = new BinaryTree<T>(val);
    }

    static <T> BinaryTree<T> arraryToTree(T[] arr){
        if (arr.length ==0) {
            BinaryTree<T> b = new BinaryTree<T>();
            return b;
        }
        else if (arr.length == 1){
            BinaryTree<T> b = new BinaryTree<T>(arr[0]);
            b.height++;
            return b;
        } else{
            int l = 0, u = arr.length-1;
            int mid = l + (u-l)/2;
            BinaryTree<T> b = new BinaryTree<T>(arr[mid]);
            b.height = (int) Math.ceil(Math.log(arr.length+1)/Math.log(2));
            b.leftNode = arraryToTree(arr, l, mid-1);
            b.rightNode = arraryToTree(arr, mid+1, u);
            return b;
        }
        
    }
    static<T> BinaryTree<T> arraryToTree(T[] arr, int l, int u){
        if (u < l) {
            return null;
        }
        if (l == u) {
            BinaryTree<T> b = new BinaryTree<T>(arr[l]);
            return b;
        }
        int mid = l + (u-l)/2;
        BinaryTree<T> b = new BinaryTree<T>(arr[mid]);
        b.leftNode = arraryToTree(arr, l, mid-1);
        b.rightNode = arraryToTree(arr, mid+1, u);
        return b;         
    }
    static<T> T[] treeToArrayUsingQueueLevelOrder(BinaryTree<T> root){
        if (root == null) {
            return null;            
        }
        // T[] array = new T[ (int)(Math.pow(2,root.height)-1)];
        // @SuppressWarnings("unchecked")
        // T[] array = (T[]) new Object[(int) (Math.pow(2, root.height) - 1)];

        @SuppressWarnings("unchecked")
        T[] array = (T[]) Array.newInstance(root.val.getClass(), (int) (Math.pow(2, root.height) - 1));

        int index =0;
        
        Queue<BinaryTree<T>> queue = new LinkedList<>(); //add poll peek
        queue.add(root);
        return treeToArrayUsingQueueLevelOrder(queue, array, index);
    }
    static <T> T[] treeToArrayUsingQueueLevelOrder(Queue<BinaryTree<T>> queue, T[] array, int index){
        if (queue.peek() == null) {
            return array;
        }
        BinaryTree<T> currNode = queue.poll();
        
        array[index++] = currNode.val;
        
        if (currNode.leftNode != null) {
            queue.add(currNode.leftNode);
        }
        if (currNode.rightNode != null) {
            queue.add(currNode.rightNode);
        }
        return treeToArrayUsingQueueLevelOrder(queue, array, index);
    }
    static Integer evaluateExpressionTree(BinaryTree<Character> root){
        if (root == null) {
            return null;            
        }
        if (0 <= root.leftNode.val -'0') {
            switch (root.val) {
                case '+':
                    return ((root.leftNode.val)-'0') + ((root.rightNode.val)-'0');
                    
                case '-':
                    return ((root.leftNode.val)-'0') - ((root.rightNode.val)-'0');
                    
                    
                case '*':
                    return ((root.leftNode.val)-'0') * ((root.rightNode.val)-'0');
                    
                    
                case '/':
                    return ((root.leftNode.val)-'0') / ((root.rightNode.val)-'0');
            }
        }
        switch (root.val) {
            case '+':
                return evaluateExpressionTree(root.leftNode) + evaluateExpressionTree(root.rightNode);
                
            case '-':
                return evaluateExpressionTree(root.leftNode) - evaluateExpressionTree(root.rightNode);
                
                
            case '*':
                return evaluateExpressionTree(root.leftNode) * evaluateExpressionTree(root.rightNode);
                
                
            case '/':
                return evaluateExpressionTree(root.leftNode) / evaluateExpressionTree(root.rightNode);
        }
        return null;
    }
    void display(){
        int width = (int) Math.pow(2,height-1)*2-1;
        int level =1;
        int numberOfSideSpaces = width/2;
        int numberOfMiddleSpaces = 0;
        Queue<BinaryTree<T>> q = new LinkedList<>();
        q.add(this);
        
        while (level <= height) {
            int numOfNodes = (int) Math.pow(2,level-1);
            
            String dashes = "_".repeat(numberOfSideSpaces);
            System.out.print(dashes);
            
            for (int i = 0; i < numOfNodes; i++) {
                if (q.peek() != null) {
                    q.add(q.peek().leftNode);
                    q.add(q.peek().rightNode);
                }
                
                if(q.peek() != null){
                    System.out.print(q.poll().val);
                    // q.pop();
                } else{
                    System.out.print("*");
                    q.poll();
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
        // Integer[] arr1 ={1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
        // BinaryTree<Integer> a = arraryToTree(arr1);
        // a.display();
        // Integer[] arr2 = treeToArrayUsingQueueLevelOrder(a);
        // System.out.println("Level Order");
        // System.out.println(Arrays.toString(arr2));
        BinaryTree<Character> expressionTree = new BinaryTree<>('/');
        expressionTree.addRightNode( '-');
        expressionTree.rightNode.addLeftNode( '9');
        expressionTree.rightNode.addRightNode( '4');
        expressionTree.addLeftNode( '*');
        expressionTree.leftNode.addLeftNode( '+');
        expressionTree.leftNode.addRightNode( '-');
        expressionTree.leftNode.rightNode.addLeftNode( '7');
        expressionTree.leftNode.rightNode.addRightNode( '2');
        expressionTree.leftNode.leftNode.addLeftNode( '9');
        expressionTree.leftNode.leftNode.addRightNode( '4');

        int result = evaluateExpressionTree(expressionTree);
        System.out.println(result);

        Character c = '/';
        System.out.println((c-'0'));
    }
}