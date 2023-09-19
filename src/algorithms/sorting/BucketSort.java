package algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BucketSort {

    public static void sort(int[] arr, int maxVal) {
        int numBucket = 5;
        sort(arr, maxVal, numBucket);
    }

    private static void sort(int[] arr, int maxVal, int numBucket) {
        int n = arr.length;
        if (n == 0) return;

        ArrayList<ArrayList<Integer>> bucket = new ArrayList<>(numBucket);

        for (int i = 0; i < numBucket; i++) bucket.add(new ArrayList<>());

        int div = (int) Math.ceil((double) maxVal / numBucket);

        for (int j : arr) {
            int bucketInd = j / div;
            if (bucketInd >= numBucket) bucketInd = numBucket - 1;

            bucket.get(bucketInd).add(j);
        }

        for (int i = 0; i < numBucket; i++) {
            Collections.sort(bucket.get(i));
        }

        int ind = 0, count = 0;
        for (int i = 0; i < numBucket; i++) {
            var temp = bucket.get(i);
            count = temp.size();
            for (int j = 0; j < count; j++) {
                arr[ind++] = temp.get(j);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 34, 7, 99, 5, 23, 45, 88, 77, 19, 91, 100};
        BucketSort.sort(arr, 100);
        System.out.println(Arrays.toString(arr));
    }
}
