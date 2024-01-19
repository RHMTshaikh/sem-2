package KhalidSir;

import java.util.ArrayList;
import java.util.Random;
public class Password {
    public static void main(String[] args) {
        int passwordLength = (new Random()).nextInt(5)+8; //length 8 to 12
        char[] password = passwordGenerator(passwordLength);
        System.out.println("this is your password "+password+" of length "+passwordLength+".");
    }

    private static char[] passwordGenerator(int length){
        char[] password = new char[length];
        ArrayList<Integer> indexesArray = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                indexesArray.add(i);
            }
        Random rdm = new Random();
        
        int randomIndex = rdm.nextInt(indexesArray.size());
        password[indexesArray.get(randomIndex)] = pickSpecialCharacter();
        indexesArray.remove(randomIndex);

        randomIndex = rdm.nextInt(indexesArray.size());
        password[indexesArray.get(randomIndex)] = pickNumber();
        indexesArray.remove(randomIndex);

        randomIndex = rdm.nextInt(indexesArray.size());
        password[indexesArray.get(randomIndex)] = pickUpperCaseLetter();
        indexesArray.remove(randomIndex);

        randomIndex = rdm.nextInt(indexesArray.size());
        password[indexesArray.get(randomIndex)] = pickLowerCaseLetter();
        indexesArray.remove(randomIndex);
        
        do {
            int randomTypeOfCharacter = rdm.nextInt(4);//1-special, 2-Number, 3-upper, 4-Lower
            switch (randomTypeOfCharacter) {
                case 1:
                randomIndex = rdm.nextInt(indexesArray.size());
                password[indexesArray.get(randomIndex)] = pickSpecialCharacter();
                indexesArray.remove(randomIndex);
                break;
                case 2:
                randomIndex = rdm.nextInt(indexesArray.size());
                password[indexesArray.get(randomIndex)] = pickSpecialCharacter();
                indexesArray.remove(randomIndex);
                break;
                case 3:
                randomIndex = rdm.nextInt(indexesArray.size());
                password[indexesArray.get(randomIndex)] = pickSpecialCharacter();
                indexesArray.remove(randomIndex);
                break;
                default:
                randomIndex = rdm.nextInt(indexesArray.size());
                password[indexesArray.get(randomIndex)] = pickSpecialCharacter();
                indexesArray.remove(randomIndex);
                break;
            }
        } while (indexesArray.size()>0);
        return password;
    }

    public static int passwordLength(){
        return (new Random()).nextInt(5)+8;
    }

    public static char pickSpecialCharacter(){
        char[] specialCharacters = {'"','!','@','#','$','%','^','&','*','(',')','-','_','=','+','~','[','{',']','}',';',':','\\','|','.','<','>','?','/'};
        return specialCharacters[(new Random()).nextInt(specialCharacters.length)];
    }
    public static char pickNumber(){
        char[] number = {'1','2','3','4','5','5','6','7','8','9','0'};
        return number[(new Random()).nextInt(number.length)];
    }
    public static char pickUpperCaseLetter(){
        char[] upperCaseLetter = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        return upperCaseLetter[(new Random()).nextInt(upperCaseLetter.length)];
    }
    public static char pickLowerCaseLetter(){
        char[] lowerCaseLetters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        return lowerCaseLetters[(new Random()).nextInt(lowerCaseLetters.length)];
    }
}
