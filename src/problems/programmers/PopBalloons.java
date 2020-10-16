package problems.programmers;

// https://programmers.co.kr/learn/courses/30/lessons/68646?language=java
import java.util.*;

class PopBalloons {

    int[] prefixMin;
    int[] suffixMin;

    public int solution(int[] a) {
        int answer = 0;
        int n = a.length;
        prefixMin = new int[n];
        suffixMin = new int[n];
        findPrefixSuffixMin(a);
        for (int i = 0; i < n; i++) {
            if (a[i] == prefixMin[i] || a[i] == suffixMin[i]) answer++;
        }
        return answer;
    }

    private void findPrefixSuffixMin(int[] a) {
        prefixMin[0] = a[0];
        suffixMin[a.length - 1] = a[a.length - 1];
        for (int i = 1; i < a.length; i++) {
            prefixMin[i] = Math.min(prefixMin[i - 1], a[i]);
            suffixMin[a.length - 1 - i] = Math.min(suffixMin[a.length - i], a[a.length - 1 - i]);
        }
    }
}
