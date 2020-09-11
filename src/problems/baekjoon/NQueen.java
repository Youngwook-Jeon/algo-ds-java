package problems.baekjoon;

import java.util.*;

class NQueen {
    static boolean[] flagRow;
    static boolean[] flagDiag1;
    static boolean[] flagDiag2;
    static int n;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        flagRow = new boolean[n];
        flagDiag1 = new boolean[2 * n - 1];
        flagDiag2 = new boolean[2 * n - 1];
        int ans = dfs(0);
        System.out.print(ans);
        scanner.close();
    }

    public static int dfs(int depth) {
        if (depth == n) return 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (!flagRow[i] && !flagDiag1[depth + i] && !flagDiag2[depth - i + n - 1]) {
                flagRow[i] = flagDiag1[depth + i] = flagDiag2[depth - i + n - 1] = true;
                sum += dfs(depth + 1);
                flagRow[i] = flagDiag1[depth + i] = flagDiag2[depth - i + n - 1] = false;

            }
        }
        return sum;
    }

}
