package problems.leetcode;

import java.util.HashSet;
import java.util.Set;

class LongestSubstringWithoutRepeats {
//     a naive method of O(n * n) time complexity
//     public int lengthOfLongestSubstring(String s) {
//         if (s.length() == 0) return 0;
//         Set<Character> set = new HashSet<>();
//         int ans = 1;
//         int local = 1;
//         for (int i = 0; i < s.length() - 1; i++) {
//             local = 1;
//             set.add(s.charAt(i));
//             for (int j = i + 1; j < s.length(); j++) {
//                 if (set.contains(s.charAt(j))) {
//                     break;
//                 }
//                 set.add(s.charAt(j));
//                 local++;
//             }
//             ans = Math.max(local, ans);
//             set.clear();
//         }

//         return ans;
//     }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0;
        int ans = 0;
        int n = s.length();
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return ans;
    }
}
