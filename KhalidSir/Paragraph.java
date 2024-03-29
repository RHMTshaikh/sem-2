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
        String para = "were changed so that a tile could move anywhere instead of just to the adjacent empty square, then h1 would give the exact number of steps in the shortest solution. Similarly, if a tile could move one square in any direction, even onto an occupied square, then h2 would give the exact number of steps in the shortest solution. A problem with fewer restrictions on the actions is RELAXED PROBLEM called a relaxed problem. The state-space graph of the relaxed problem is a supergraph of the original state space because the removal of restrictions creates added edges in the graph. Because the relaxed problem adds edges to the state space, any optimal solution in the original problem is, by definition, also a solution in the relaxed problem; but the relaxed problem may have better solutions if the added edges provide short cuts. Hence, the cost of an optimal solution to a relaxed problem is an admissible heuristic for the original problem. Furthermore, because the derived heuristic is an exact cost for the relaxed problem, it must obey the triangle inequality and is therefore consistent (see page 95). If a problem definition is written down in a formal language, it is possible to construct relaxed problems automatically.11 For example, if the 8-puzzle actions are described as A tile can move from square A to square B if A is horizontally or vertically adjacent to B and B is blank, we can generate three relaxed problems by removing one or both of the conditions: (a) A tile can move from square A to square B if A is adjacent to B. (b) A tile can move from square A to square B if B is blank. (c) A tile can move from square A to square B. From (a), we can derive h2 (Manhattan distance). The reasoning is that h2 would be the proper score if we moved each tile in turn to its destination. The heuristic derived from (b) is discussed in Exercise 3.31. From (c), we can derive h1 (misplaced tiles) because it would be the proper score if tiles could move to their intended destination in one step. Notice that it is crucial that the relaxed problems generated by this technique can be solved essentially without search, because the relaxed rules allow the problem to be decomposed into eight independent subproblems. If the relaxed problem is hard to solve, then the values of the corresponding heuristic will be expensive to obtain.12 A program called ABSOLVER can generate heuristics automatically from problem definitions, using the “relaxed problem” method and various other techniques (Prieditis, 1993). ABSOLVER generated a new heuristic for the 8-puzzle that was better than any preexisting heuristic and found the first useful heuristic for the famous Rubik’s Cube puzzle. One problem with generating new heuristic functions is that one often fails to get a single “clearly best” heuristic. If a collection of admissible heuristics h1 ...hm is available for a problem and none of them dominates any of the others, which should we choose? As it turns out, we need not make a choice. We can have the best of all worlds, by defining";

        System.out.println("number of words: "+countWords(para));
        System.out.println("\nnumber of charactrs: "+countCharaters(para));
        System.out.println("\nNumber of lines in the paragraph: "+noOfLines(para));
        System.out.println("\nSentence case of paragraph: "+toSentenceCase(para));
        System.out.println("\nReverse words: "+reverseWords(para));
        System.out.println("\nReverse letters: "+reverseLetters(para));
    }
}