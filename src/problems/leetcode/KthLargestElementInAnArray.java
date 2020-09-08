package problems.leetcode;

import java.util.Random;

class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        k = n - k;
        int low = 0;
        int high = n - 1, j;

        shuffle(nums);
        while (low < high) {
            j = helper(nums, low, high);
            if (j < k) {
                low = j + 1;
            } else if (j > k) {
                high = j - 1;
            } else {
                break;
            }
        }

        return nums[k];
    }

    private int helper(int[] nums, int low, int high) {
        int i = low, j = high + 1;
        while (true) {
            while (i < high && nums[++i] < nums[low]);
            while (j > low && nums[--j] > nums[low]);
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, low, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void shuffle(int[] nums) {
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            int j = random.nextInt(nums.length);
            swap(nums, i, j);
        }
    }
}
