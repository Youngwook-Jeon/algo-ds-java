package algorithms.sorting;

import java.util.Arrays;

// We consider the number of digits is 64 for an integer and the base is 10, then
// Best: O(n)
// Worst: O(n)
// Average: O(n)
// Space complexity: O(n)
public class RadixSort {

    public static void countSort(int[] arr, int n, int dividend) {
        int[] temp = arr.clone();
        int[] count = new int[10];
        Arrays.fill(count, 0);

        for (int i = 0; i < n; i++) {
            count[(temp[i] / dividend) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            arr[count[(temp[i] / dividend) % 10] - 1] = temp[i];
            count[(temp[i] / dividend) % 10]--;
        }
    }

    public static void sort(int[] arr) {
        int n = arr.length;
        int m = getMax(arr, n);

        for (int div = 1; m / div > 0; div *= 10) {
            countSort(arr, n, div);
        }
    }

    private static int getMax(int[] arr, int n) {
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (max < arr[i]) max = arr[i];
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 9, 5, 6, 3, 1, 8, 2, 7, 4, 10, 10, 1, 1, 1, 1};
        RadixSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
