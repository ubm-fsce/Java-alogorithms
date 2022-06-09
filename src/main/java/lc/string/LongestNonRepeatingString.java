package lc.string;

public class LongestNonRepeatingString {

    public static void main(String[] args) {
        String str = "abcdasassdasdafda";
        LongestNonRepeatingString longestNonRepeatingString = new LongestNonRepeatingString();
        longestNonRepeatingString.lengthOfLongestSubstring(str);
    }

    public int lengthOfLongestSubstring(String s) {
        int[] chars = new int[128];
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            chars[r]++;
            while (chars[r] > 1) {
                char l = s.charAt(left);
                chars[l]--;
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

}


