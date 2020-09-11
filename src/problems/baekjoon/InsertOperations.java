package problems.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class InsertOperations {

    static int[] arr;
    static int[] opsStatus = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        arr = new int[n];
        String[] st = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st[i]);
        }
        st = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            opsStatus[i] = Integer.parseInt(st[i]);
        }

        dfs(1, arr[0]);
        System.out.println(max);
        System.out.print(min);
    }

    public static void dfs(int depth, int local) {
        if (depth == arr.length) {
            max = Math.max(max, local);
            min = Math.min(min, local);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (opsStatus[i] != 0) {
                opsStatus[i]--;
                int tmp = local;
                switch (i) {
                    case 0:
                        local += arr[depth];
                        break;
                    case 1:
                        local -= arr[depth];
                        break;
                    case 2:
                        local *= arr[depth];
                        break;
                    case 3:
                        local /= arr[depth];
                        break;
                }
                dfs(depth + 1, local);
                local = tmp;
                opsStatus[i]++;
            }
        }
    }

}
