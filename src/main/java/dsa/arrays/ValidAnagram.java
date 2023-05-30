package dsa.arrays;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
    StringBuilder sb  =new StringBuilder(s);
    sb.reverse();
        if(s.length()!=t.length()){
            return false;
        }
        int length = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<length;i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1 );
            }else {
                map.put(s.charAt(i), 1);
            }
        }
        for(int i=0;i<length; i++){
            Character ch = t.charAt(i);
            if(!map.containsKey(ch ) ){
                return false;
            } else {
                map.put(ch, map.get(ch)-1);
                if(map.get(ch)==0){
                    map.remove(ch);
                }
            }
        }
        return map.size()==0;
    }

    public static void main(String[] args) {
       // System.out.println(isAnagram("anagram", "nagaram"));
       // System.out.println(isPalindrome(  "A man, a plan, a canal: Panama"));
        System.out.println(isValid(  "()"));


    }

    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                if(st.empty() || st.pop()!=map.get(ch) ){
                    return false;
                }
            }else {
                st.push(ch);
            }
        }
        return st.empty();

    }
    public static  boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        char[] car = s.toCharArray();
        int len = car.length;
        for(int i=0; i<len;i++){
            if(Character.isLetterOrDigit(car[i])){
                sb.append(car[i]);
            }
        }
        String fstr = sb.toString().toLowerCase();
        int last = fstr.length()-1;
        int first=0;
        while(first<last){
            if(fstr.charAt(first)!=fstr.charAt(last)){
                return false;
            }
            first++; last--;
        }
        return true;

    }


}


