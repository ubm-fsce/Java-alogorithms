package dsapractise.educative.slidingwindow;

import java.util.*;

public class StringAnagrams {

    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        HashMap<Character, Integer> chMap = new HashMap<>();
        for (Character ch : pattern.toCharArray()) {
            chMap.put(ch, chMap.getOrDefault(ch, 0) + 1);
        }
        int start = 0;
        int len = str.length();
        int ptrLen = pattern.length();
        int matched = 0;
        // Write your code here
        for (int i = 0; i < len; i++) {
            Character ch = str.charAt(i);
            if (chMap.containsKey(ch)) {
                chMap.put(ch, chMap.getOrDefault(ch, 0) - 1);
                if (chMap.getOrDefault(ch, 0) == 0)
                    matched++;
            }
            if (matched == ptrLen) {
                resultIndices.add(start);
            }
            if (i >= ptrLen - 1) {
                char ch2 = str.charAt(start++);
                if (chMap.get(ch2) == 0)
                    matched--;
                chMap.put(ch2, chMap.getOrDefault(ch2, 0) + 1);
            }

        }
        return resultIndices;
    }

    public static void main(String[] args) {
        System.out.println(StringAnagrams.findStringAnagrams("ppqp", "pq"));
        System.out.println(StringAnagrams.findStringAnagrams("abbcabc", "abc"));
    }
}