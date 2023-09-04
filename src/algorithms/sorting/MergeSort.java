package algorithms.sorting;

import java.util.Arrays;

// Worst: O(n logn)
// Best: O(n logn)
// Average: O(n logn)
// Space complexity: O(n)
// Stable: Yes
public class MergeSort {

    public static void sort(int[] arr) {
        int n = arr.length;
        int[] tempArr = new int[n];
        mergeSort(arr, tempArr, 0, n - 1);
    }

    private static void mergeSort(int[] arr, int[] tempArr, int l, int h) {
        if (l >= h) return;

        int m = (l + h) / 2;
        mergeSort(arr, tempArr, l, m);
        mergeSort(arr, tempArr, m + 1, h);
        merge(arr, tempArr, l, m, h);
    }

    private static void merge(int[] arr, int[] tempArr, int l, int m, int h) {
        int lStart = l;
        int lStop = m;
        int uStart = m + 1;
        int uStop = h;
        int count = l;

        while (lStart <= lStop && uStart <= uStop) {
            if (arr[lStart] < arr[uStart]) {
                tempArr[count++] = arr[lStart++];
            } else {
                tempArr[count++] = arr[uStart++];
            }
        }

        while (lStart <= lStop) {
            tempArr[count++] = arr[lStart++];
        }

        while (uStart <= uStop) {
            tempArr[count++] = arr[uStart++];
        }

        System.arraycopy(tempArr, l, arr, l, h + 1 - l);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 5, 1, 3, 2, 8, 100, -1, 4, 11, 24, -100};
        MergeSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
