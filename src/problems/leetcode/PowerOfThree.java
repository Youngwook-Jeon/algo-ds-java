package problems.leetcode;

// Note: Solve the problem without using loop/recursion.
public class PowerOfThree {
    // Sol1: Use the maximum of power of three within the range of int.
    // The value is 1162261467.
    public boolean solver1(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

    // Sol2: Change of its base.
    public boolean solver2(int n) {
        return Integer.toString(n, 3).matches("^10*$");
    }
    // Both sols have O(log3(n)) time complexity.
}
