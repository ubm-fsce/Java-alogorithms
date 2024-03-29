package dsa.sort;

public class CyclicSort {

    public static int sort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int j = nums[i];
            if (nums[i] < nums.length && nums[i] != nums[j])
                swap(nums, i, j);
            else
                i++;
        }
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] != k)
                return k;
        }
        return -1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 8, 3, 5, 2, 4, 6, 0, 1 };
        System.out.println("Missing :  " + CyclicSort.sort(arr));
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        /*
         * arr = new int[] { 2, 6, 4, 3, 1, 5 };
         * CyclicSort.sort(arr);
         * for (int num : arr)
         * System.out.print(num + " ");
         * System.out.println();
         * 
         * arr = new int[] { 1, 5, 6, 4, 3, 2 };
         * CyclicSort.sort(arr);
         * for (int num : arr)
         * System.out.print(num + " ");
         * System.out.println();
         */
    }
}
