package problems.leetcode;

// https://leetcode.com/explore/interview/card/top-interview-questions-easy/99/others/722/
class MissingNumber {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        long sum = n * (n + 1) / 2; // sum may have long type.

        for (int i = 0; i < n; i++) {
            sum -= nums[i];
        }
        return (int) sum;
    }
}
