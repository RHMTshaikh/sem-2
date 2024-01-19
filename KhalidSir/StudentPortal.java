package KhalidSir;

import java.util.ArrayList;
import javax.swing.JOptionPane;

class Portal {
    private int studentID ;
    private String name ;
    private String course ; 
    private float SGPA ; 
    private String emailID ;

    private static ArrayList<Portal> studentList = new ArrayList<>();


    static void menu(){
        int i = Integer.parseInt(JOptionPane.showInputDialog(null, "_________MENU________\n1<--New Registration\n2<--Deregister\n3<--Update\n4<--View Details\n5<--View List\n6<--Exit\nEnter the corresponding serial number: ", "MENU", 3));
        switch(i){
        case 1:
            registration();
            menu(); 
        break;
        case 2:
            deregister();
            menu(); 
        break;
        case 3:
            update();
            menu(); 
        break;
        case 4:
            viewDetails();
            menu(); 
        break;
        case 5:
            getStudentList();
            menu(); 
        break;
        case 6:
            JOptionPane.showMessageDialog(null,"EXITED", "MENU", 1);
        break;
        default:
            JOptionPane.showMessageDialog(null,"Invalid Input!", "MENU", 0);
            menu(); 
        }
    }
    static void registration(){ //case:1
        Portal p = new Portal();
        p.studentID = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Student ID: ", "Enter the details for a single student", 3));

        p.name= JOptionPane.showInputDialog(null, "Enter Name: ", "Enter the details for a single student", 3);

        p.course = JOptionPane.showInputDialog(null, "Enter course: ", "Enter the details for a single student", 3);

        p.SGPA = Float.parseFloat(JOptionPane.showInputDialog(null, "Enter SGPA: ", "Enter the details for a single student", 3));

        p.emailID = JOptionPane.showInputDialog(null, "Enter email-ID: ", "Enter the details for a single student", 3);

        studentList.add(p);
        JOptionPane.showMessageDialog(null, "Student added.\n"+p, "Registration", 1);
    }

    static void deregister(){ // case:2
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Student ID to remove: ", "Remove Student", 1));
        boolean found = false;
        for (Portal student : studentList) {
            if (student.studentID == id){
                studentList.remove(student);
                found = true;
                break;
            }
        }
        if(found){
            JOptionPane.showMessageDialog(null, "Student Removed.", "Delete Pane", 1);
        }
        else{
            JOptionPane.showMessageDialog(null, "Student Not Found.", "Delete Pane", 0);
        }
    }
    static void update(){ //case:3
        int id= Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Student ID: ", "Updation of student attribute.", 1));

        String field= JOptionPane.showInputDialog(null, "Enter attribute to change: \n-->studentID\n-->name\n-->course\n-->SGPA\n-->emailID", "Updation", 3);

        boolean found = false;
        switch (field){
        case "studentID":
            for (Portal student : studentList) {
                if(student.studentID == id){
                    found = true;
                    student.studentID = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter New Student ID", "Updation", 3));
                    JOptionPane.showMessageDialog(null, "Succesfully Updated.\n"+student, "Updation", 1);
                    break;
                }   
            }
            if(!found){
                JOptionPane.showMessageDialog(null, "Student-ID not found!", "Updation", 0);
            }
        break;
        case "name":
            for (Portal student : studentList) {
                if(student.studentID == id){
                    found = true;
                    student.name = JOptionPane.showInputDialog(null,"Enter New Name", "Updation", 3);
                    JOptionPane.showMessageDialog(null, "Succesfully Updated.\n"+student, "Updation", 1);
                    break;
                }
            }
            if(!found){
                JOptionPane.showMessageDialog(null, "Student-ID not found!", "Updation", 0);
            }
        break;
        case "course":
            for (Portal student : studentList) {
                if(student.studentID == id){
                    found = true;
                    student.course = JOptionPane.showInputDialog(null,"Enter New Course", "Updation", 3);
                    JOptionPane.showMessageDialog(null, "Succesfully Updated.\n"+student, "Updation", 1);
                    break;
                }   
            }
            if(!found){
                JOptionPane.showMessageDialog(null, "Student-ID not found!", "Updation", 0);
            }
        break;
        case "SGPA":
            for (Portal student : studentList) {
                if(student.studentID == id){
                    found = true;
                    student.SGPA = Float.parseFloat(JOptionPane.showInputDialog(null,"Enter New SGPA", "Updation", 3));
                    JOptionPane.showMessageDialog(null, "Succesfully Updated.\n"+student, "Updation", 1);
                    break;
                }   
            }
            if(!found){
                JOptionPane.showMessageDialog(null, "Student-ID not found!", "Updation", 0);
            }
        break;
        case "emailID":
            for (Portal student : studentList) {
                if(student.studentID == id){
                    found = true;
                    student.emailID = JOptionPane.showInputDialog(null,"Enter New Email-ID", "Updation", 3);
                    JOptionPane.showMessageDialog(null, "Succesfully Updated.\n"+student, "Updation", 1);
                    break;
                }   
            }
            if(!found){
                JOptionPane.showMessageDialog(null, "Student-ID not found!", "Updation", 0);
            }
        break;
        default:
            JOptionPane.showMessageDialog(null, "Invalid feild!", "Updation", 0);
        break;
        }
        
    }
    static void viewDetails(){ //case:4
        boolean found = false;
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Student-ID to view details: ", "VIEW", 3));
        for (Portal student : studentList) {
            if(student.studentID == id){
                found = true;
                JOptionPane.showMessageDialog(null, "Student attributes:\n"+student, "VIEW", 1);
                break;
            }
        }
        if(!found){
            JOptionPane.showMessageDialog(null, "Student-ID not found!", "VIEW", 0);
        }
    }
    static void  getStudentList(){ // Csae:5
        StringBuilder message = new StringBuilder("Student List:\n");
        for (Portal student : studentList) {
            message.append(student).append("\n");
        }
        JOptionPane.showMessageDialog(null, message.toString(), "Student List", 1);
    }
    @Override
    public String toString() {
        return "StudentList [StudentID=" + studentID + ", Name=" + name + ", Course=" + course +", SGPA=" + SGPA + ", EmailId=" + emailID +"]";
    }      
}
public class StudentPortal{
    public static void main(String[] args) {
        Portal.menu();
    }   
}
