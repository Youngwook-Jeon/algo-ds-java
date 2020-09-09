package problems.leetcode;

class JumpGame {
    // Dynamic Programming: O(n*n)-time complexity, O(n)-space complexity.
    public boolean canJump1(int[] nums) {
        /** arr[i] = 0 -> not verified yet or never be reached,
         * arr[i] = 1 -> could be reached
         */
        int[] arr = new int[nums.length];
        arr[nums.length - 1] = 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            int maxJump = Math.min(nums.length, i + nums[i] + 1);
            for (int j = i + 1; j < maxJump; j++) {
                if (arr[j] == 1) {
                    arr[i] = 1;
                    break;
                }
            }
        }
        return arr[0] == 1;
    }

    // Greedy: O(n) time complexity, O(1) space complexity.
    public boolean canJump2(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }

        return lastPos == 0;
    }
}
