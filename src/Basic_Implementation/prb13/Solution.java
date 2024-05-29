package Basic_Implementation.prb13;

import java.util.HashMap;
import java.util.Map;

/**
  * Solution.java
  * Author : Archit Joshi
  * Version :
  * Revisions :
  */
 
public class Solution {
    static Map<String, Integer> values = new HashMap<>();

    static {
        values.put("M", 1000);
        values.put("D", 500);
        values.put("C", 100);
        values.put("L", 50);
        values.put("X", 10);
        values.put("V", 5);
        values.put("I", 1);
    }
    public int romanToInt(String s){
        int total = 0;
        int i = 0;

        while(i<s.length()){
            // If two characters are remaining
            if(i+1<s.length()){
                String doubleChar = s.substring(i, i+2);
                if(values.containsKey(doubleChar)){
                    total += values.get(doubleChar);
                    i += 2;
                    continue;
                }
            }
            String singleChar = s.substring(i, i+1);
            total += values.get(singleChar);
            i++;

        }
        return total;

    }
    public static void main(String[] args){
        Solution solution = new Solution();
        String s = "MMCMLXXXIX";
        System.out.println(solution.romanToInt(s));
    }
}
