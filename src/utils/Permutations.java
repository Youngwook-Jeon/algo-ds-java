package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    private static boolean[] visited;

    public static void main(String[] args) {
        List<int[]> lst = permutate(new int[]{1, 5, 3, 2});
        for (int[] arr : lst) {
            System.out.println(Arrays.toString(arr));
        }
    }

    private static List<int[]> permutate(int[] dist) {
        visited = new boolean[dist.length];
        List<int[]> lst = new ArrayList<>();
        helper(lst, 0, new int[dist.length], dist);
        return lst;
    }

    private static void helper(List<int[]> lst, int ind, int[] arr, int[] dist) {
        if (ind == dist.length) {
            int[] copied = arr.clone();
            lst.add(copied);
            return;
        }
        for (int i = 0; i < dist.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[ind++] = dist[i];
                helper(lst, ind, arr, dist);
                visited[i] = false;
                ind--;
            }
        }
    }
}
