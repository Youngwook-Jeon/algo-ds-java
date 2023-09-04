package algorithms.sorting;

import java.util.Arrays;

// Worst: O(n^2)
// Best: O(n logn)
// Average: O(n logn)
// Space complexity: O(1) (if we don't consider the recursive stack space)
// Stable: No
public class QuickSort {

    public static void sort(int[] arr) {
        int n = arr.length;
        quickSort(arr, 0, n - 1);
    }

    private static void quickSort(int[] arr, int l, int h) {
        if (l >= h) return;

        int pivot = arr[l];
        int start = l;
        int end = h;

        while (l < h) {
            while (arr[l] <= pivot && l < h) {
                l++;
            }

            while (arr[h] > pivot && l <= h) {
                h--;
            }

            if (l < h) {
                swap(arr, l, h);
            }
        }

        swap(arr, start, h); // h is the pivot position
        quickSort(arr, start, h - 1);
        quickSort(arr, h + 1, end);
    }

    private static void swap(int[] arr, int l, int h) {
        int temp = arr[l];
        arr[l] = arr[h];
        arr[h] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 5, 1, 3, 2, 8, 100, -1, 4, 11, 24, -100};
        QuickSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
