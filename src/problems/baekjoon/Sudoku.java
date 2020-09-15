package problems.baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// #id : 2580
public class Sudoku {

    static int[][] board = new int[9][9];
    static List<int[]> posList = new ArrayList<>();
    static int cnt;
    static boolean checked = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = scanner.nextInt();
                if (board[i][j] == 0) posList.add(new int[]{ i, j });
            }
        }
        cnt = posList.size();

        solver();
    }

    private static void solver() {
        backtrack(0, 0);
    }

    // current : the index of position we want to know.
    private static void backtrack(int current, int depth) {
        if (depth == cnt && !checked) {
            print();
            checked = true;
            return;
        }
        if (current >= cnt || checked) {
            return;
        }
        for (int i = 1; i <= 9; i++) {
            if (check(i, current)) {
                int y = posList.get(current)[0];
                int x = posList.get(current)[1];
                board[y][x] = i;
                backtrack(current + 1, depth + 1);
                board[y][x] = 0;
            }
        }
    }

    private static boolean check(int num, int current) {
        int y = posList.get(current)[0];
        int x = posList.get(current)[1];

        for (int i = 0; i < 9; i++) {
            if (board[i][x] == num || board[y][i] == num) return false;
        }

        int newY = y / 3 * 3;
        int newX = x / 3 * 3;

        for (int i = newY; i < newY + 3; i++) {
            for (int j = newX; j < newX + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }
        return true;
    }

    private static void print() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                stringBuilder.append(board[i][j]);
                if (j != 8) {
                    stringBuilder.append(" ");
                }
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder.toString());
    }
}
