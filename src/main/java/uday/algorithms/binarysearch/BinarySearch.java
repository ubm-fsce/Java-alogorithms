package uday.algorithms.binarysearch;

public class BinarySearch {
    public static void main(String[] args) {
        int array[] = {1, 2, 3, 4, 5, 9, 12, 16, 19, 25, 28, 33};
        System.out.println(binarySearch(array, 22));
    }

    public static int binarySearch(int[] a, int x) {
        int p = 0;
        int r = a.length - 1;
        int iteration=0;
        while (p <= r) {
             iteration++;
            int q = (p + r) / 2;
            System.out.println("Iteration : "+iteration
                    + " | P :  "+p
                    + " | R :  "+r
                    +  "| q :  "+q);
            if (x < a[q]) {
                r = q - 1;
                System.out.println(" inside  first IF | x < a["+q+"] : "
                        + " | x :  "+x
                        + " | a["+q+"] :  "+a[q]
                        + " | NEW  r  :  "+r);
            } else if (x > a[q]) {
                p = q + 1;
                System.out.println(" inside second  IF  | x > a["+q+"] : "
                        + " | x :  "+x
                        + " | a["+q+"] :  "+a[q]
                        + " | NEW  p  :  "+p);
            } else {
                return q;
            }
        }
        System.out.println(" exited while  (p <= r) Loop |p : "+p+" | R: "+r+" | about to return : -1");
        return -1;
    }
}
