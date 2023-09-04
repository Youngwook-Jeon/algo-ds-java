package algorithms.sorting;

import java.util.Arrays;

public class SelectionSort {

    private static void sort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int max = 0;
            for (int j = 0; j < n - i; j++) {
                if (arr[j] > arr[max]) {
                    max = j;
                }
            }
            int temp = arr[n - i - 1];
            arr[n - i - 1] = arr[max];
            arr[max] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 5, 1, 3, 2, 8, 100, -1, 4, 11, 24, -100};
        SelectionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
