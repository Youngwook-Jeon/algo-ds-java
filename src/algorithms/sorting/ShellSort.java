package algorithms.sorting;

import java.util.Arrays;

public class ShellSort {

    public static void sort(int[] arr) {
        int n = arr.length;

        for (int gap = n/2; gap > 0; gap /= 2) {
            // Do a gapped insertion sort
            for (int i = gap; i < n; i++) {
                int cur = arr[i];
                int j;

                for (j = i; j >= gap && (arr[j - gap] > cur); j -= gap) arr[j] = arr[j - gap];

                arr[j] = cur;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 5, 1, 3, 2, 8, 100, -1, 4, 11, 24, -100};
        ShellSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
