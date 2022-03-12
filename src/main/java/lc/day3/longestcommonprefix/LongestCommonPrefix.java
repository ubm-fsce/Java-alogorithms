package lc.day3.longestcommonprefix;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String[] str = {"flower", "flow", "flight", "fight"};
        System.out.println("longestCommonPrefix2() : " + longestCommonPrefix.longestCommonPrefix2(str));
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
        if (strs.length == 0) return "";
        String toFind = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(toFind) != 0) {
                toFind = toFind.substring(0, toFind.length() - 1);
            }
        }
        return toFind;
    }

}

