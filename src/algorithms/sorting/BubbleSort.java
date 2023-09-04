package algorithms.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    flag = false;
                }
            }

            if (flag) return;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 5, 1, 3, 2, 8, 100, -1, 4, 11, 24, -100};
        BubbleSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
