package prb2062;
/**
  * Solution.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */

import java.util.HashSet;

/**
 * Input: word = "aeiouu"
 * Output: 2
 * Explanation: The vowel substrings of word are as follows (underlined):
 * - "aeiouu"
 * - "aeiouu"
 */

class Solution {
    public int countVowelSubstrings(String word) {
        int numSubStrings = 0;
        String vowels = "aeiou";

        for(int i=0; i<word.length(); i++){
            // New set for this letter as start
            HashSet<Character> set = new HashSet< Character >();
            // Sliding window
            for(int j=i; j<word.length(); j++){
                //Extract character
                char c = word.charAt( j );
                // Check if vowel
                if( vowels.indexOf( c ) > -1) {
                    set.add( c );

                    if(set.size()==5) {
                        numSubStrings += 1;
                    }
                }
                // exit if not and start over
                else {
                    break;
                }
            }
        }
        return numSubStrings;
    }


    public static void main( String[] args ) {
        String string = "aeiouu";
        string = "cuaieuouac";
        Solution sol = new Solution();
        int count = sol.countVowelSubstrings( string );
        System.out.println(count);
    }
}