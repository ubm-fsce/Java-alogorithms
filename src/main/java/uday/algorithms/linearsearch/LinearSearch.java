package uday.algorithms.linearsearch;

public class LinearSearch {
    public static void main(String[] args) {

    }

    public static int linearsearch(int[] a, int x) {
        int index = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) {
                return index = 1;
            }
        }
        return index;
    }
}
