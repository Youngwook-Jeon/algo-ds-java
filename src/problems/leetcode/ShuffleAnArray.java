package problems.leetcode;

// https://leetcode.com/explore/interview/card/top-interview-questions-easy/98/design/670/
import java.util.Random;

class ShuffleAnArray {

    int[] origin;
    int[] arr;

    public ShuffleAnArray(int[] nums) {
        this.origin = nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return origin.clone();
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random rand = new Random();
        arr = origin.clone();
        for (int i = 0; i < arr.length; i++) {
            int nextIntToSwap = rand.nextInt(arr.length);
            int tmp = arr[i];
            arr[i] = arr[nextIntToSwap];
            arr[nextIntToSwap] = tmp;
        }
        return arr;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */