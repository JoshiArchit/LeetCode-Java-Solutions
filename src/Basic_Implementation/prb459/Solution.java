package Basic_Implementation.prb459;
/**
  * Solution.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */
 
public class Solution {
    // Given a string s, check if it can be constructed by taking a substring
    // of it and appending multiple copies of the substring together.
//    public boolean repeatedSubstringPattern(String s) {
//        // Use naive approach to find all occurrences of a substring in a string
//        int n = s.length();
//        for (int i = 1; i <= n / 2; i++) {
//            if (n % i == 0) {
//                String sub = s.substring(0, i);
//                StringBuilder sb = new StringBuilder();
//                for (int j = 0; j < n / i; j++) {
//                    sb.append(sub);
//                }
//                if (sb.toString().equals(s)) {
//                    return true;
//                }
//            }
//        }
//
//        return false;
//    }

    // KMPSearch function to find the substring in the string
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int len = 0;
        int i = 1;

        // Calculate the LPS array
        while (i < n) {
            if( s.charAt( i ) == s.charAt( len ) ) {
                len++;
                lps[ i ] = len;
                i++;
            } else {
                if( len != 0 ) {
                    len = lps[ len - 1 ];
                } else {
                    lps[ i ] = 0;
                    i++;
                }
            }
        }
        return false;
    }

    public static void main( String[] args ) {
        Solution solution = new Solution();
        String s = "abcabcabcabc";
        System.out.println(solution.repeatedSubstringPattern(s));
    }
}
