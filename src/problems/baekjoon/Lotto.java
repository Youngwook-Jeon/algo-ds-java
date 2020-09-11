package problems.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Lotto {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] arr = br.readLine().split(" ");
            int n = Integer.parseInt(arr[0]);
            if (n == 0) break;
            String[] strs = Arrays.copyOfRange(arr, 1, arr.length);
            permute(strs, 0, 0, "");
            System.out.println();
        }
    }

    public static void permute(String[] strs, int at, int depth, String str) {
        if (depth == 6) {
            System.out.println(str);
            return;
        }
        for (int i = at; i < strs.length; i++) {
            permute(strs, i + 1, depth + 1, str + strs[i] + " ");
        }
    }
}
