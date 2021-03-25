package problems.leetcode;

import java.util.ArrayList;
import java.util.List;

// Partition Labels
// the number of id: 763
class PartitionLabels {

    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); i++) {
            last[S.charAt(i) - 'a'] = i;
        }

        int start = 0, end = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);

            if (end == i) {
                ans.add(end - start + 1);
                start = i + 1;
            }
        }

        return ans;
    }
}

