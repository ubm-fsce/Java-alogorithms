package uday.algorithms.binarysearch;

public class BinarySearch {
    public static void main(String[] args) {
        int array[] = {1, 2, 3, 4, 5, 9, 12, 16, 19, 25, 28, 33};
        System.out.println(binarySearch(array, 22));
    }

    public static int binarySearch(int[] a, int x) {
        int p = 0;
        int r = a.length - 1;
        while (p <= r) {
            int q = (p + r) / 2;
            if (x < a[q]) {
                r = q - 1;
            } else if (x > a[q]) {
                p = q + 1;
            } else {
                return q;
            }
        }

        return -1;
    }
}
