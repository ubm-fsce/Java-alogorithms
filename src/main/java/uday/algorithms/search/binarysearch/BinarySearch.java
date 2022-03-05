package uday.algorithms.search.binarysearch;

public class BinarySearch {
    public static void main(String[] args) {
        int array[] = {1, 2, 3, 4, 5, 9, 12, 16, 19, 25, 28, 33};
        System.out.println(binarySearch(array, 25));
        System.out.println(recursiveBinarySearch(array, 0,array.length,25));
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


    public static int recursiveBinarySearch(int[] array, int p,int r, int x) {
        int q;
        System.out.println("["+p+"....."+r+"]");
        if (p > r)
             return -1;
             else {
            q = (p + r) / 2;
            if (array[q] == x)
                return q;
            else if (array[q] > x)
               return  recursiveBinarySearch(array, p, q - 1, x);
            else
                return  recursiveBinarySearch(array, q + 1, r, x);
        }
    }
}
