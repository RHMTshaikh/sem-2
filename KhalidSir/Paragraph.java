package KhalidSir;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;
class Paragraph{
    static int countWords(String para){
        ArrayList<String> words = new ArrayList<>() ;
        para = para.trim();
        for(String w : para.split("\\s+")){
            words.add(w);
        }
        return words.size();
    }
    static int countCharaters(String para){
        return para.replaceAll("[ .\n]", "").length();//orignal para is unchanged
    }
    static int noOfLines(String para) {
        para = para.trim();
        String[] lines = para.split("\n");
        int lineCount = lines.length;
        return lineCount;
    }
    static String toSentenceCase(String para) {
        para = para.trim();
        ArrayList<String> sentence = new ArrayList<>(Arrays.asList(para.split("\\.\\s|\\.\\n")));

        for(int i = 0; i<sentence.size(); i++){
            if (!(sentence.get(i) == null || sentence.get(i).isEmpty())) {
                char[] chars = sentence.get(i).toCharArray();
                chars[0] = Character.toUpperCase(chars[0]);
                sentence.set(i, new String(chars));
            }
        }return String.join(". ", sentence);
    }
    static String reverseWords(String para){
        para = para.trim();
        ArrayList<String> words = new ArrayList<>(Arrays.asList(para.split("\\s+"))) ;
        ArrayList<String> revWords = new ArrayList<>() ;

        for(int j=words.size()-1; j>=0; j--){
            revWords.add(words.get(j));
        }return String.join(" ", revWords);
    }
    static String reverseLetters(String para){
        char[] letters = para.toCharArray();
        char[] revletters = new char[letters.length];
        for (int i = 0, j=letters.length-1; i < letters.length; i++,j--) {
            revletters[i] = letters[j];
        }return new String(revletters);
    }
    public static void main(String[] args) {
        String para = "in Java, we need to declare the size of an array before we can use it. once the size of an array is declared, it's hard to change it.\nto handle this issue, we can use the ArrayList class. \nIt allows us to create resizable arrays. unlike arrays, arraylists can automatically adjust their capacity when we add or remove elements from them. Hence, arraylists are also known as dynamic arrays.";

        System.out.println("number of words: "+countWords(para));
        System.out.println("\nnumber of charactrs: "+countCharaters(para));
        System.out.println("\nNumber of lines in the paragraph: "+noOfLines(para));
        System.out.println("\nSentence case of paragraph: "+toSentenceCase(para));
        System.out.println("\nReverse words: "+reverseWords(para));
        System.out.println("\nReverse letters: "+reverseLetters(para));
    }
}