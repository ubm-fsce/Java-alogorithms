package dsapractise.leetcode.stack;

import java.util.HashMap;
import java.util.Map;

public class RomantoInt {

    public static void main(String[] str) {
        RomantoInt romantoInt = new RomantoInt();
        System.out.println("converRomanToIntSwitch() : " + romantoInt.converRomanToIntSwitch("DMCMXCIV"));
        System.out.println("converRomanToInt() : " + romantoInt.converRomanToInt("DMCMXCIV"));
        System.out.println("romanToInt() : " + romantoInt.romanToInt("DMCMXCIV"));

    }

    private int converRomanToInt(String str) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int sum = 0;
        int val = 0;
        int prev = 0;
        for (int i = 0; i < str.length(); i++) {
            val = map.get(str.charAt(i));
            if (val > prev)
                sum = sum - prev + val - prev;
            else
                sum = sum + val;
            prev = val;
        }
        return sum;
    }

    private int converRomanToIntSwitch(String str) {
        int sum = 0;
        int val = 0;
        int prev = 0;
        for (int i = 0; i < str.length(); i++) {
            val = getValue(str.charAt(i));
            if (val > prev)
                sum = sum - prev + val - prev;
            else
                sum = sum + val;
            prev = val;
        }
        return sum;
    }

    // Efficient one among these practised ones
    public int romanToInt(String str) {
        int result = getValue(str.charAt(str.length() - 1));
        for (int i = str.length() - 2; i >= 0; i--) {
            if (getValue(str.charAt(i)) < getValue(str.charAt(i + 1))) {
                result = result - getValue(str.charAt(i));
            } else
                result = result + getValue(str.charAt(i));
        }
        return result;
    }

    private int getValue(char romanInt) {
        int val = 0;
        switch (romanInt) {
            case 'I':
                val = 1;
                break;
            case 'V':
                val = 5;
                break;
            case 'X':
                val = 10;
                break;
            case 'L':
                val = 50;
                break;
            case 'C':
                val = 100;
                break;
            case 'D':
                val = 500;
                break;
            case 'M':
                val = 1000;
                break;
        }
        return val;
    }

}