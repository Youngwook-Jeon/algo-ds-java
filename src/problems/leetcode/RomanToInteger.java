package problems.leetcode;

// https://leetcode.com/explore/interview/card/top-interview-questions-easy/102/math/878/
class RomanToInteger {

    public int romanToInt(String s) {
        int ret = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            char cur = s.charAt(i);
            char next = s.charAt(i + 1);
            int val;
            if (cur == 'I') {
                val = 1;
                if (next == 'V' || next == 'X') val = -1;
            } else if (cur == 'V')
                val = 5;
            else if (cur == 'X') {
                val = 10;
                if (next == 'L' || next == 'C') val = -10;
            } else if (cur == 'L')
                val = 50;
            else if (cur == 'C') {
                val = 100;
                if (next == 'D' || next == 'M') val = -100;
            } else if (cur == 'D') {
                val = 500;
            } else {
                val = 1000;
            }

            ret += val;
        }
        ret += transformer(s.charAt(s.length() - 1));

        return ret;
    }

    private int transformer(char c) {
        int val;

        if (c == 'I') {
            val = 1;
        } else if (c == 'V')
            val = 5;
        else if (c == 'X') {
            val = 10;
        } else if (c == 'L')
            val = 50;
        else if (c == 'C') {
            val = 100;
        } else if (c == 'D') {
            val = 500;
        } else {
            val = 1000;
        }

        return val;
    }
}
