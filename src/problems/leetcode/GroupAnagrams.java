package problems.leetcode;

import java.util.*;

class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<String> lst = new ArrayList<>();
        int[] arr = new int[26];

        for (int i = 0; i < strs.length; i++) {
            Arrays.fill(arr, 0);
            for (int j = 0; j < strs[i].length(); j++) {
                arr[strs[i].charAt(j) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < arr.length; j++) {
                sb.append('#');
                sb.append(arr[j]);
            }
            String s = sb.toString();
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }
            map.get(s).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }
}
