package problems.leetcode;

// https://leetcode.com/explore/interview/card/top-interview-questions-easy/97/dynamic-programming/576/

import java.util.Arrays;

class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;

        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i + 1] = Math.max(dp[i - 1] + nums[i], dp[i]);
        }

        return dp[nums.length];
    }

    public static void main(String[] args) {
        HouseRobber houseRobber = new HouseRobber();
        int[] nums = new int[]{2, 7, 9, 3, 1};
        System.out.println("Our input is: " + Arrays.toString(nums));
        System.out.println("Answer: "+ houseRobber.rob(nums));
    }
}
