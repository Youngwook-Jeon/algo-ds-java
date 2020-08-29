package problems.leetcode;

public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int decimal = 0;
        final int MAX_BITS = 32;

        for (int i = 0; i < MAX_BITS; i++) {
            decimal = decimal << 1;
            decimal = decimal | (n & 1);
            n = n >> 1;
        }

        return decimal;
    }
}