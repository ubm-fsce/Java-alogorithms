package algorithms.search.linearsearch;

public class LinearSearch {
    public static void main(String[] args) {
        int array[] = {1, 2, 3, 4, 5, 9, 12, 16, 19, 25, 28, 33};
        System.out.println(recursiveLinearSearch(array, 0,33));
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

    public static int recursiveLinearSearch(int[] array, int i, int x){
        if(i>array.length-1){
            System.out.println("Not found in Array: ");
            return -1;
        }else if (array[i]==x){
            System.out.println("index value : "+i);
            return i;
        }else {
            return recursiveLinearSearch(array,i+1,x);
        }
    }
}
