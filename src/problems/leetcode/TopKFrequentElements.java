package problems.leetcode;

import java.util.*;

class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i : map.keySet()) {
            heap.offer(i);
            if (heap.size() > k) heap.poll();
        }
        int[] ret = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            ret[i] = heap.poll();
        }

        return ret;
    }
}