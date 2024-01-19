package KhalidSir;
import java.util.HashSet;
import java.util.Set;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        String str = "aaaaajhasgfyrgggshsahb";
        Set<String> palindromes = findAllPalindromicSubstrings(str);

        System.out.println("Distinct palindromic substrings:");
        int i=0;
        for (String palindrome : palindromes) {
            System.out.println(++i +" "+palindrome);
        }
    }
    private static Set<String> findAllPalindromicSubstrings(String str) {
        Set<String> palindromes = new HashSet<>();
        int n = str.length();

        for (int center = 0; center < 2 * n - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;
            
            while (left >= 0 && right < n && str.charAt(left) == str.charAt(right)) {
                if (left == right) {
                    left--;
                    right++;
                    continue;
                }
                palindromes.add(str.substring(left, right + 1));
                left--;
                right++;
            }
        }
        return palindromes;
    }
}
