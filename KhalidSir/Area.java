package KhalidSir;
// import java.lang.Math;
import javax.swing.JOptionPane;

public class Area {
    double findArea(double a){
        return Math.PI*a*a;
    }
    double findArea(double a, double b){
        return b*a;
    }
    double findArea(double a, double b, double c){
        double s = (a+b+c)/2;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }
}
class Test{
    public static void main(String[] args) {
        Area area = new Area();
        JOptionPane.showMessageDialog(null, "Area of circle"+ area.findArea(7), null, 0);
        JOptionPane.showMessageDialog(null, "Area of circle"+ area.findArea(7.0,5,2), null, 0);
        JOptionPane.showMessageDialog(null, "Area of circle"+ area.findArea(7.0,5,2), null, 0);
    }
}