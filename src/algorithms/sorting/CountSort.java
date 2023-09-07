package algorithms.sorting;

import java.util.Arrays;

public class CountSort {

    public static void sort(int[] arr, int l, int h) {
        int n = arr.length;
        int range = h - l;
        int[] count = new int[range];

        for (int i = 0; i < n; i++) {
            count[arr[i] - l]++;
        }

        int j = 0;
        for (int i = 0; i < range; i++) {
            for (; count[i] > 0; (count[i])--) {
                arr[j++] = i + l;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 9, 5, 6, 3, 1, 8, 2, 7, 4, 10, 10, 1, 1, 1, 1};
        CountSort.sort(arr, 0, 11);
        System.out.println(Arrays.toString(arr));
    }
}
