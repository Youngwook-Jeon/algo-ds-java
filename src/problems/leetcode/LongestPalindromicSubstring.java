package problems.leetcode;

// #id: 5
class LongestPalindromicSubstring {

    // O(n^2)-time complexity, O(1)-space complexity
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int oddLen = expandAroundCenter(s, i, i);
            int evenLen = expandAroundCenter(s, i, i + 1);
            int len = Math.max(oddLen, evenLen);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }

        return R - L - 1;
    }
}
