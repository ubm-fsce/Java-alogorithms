package dsa.stack;

import java.util.Stack;

public class MaximumNestingDepthOfTheParentheses {

    public static void main(String[] args) {
        MaximumNestingDepthOfTheParentheses vp = new MaximumNestingDepthOfTheParentheses();
        System.out.println(" Maximum Nesting Depth Of The Parentheses :: " + vp.maxDepth_1("((((()))))"));
        System.out.println(" Maximum Nesting Depth Of The Parentheses :: " + vp.maxDepth_2("((((( )))))"));
    }

    public int maxDepth_1(String s) {
        int tempDepth = 0, maxDepth1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                tempDepth++;
            } else if (s.charAt(i) == ')') {
                tempDepth--;
            }
            maxDepth1 = Math.max(tempDepth, maxDepth1);
        }
        return maxDepth1;
    }

    public int maxDepth_2(String s) {
        char[] chArray = s.toCharArray();
        Stack<Character> charStack = new Stack<>();
        int tempDepth = 0, maxDepth1 = 0;
        for (char ch : chArray) {
            if (ch == '(') {
                charStack.push(')');
                tempDepth++;
            } else if (ch == ')') {
                tempDepth--;
            }
            maxDepth1 = Math.max(tempDepth, maxDepth1);
        }
        return maxDepth1;
    }

}
