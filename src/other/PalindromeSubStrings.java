package other;

/**
 * 
 * @author sudarshanshinde
 * <p>See <a href="https://leetcode.com/problems/palindromic-substrings/">https://leetcode.com/problems/palindromic-substrings/</a>
 * <br><br>
 * <h1>Problem Statement :</h1>
 * 
 * <p>Given a string, your task is to count how many palindromic substrings in this string.
 * <br>
 * <p>The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 * <p>
 * <br>
 * Example 1:
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * <br><br>
 * Example 2:
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 *
 */

public class PalindromeSubStrings {
    public int countSubstrings(String s) {
        int subStrCount = 0;
        for(int i = 0; i < s.length(); i++ ){
            subStrCount += checkSubString(s, i, i) + checkSubString(s, i, i + 1);
        }
        return subStrCount;
    }
    
    public int checkSubString(String s, int i, int j){
        int count = 0;
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            count++;
            i--;
            j++;
        }
        return count;
    }
}
