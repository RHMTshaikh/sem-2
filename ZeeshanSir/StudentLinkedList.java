package ZeeshanSir;

import java.util.Scanner;

public class StudentLinkedList {
    public static void main(String[] args) {
        Node head =  new Node(new ClaasInfo());
        Node student1 = new Node(head,new StudentInfo());
        Node student2 = new Node(student1,new StudentInfo());
        // System.out.println(((StudentInfo)student1.dataObj).gardes);
        head.print();
        
    }   
}

class Node{
    Object dataObj;
    Node next;
    Node(){}
    Node(Object obj){
        dataObj = obj;
    }
    Node(Node currNode, Object obj){
        currNode.next = new Node(obj);
        // currNode.next.dataObj =  obj;
    }
    void print(){
        Node currNode = this;
        System.out.println("\nClass Information");
        System.out.println("strength: "+ ((ClaasInfo)currNode.dataObj).strength);
        System.out.println("fees: "+     ((ClaasInfo)currNode.dataObj).fees);
        System.out.println("duration: "+ ((ClaasInfo)currNode.dataObj).duration);
        System.out.println("credits: "+  ((ClaasInfo)currNode.dataObj).credits);
        currNode = currNode.next;
        int count=1;
        while (currNode != null) {
            System.out.println("\nStudent_"+count++);
            System.out.println("grades: "+    ((StudentInfo)currNode.dataObj).gardes);
            System.out.println("attendence: "+((StudentInfo)currNode.dataObj).attendance);
            System.out.println("backlogs: "+  ((StudentInfo)currNode.dataObj).backLogs);
            currNode = currNode.next;
        }
    }
}
class ClaasInfo{
    int strength, fees, duration, credits;
    ClaasInfo(){
        Scanner scn = new Scanner(System.in);
        System.out.println("enter strength:");
        strength = scn.nextInt();
        System.out.println("enter fees:");
        fees = scn.nextInt();
        System.out.println("enter duration:");
        duration = scn.nextInt();
        System.out.println("enter credits:");
        credits = scn.nextInt();
    }
}
class StudentInfo{
    int gardes, attendance, backLogs;
    StudentInfo(){
        Scanner scn = new Scanner(System.in);
        System.out.println("enter grades:");
        gardes= scn.nextInt();
        System.out.println("enter attendance:");
        attendance= scn.nextInt();
        System.out.println("enter backLogs:");
        backLogs= scn.nextInt();
    }
}
