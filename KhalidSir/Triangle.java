package KhalidSir;
import javax.swing.JOptionPane;

public class Triangle {

    boolean isTriangle(double a, double b, double c){
        if(a+b>c & a+c>b & c+b>a) return true;
        else return false;
    }
//_________________________________________________________________________________
    boolean isEquilateral(double a, double b, double c){
        if(a==b & b==c) return true;
        else return false;
    }
//____________________________________________________________________________________ 
  boolean isIsosceles(double a, double b, double c){
        if(a==b || b==c || a==c) return true;
        else return false;
    }
//_______________________________________________________________________________________
    boolean isRightTriangle(double a, double b, double c){
        if(a*a == b*b + c*c || a*a + b*b == c*c || b*b == a*a + c*c) return true;
        else return false;
    }
//___________________________________________________________________________________________________
    boolean isScalane(double a, double b, double c){
        if(isEquilateral(a, b, c) & isIsosceles(a, b, c)) return false;
        else return true;
    }
//____________________________________________________________________________________________________
    double perimeter(double a, double b, double c){
        return a+b+c;
    }
//_________________________________________________________________________________________________________
    double area(double a, double b, double c){
        double s = (a+b+c)/2;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }

    public static void main(String[] args) {

        Triangle T = new Triangle();
        double a = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter length of first side:", null, JOptionPane.QUESTION_MESSAGE));
        double b = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter length of second side:", null, JOptionPane.QUESTION_MESSAGE));
        double c = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter length of third side:", null, JOptionPane.QUESTION_MESSAGE));

        JOptionPane.showMessageDialog(null, "Is Triangle: "+T.isTriangle(a,b,c), "Is Triangle?", JOptionPane.PLAIN_MESSAGE);

        if(T.isTriangle(a,b,c)){
            JOptionPane.showMessageDialog(null, "Perimeter is: "+T.perimeter(a,b,c), "Perimeter", JOptionPane.PLAIN_MESSAGE);
            JOptionPane.showMessageDialog(null, "Area is: "+T.area(a,b,c), "Area", JOptionPane.PLAIN_MESSAGE);
            JOptionPane.showMessageDialog(null, "Is equilateral: "+T.isEquilateral(a,b,c), "Is Equilateral?", JOptionPane.PLAIN_MESSAGE);
            JOptionPane.showMessageDialog(null, "Is RightTringle: "+T.isRightTriangle(a,b,c), "Is Right Tringle?", JOptionPane.PLAIN_MESSAGE);
            JOptionPane.showMessageDialog(null, "Is Isosceles: "+T.isIsosceles(a,b,c), "Is Isosceles?", JOptionPane.PLAIN_MESSAGE);
            JOptionPane.showMessageDialog(null, "Is Scalane: "+T.isScalane(a,b,c), "Is Scalane?", JOptionPane.PLAIN_MESSAGE);
        }
        else JOptionPane.showMessageDialog(null, "Invalid Dimensions! Triangle is not formed.", "Is Triangle?", JOptionPane.INFORMATION_MESSAGE);
    }
}
