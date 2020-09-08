package problems.leetcode;

import java.util.HashSet;
import java.util.Set;

class HappyNumber {

    Set<Integer> set = new HashSet<>();
    public boolean isHappy(int n) {
        if (n == 1) return true;
        int squareSum = 0;
        while (n > 0) {
            int k = n % 10;
            squareSum += k * k;
            n /= 10;
        }
        if (set.contains(squareSum)) return false;
        set.add(squareSum);
        return isHappy(squareSum);
    }
}
