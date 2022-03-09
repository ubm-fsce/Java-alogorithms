package leetcode.day2.palindromenumber;

public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println("is Palindrome : " + isPalindrome(33533));
    }

    private static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        if (x == revertedNumber) return true;
        else return x == revertedNumber / 10;
    }

    private static boolean isPalindrome2(int x) {
        int num = 0, temp = x;
        while (x > 0) {
            num = num * 10 + x % 10;
            x = x / 10;
        }
       return  (temp == num) ?  true : false;
    }
}
