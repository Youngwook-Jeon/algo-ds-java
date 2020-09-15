package problems.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// #id : 1987
public class Alphabet {

    static final int ALPHABET_SIZE = 26;
    static boolean[] visit = new boolean[ALPHABET_SIZE];
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static int result = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
        String[] board = new String[r];
        for (int i = 0; i < r; i++) {
            board[i] = bufferedReader.readLine().trim();
        }

        solver(board);
    }

    public static void solver(String[] board) {
        dfs(board, 0, 0, 1);
        System.out.print(result);
    }

    private static int dfs(String[] board, int x, int y, int depth) {
        visit[board[y].charAt(x) - 'A'] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX < board[0].length() && newX >= 0 &&
                    newY < board.length && newY >= 0 &&
                    !visit[board[newY].charAt(newX) - 'A']) {
                result = Math.max(dfs(board, newX, newY, depth + 1), result);
                visit[board[newY].charAt(newX) - 'A'] = false;
            }
        }
        return depth;
    }


}
