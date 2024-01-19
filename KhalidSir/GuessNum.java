package KhalidSir;
import java.util.Random;
import javax.swing.JOptionPane;

public class GuessNum {
    static void guessNum(){
        Random rdm = new Random();

        JOptionPane.showMessageDialog(null, "Choose a lower limit and a upper limti and then try to guess the target number between them.\nBest of Luck!", "Guess the Number Game!", JOptionPane.PLAIN_MESSAGE);

        int lowerLimit = Integer.parseInt(JOptionPane.showInputDialog("Choose the lower limit:"));
        int upperLimit = Integer.parseInt(JOptionPane.showInputDialog("Choose the upper limit:"));
        int target = rdm.nextInt(upperLimit-lowerLimit+1)+lowerLimit;
        int attempts = 0;

        int guess = Integer.parseInt(JOptionPane.showInputDialog("Guess the number between "+lowerLimit+ " and " +upperLimit));
        attempts++;

        if(guess==target){
            JOptionPane.showMessageDialog(null, "Eureka, the number was " +target+" and you guessed " +guess+"! \n In very first attempt!");
        } else{
            do{ 
                if (guess<target){
                    if (guess> lowerLimit) lowerLimit =guess+1;
                    guess = Integer.parseInt(JOptionPane.showInputDialog(""+guess+", You guessed it lesser!\n Guess a number between "+lowerLimit+ " and " +upperLimit));
                    attempts++;   
                }
                else{
                    if (guess< upperLimit) upperLimit =guess-1;
                    guess = Integer.parseInt(JOptionPane.showInputDialog(""+guess+", You guessed it higher!\n Guess a number between "+lowerLimit+ " and " +upperLimit)); 
                    attempts++;
                }       
            }while(guess!=target);
            JOptionPane.showMessageDialog(null, "Eureka, the number was " +target+" and you guessed " +guess+"! \n In " +attempts+" attemt!");
        }    
    }

    public static void main(String[] args) {
        guessNum();
    }   
}
