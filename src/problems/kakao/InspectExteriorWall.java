package problems.kakao;

import java.util.*;

// 2020 카카오 외벽 점검
// https://programmers.co.kr/learn/courses/30/lessons/60062
class InspectExteriorWall {

    static boolean[] visited;

    public int solution(int n, int[] weak, int[] dist) {
        int answer = 10;
        int len = weak.length;
        int[] newWeak = new int[2 * len];
        List<int[]> lst = permutate(dist);

        for (int i = 0; i < newWeak.length; i++) {
            if (i < len) {
                newWeak[i] = weak[i];
            } else {
                newWeak[i] = weak[i - len] + n;
            }
        }

        for (int i = 0; i < len; i++) {
            for (int[] arr : lst) {
                int count = 1;
                int lastPosition = newWeak[i] + arr[count - 1];
                for (int j = i; j < i + len; j++) {
                    if (lastPosition < newWeak[j]) {
                        count++;
                        if (count > dist.length) break;
                        lastPosition = newWeak[j] + arr[count - 1];
                    }
                }
                answer = Math.min(answer, count);
            }
        }

        if (answer > dist.length) return -1;

        return answer;
    }

    private List<int[]> permutate(int[] dist) {
        visited = new boolean[dist.length];
        List<int[]> lst = new ArrayList<>();
        helper(lst, 0, new int[dist.length], dist);
        return lst;
    }

    private void helper(List<int[]> lst, int ind, int[] arr, int[] dist) {
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
