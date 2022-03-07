package algorithms.search.recursion;

public class Recursion {

    public static void main(String[] args) {
        int array[] = {1, 2, 3, 4, 5, 9, 12, 16, 19, 25, 28, 33};
       recursiveLinearSearch(array, 0,33);
        recursiveBinarySearch(array, 0,array.length,33);

        //reduceByOne(5);
    }

   static void reduceByOne(int n){
       System.out.println(" Before | N : "+n);
        if(n>0)
        reduceByOne(n-1);
        System.out.println(" N : "+n);
    }

    public static void recursiveLinearSearch(int[] array, int i, int x){
         if(i>array.length-1){
             System.out.println("Not found in Array: ");
         }else if (array[i]==x){
             System.out.println("index value : "+i);
         }else {
             recursiveLinearSearch(array,i+1,x);
         }
    }


    public static void recursiveBinarySearch(int[] array, int p,int r, int x) {
        int q;
        if (p > r)
            System.out.println("No Match Found");
        else {
            q = (p + r) / 2;
            if (array[q] == x)
                System.out.println("Index is : " + q);
            else if (array[q] > x)
                recursiveBinarySearch(array, p, q - 1, x);
            else
                recursiveBinarySearch(array, q + 1, r, x);
        }
   }


}
