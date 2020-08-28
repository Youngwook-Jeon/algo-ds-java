package problems.leetcode;

// https://leetcode.com/explore/interview/card/top-interview-questions-easy/99/others/762/
class HammingDistance {

    public int hammingDistance1(int x, int y) {
        int xor = x ^ y;
        int cnt = 0;
        String s = Integer.toString(xor, 2);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') cnt++;
        }

        return cnt;
    }

    // This method use a simple bit manipulation trick.
    public int hammingDistance2(int x, int y) {
        int xor = x ^ y;
        return countOnes(xor);
    }

    private int countOnes(int num) {
        int count = 0;
        while (num != 0) {
            num = num & (num - 1);
            count++;
        }
        return count;
    }
}
