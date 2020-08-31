package problems.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSum {
    List<List<Integer>> lst;

    public List<List<Integer>> threeSum(int[] nums) {
        lst = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i - 1] != nums[i])) {
                int newSum = -nums[i];
                int low = i + 1;
                int high = nums.length - 1;
                twoSum(nums, low, high, newSum);
            }
        }

        return lst;
    }

    private void twoSum(int[] nums, int low, int high, int newSum) {
        while (low < high) {
            if (nums[low] + nums[high] == newSum) {
                lst.add(Arrays.asList(-newSum, nums[low], nums[high]));
                while (low < high && nums[low] == nums[low + 1]) low++;
                while (low < high && nums[high] == nums[high - 1]) high--;
                low++;
                high--;
            } else if (nums[low] + nums[high] < newSum) {
                low++;
            } else high--;
        }
    }
}
