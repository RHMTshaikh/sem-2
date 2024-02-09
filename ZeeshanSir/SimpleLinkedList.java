package ZeeshanSir;

public class SimpleLinkedList {
    static class Node {
        int data;
        Node next;
        Node(int a){
            this.data = a;
            this.next=null;
        }
        Node(int a, Node nexNode){
            this.data = a;
            this.next=nexNode;
        }
        
    }
    private Node head;

    SimpleLinkedList(){
        this.head = null;
    }
    public void addNode(int a){
        if(head==null){
            head=new Node(a);
        } else{
            Node temp=head;
            while (temp.next!=null) {
                temp =temp.next;
            }
            temp.next= new Node(a);
        }
    }
    public void addNodeAt(int index, int a){
        if(index <= this.size()){
            Node temp = head;
            for (int i = 0; i < index-1; i++) {
                temp = temp.next;
            }
            if(index==0){
                Node newNode = new Node(a,temp);
                head = newNode;
            }else{
                Node newNode = new Node(a,temp.next);
                temp.next= newNode;
            }
        } else{
            System.out.println("Index is out of bound, size is: "+this.size());
        }
    }

    public Node nodeAt(int index){
        if(index ==0){
            return head;

        } else {
            Node temp = head;
            for (int i = 1; i <= index; i++) {
                temp = temp.next;
            }
            return temp;
        }
    }
    public int valueAtNode(int index){
        if(index ==0){
            return head.data;

        } else {
            Node temp = head;
            for (int i = 1; i <= index; i++) {
                temp = temp.next;
            }
            return temp.data;
        }
    }
    public void displayList(){
        if(head==null){
            System.out.println("The list is empty");
        } else{
            Node temp=head;
            while (temp!=null) {
                System.out.print(temp.data+" ");
                temp =temp.next;
            }
            System.out.println();
        }
    }
    public int size(){
        if(head==null){
            System.out.println();
            return 0;
        } else{
            Node temp=head;
            int i = 1;
            for (;temp.next!=null; i++) {
                temp =temp.next;
            }
            return i;
        }
        
    }
    public static SimpleLinkedList addTwoList(SimpleLinkedList l1, SimpleLinkedList l2){
        SimpleLinkedList l3 = new SimpleLinkedList();
        Node temp1 = l1.head, temp2 = l2.head;
        int carry=0;
        for (int i = 0; i < l1.size(); i++) {
            if((temp1.data + temp2.data + carry)/10==0){
                l3.addNode(temp1.data + temp2.data + carry);
                carry=0;
                
            }else{
                l3.addNode((temp1.data + temp2.data + carry)%10);
                carry = 1;
            }
            temp1= temp1.next;
            temp2= temp2.next;
        }
        if (carry==1) {
            l3.addNode(carry);
        }
        return l3;
    }
    public static SimpleLinkedList revLinkedList(SimpleLinkedList list){
        SimpleLinkedList revList =  new SimpleLinkedList();
        Node temp = list.head;
        for (int i = 0; i < list.size(); i++) {
            temp = list.head;
            for (int j = 0; j < list.size()-i-1; j++) {
                temp = temp.next;
            }
            revList.addNode(temp.data);
        }
        return revList;
    }

    public static SimpleLinkedList concatLinkedList(SimpleLinkedList l1, SimpleLinkedList l2){
        SimpleLinkedList list = new SimpleLinkedList();
        Node temp = l1.head;
        while(temp != null){
            list.addNode(temp.data);
            temp = temp.next;
        }
        temp = l2.head;
        while(temp != null){
            list.addNode(temp.data);
            temp = temp.next;
        }
        
        return list;
    }
    public static void main(String[] args) {
        SimpleLinkedList list1 = new SimpleLinkedList();
        SimpleLinkedList list2 = new SimpleLinkedList();
        SimpleLinkedList list3 = new SimpleLinkedList();
        // list.addNode(1);
        // list.addNode(2);
        // list.addNode(3);
        for (int i = 1; i < 8; i++) {
            list1.addNode(i);
        }
        // revLinkedList(list1).displayList();
        for (int i = 1; i < 8; i++) {
            list2.addNode(i);
        }
        for (int i = 1; i < 8; i++) {
            list3.addNode(i);
        }
        list1.displayList();
        list2.displayList();
        System.out.println("concate");
        concatLinkedList(list2, list3).displayList();
        System.out.println("reverse");
        revLinkedList(list3).displayList();
        System.out.println("addition");
        addTwoList(list1, list2).displayList();
        addTwoList(list1,revLinkedList(list3)).displayList();
    }
}

// public class SimpleLinkedList {
//     // Node class to represent elements in the linked list
//     static class Node {
//         int data;
//         Node next;
//         public Node(int data) {
//             this.data = data;
//             this.next = null;
//         }
//     }
//     // Head of the linked list
//     private Node head;
//     private  static SimpleLinkedList smpl;
//     // Constructor
//     public SimpleLinkedList() {
//         this.head = null;
//     }
//     // Method to add a new element to the linked list
//     public void addNode(int data) {
//         Node newNode = new Node(data);
//         if (head == null) {
//             head = newNode;
//         } else {
//             Node current = head;
//             while (current.next != null) {
//                 current = current.next;
//             }
//             current.next = newNode;
//         }
//     }
//     // Method to display the elements of the linked list
//     public void displayList() {
//         Node current = head;
//         while (current != null) {
//             System.out.print(current.data + " ");
//             current = current.next;
//         }
//         System.out.println();
//     }

//     public void addLinkedList(SimpleLinkedList l1,SimpleLinkedList l2,SimpleLinkedList l3){
        
//     }
//     public static void main(String[] args) {
//         // Creating a simple linked list
//         SimpleLinkedList linkedList1 = new SimpleLinkedList();
//         SimpleLinkedList linkedList2 = new SimpleLinkedList();
//         SimpleLinkedList linkedList3 = new SimpleLinkedList();

//         linkedList1.addNode(1);
//         linkedList1.addNode(2);
//         linkedList1.addNode(3);

//         linkedList2.addNode(1);
//         linkedList2.addNode(2);
//         linkedList2.addNode(3);

//         linkedList3.addNode(1);
//         linkedList3.addNode(2);
//         linkedList3.addNode(3);
//         // Displaying the linked list
//         System.out.println("Linked List elements:");
//         linkedList1.displayList();
//     }
// }

