package dsapractise.leetcode.stack;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String[] str = { "flower", "flow", "flight", "fight" };
        System.out.println("longestCommonPrefixBS() : " + longestCommonPrefix.longestCommonPrefixBS(str));
    }

    private String longestCommonPrefix(String[] strs) {
        String longestCommnprfx = "";
        int index = 0;
        for (char c : strs[0].toCharArray()) {
            for (int i = 1; i < strs.length; i++) {
                if (index >= strs[i].length() || c != strs[i].charAt(index)) {
                    return longestCommnprfx;
                }
            }
            longestCommnprfx = longestCommnprfx + c;
            index++;
        }
        return longestCommnprfx;
    }

    private static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0)
            return "";
        String toFind = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(toFind) != 0) {
                toFind = toFind.substring(0, toFind.length() - 1);
            }
        }
        return toFind;
    }

    // Seems Most Efficient
    public String longestCommonPrefixBS(String[] strs) {
        int start = 0;
        // First we find the length of the shortest string
        int end = minString(strs) - 1;
        String substr = "";
        // then just simple binary search algorithm
        while (start <= end) {
            int mid = start + (end - start) / 2;
            boolean isPrefix = true;
            String temp = strs[0].substring(0, mid + 1);
            // iterate all strings
            for (String s : strs) {
                // if some string doens't have a prefix then isPrefix = false and break
                if (!s.substring(0, mid + 1).equals(temp)) {
                    isPrefix = false;
                    break;
                }
            }
            // if prefix is valid
            if (isPrefix) {
                // move to the right side in binary search
                start = mid + 1;
                // and save it
                substr = temp;
            } else {
                // else to the left side
                end = mid - 1;
            }
        }
        return substr;
    }

    private int minString(String[] strs) {
        int min = strs[0].length();
        for (String s : strs) {
            if (s.length() < min)
                min = s.length();
        }
        return min;
    }

}
