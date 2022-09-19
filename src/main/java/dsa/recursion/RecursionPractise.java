package dsa.recursion;

public class RecursionPractise {

    public static void main(String[] args) {
        RecursionPractise r = new RecursionPractise();
        int[] array = { 1, 2, 3, 4, 5, 6 };
        String str = "MADAAM";
        // r.printNameNtimes(0,"Uday", 5);
        // r.print1toN(0,5);
        // r.printNto1(0,5);
        // System.out.println(r.sumNnumsParameterised(5, 0));
        // System.out.println(r.functionalSumNnums(6));
        // System.out.println(Arrays.toString(r.reverseArray( array, 0,
        // array.length-1)));
        // System.out.println(Arrays.toString(r.swapUsingsinglePointer( array, 0)));
        // System.out.println(r.isPalindrome(str, 0));
        System.out.println(r.fibonocciNumber(10));

    }

    public void printNameNtimes(int i, String name, int n) {
        if (i >= n)
            return;
        System.out.println(i + " : " + name);
        printNameNtimes(
                ++i, name, n);
    }

    public void print1toN(int i, int n) {
        if (i >= n)
            return;
        System.out.println(++i);
        print1toN(i, n);
    }

    public void printNto1(int i, int n) {
        if (i >= n)
            return;
        printNto1(++i, n);
        System.out.println(i);
    }

    int sumNnumsParameterised(int n, int sum) {
        if (n == 0)
            return sum;
        return sumNnumsParameterised(n - 1, sum + n);
    }

    int functionalSumNnums(int n) {
        if (n == 0)
            return 0;
        return n + functionalSumNnums(n - 1);
    }

    int[] reverseArray(int[] array, int left, int right) {
        if (left > right)
            return array;
        swapArray(array, left, right);
        return reverseArray(array, ++left, --right);
    }

    void swapArray(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    int[] swapUsingsinglePointer(int[] array, int p) {
        if (p > array.length / 2)
            return array;
        swapArray(array, p, array.length - 1 - p);
        return swapUsingsinglePointer(array, ++p);
    }

    boolean isPalindrome(String str, int index) {
        if (index > str.length() / 2)
            return true;
        if (str.charAt(index) != str.charAt(str.length() - 1 - index))
            return false;
        return isPalindrome(str, ++index);
    }

    // Multiple Recursinon Calls
    int fibonocciNumber(int n) {
        if (n <= 1)
            return n;
        int last = fibonocciNumber(n - 1);
        int sLast = fibonocciNumber(n - 1);
        return last + sLast;

    }
}
