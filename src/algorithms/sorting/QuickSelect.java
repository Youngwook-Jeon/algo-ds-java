package algorithms.sorting;

public class QuickSelect {

    public static int get(int[] arr, int k) {
        quickSelect(arr, 0, arr.length - 1, k);
        return arr[k];
    }

    private static void quickSelect(int[] arr, int l, int h, int k) {
        if (l >= h) return;

        int pivot = arr[l];
        int start = l;
        int stop = h;

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

        swap(arr, start, h);

        if (h > k) quickSelect(arr, start, h - 1, k);
        else if (h < k) quickSelect(arr, h + 1, stop, k);
    }

    private static void swap(int[] arr, int l, int h) {
        int temp = arr[l];
        arr[l] = arr[h];
        arr[h] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 9, 5, 6, 3, 1, 8, 2, 7, 4};
        int k = 3;
        System.out.println("The value at index 3 is : " + QuickSelect.get(arr, k));
    }
}
