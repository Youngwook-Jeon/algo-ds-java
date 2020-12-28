package problems.leetcode;

// #id: 4
class MedianOfTwoSortedArrays {

    // time complexity: O(min(m, n))
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n)
            return solve(nums2, nums1);
        return solve(nums1, nums2);
    }

    private double solve(int[] nums1, int[] nums2) {
        double ans = 0;
        int m = nums1.length;
        int n = nums2.length;
        int maxOfLeft, minOfRight;
        int iMin = 0;
        int iMax = m;
        int half = (m + n + 1) / 2;

        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = half - i;
            if (i < m && nums1[i] < nums2[j - 1]) {
                iMin = i + 1;
            } else if (i > 0 && nums1[i - 1] > nums2[j]) {
                iMax = i - 1;
            } else {
                if (i == 0) maxOfLeft = nums2[j - 1];
                else if (j == 0) maxOfLeft = nums1[i - 1];
                else {
                    maxOfLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }

                if ((m + n) % 2 == 1) {
                    ans = maxOfLeft;
                    break;
                }

                if (i == m) minOfRight = nums2[j];
                else if (j == n) minOfRight = nums1[i];
                else {
                    minOfRight = Math.min(nums1[i], nums2[j]);
                }

                ans = (double)(maxOfLeft + minOfRight) / 2;
                break;
            }
        }
        return ans;
    }
}
