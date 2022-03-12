package lc.day2.palindromenumber;

public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println("is Palindrome : " + isPalindrome2(335633));
    }

    private static boolean isPalindrome2(int x) {
        int num = 0, temp = x;
        while (x > 0) {
            num = num * 10 + x % 10;
            x = x / 10;
        }
        return temp == num;
    }

    /* This is more optimum solution as we are  traversing only 50% of the above*/
    private static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }

}
