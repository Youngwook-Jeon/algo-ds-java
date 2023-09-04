package algorithms.sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int temp = arr[i];
            while (j > 0 && arr[j - 1] > temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 5, 1, 3, 2, 8, 100, -1, 4, 11, 24, -100};
        InsertionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
