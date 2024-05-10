package ZeeshanSir;

import java.util.Scanner;

public class MyLinkedList {
    static class Node {
        int value;
        Node next;        
    }

    private Node head;//value,next

    void create(int n){
        head = new Node();
        Node curr = head;
        Scanner scn = new Scanner(System.in);
        curr.value = scn.nextInt();
        for (int i = 1; i < n; i++) {
            curr.next = new Node();
            curr = curr.next;
            curr.value = scn.nextInt();
        }
    }
    void display() throws Exception{
        if(head == null) throw new Exception("LinkedList is Empty!");
        
        Node curr = head;
        System.out.println("LinkedList is:");
        while (curr != null ) {
            System.out.println(curr.value);
            curr = curr.next;
        }
    }
    boolean isEmpty(){
        if (head == null ) return true;
        return false;
    }
    int size(){
        int size=0;
        Node curr = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        return size;
    }
    void insert(int value, int index) throws Exception{
        if(index < 0 || index > this.size()) throw new Exception("Invalid index!");

        Node newNOde = new Node();
        newNOde.value = value;
        if (index == 0) {
            newNOde.next = head;
            head = newNOde;
            
        }else{
            Node curr = head;
            for (int i = 1; i < index; i++) {
                curr = curr.next;
            }
            newNOde.next = curr.next;
            curr.next = newNOde;
        }
    }
    int delete(int index) throws Exception{
        if(head == null) throw new Exception("LinkedList is Empty");
        if(index < 0 || index > this.size()) throw new Exception("Invalid index");
        
        Node curr = head;
        if (index == 0) {
            head = curr.next;
            return curr.value;
        }
        else{
            for (int i = 0; i < index-1; i++) {
                curr = curr.next;
            }
            int x = curr.next.value;
            curr.next = curr.next.next;
            return x;
        }
    }
    int indexOf(int val) throws Exception{
        int index=0;
        Node curr = head;
        while (curr != null) {
            if (curr.value == val) {
                return index;
            }
            curr = curr.next;
            index++;
        }
        return -1;
    }
    int get(int index) throws Exception{
        if(head == null) throw new Exception("linkedList is Empty");
        if(index < 0 || index > this.size()) throw new Exception("Invalid index");
        
        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.value;
    }
    void bucketSort(int[] arr) throws Exception{
        int max =0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        MyLinkedList[] L = new MyLinkedList[max+1];

        for (int i = 0; i < arr.length; i++) {
            if(L[arr[i]] == null) L[arr[i]] = new MyLinkedList();
            L[arr[i]].insert(arr[i], 0);
        }

        int index=0;
        for (int i = 0; i < L.length; i++) {
            if (L[i] != null) {
                while (L[i].head != null) {
                    arr[index++] = L[i].delete(0);
                }
            }
        }
    }
    void redixSort(int[] arr) throws Exception{
        int max =0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int d = (int) Math.log10(max)+1;

        MyLinkedList[] L = new MyLinkedList[10];
        for (int i = 0; i < 10; i++) {
            L[i] = new MyLinkedList();
        }
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < arr.length; j++) {
                L[(int)(arr[j]/Math.pow(10, i))%10].insert(arr[j], 0);;
            }
            
            int index=0;
            for (int j = 0; j < 10; j++) {
                if (L[j] != null) {
                    while (L[j].head != null) {
                        arr[index++] = L[j].delete(L[j].size()-1);
                    }
                }
            }
        }

    }
    void makeCircular() throws Exception{
        if(head == null) throw new Exception("LinkedList is Empty!");

        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = head;
    }
    public static void main(String[] args) {
        MyLinkedList l = new MyLinkedList();
        int[] arr = {0,0,1,9,8,7,7,6,5,3,2,1};

        int[] arr1 = new int[20];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = (int)(Math.random()*100);
            System.out.print(arr1[i]+" ");
        }System.out.println();

        try {
            l.create(5);
            l.insert(99, 3);
            l.delete(5);
            l.display();
            l.display();
            l.bucketSort(arr);
            for (int i : arr) {
                System.out.print(i+" ");
            }System.out.println();
            l.redixSort(arr1);
            for (int i : arr1) {
                System.out.print(i+" ");
            }System.out.println();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
