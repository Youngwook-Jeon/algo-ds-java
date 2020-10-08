package problems.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;

// #id: 3190
class Snake {

    static int n;
    static int[][] table;
    static Map<Integer, Character> directionChange = new HashMap<>();
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int nowX;
    static int nowY;
    static Queue<Pair> queue = new ArrayDeque<>();

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        table = new int[n][n];
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            table[y - 1][x - 1] = 2; // position of apple
        }
        int l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int seconds = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            directionChange.put(seconds, dir);
        }

        int ans = solver();

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }

    private static int solver() {
        int ans = 0;
        int dir = 0;
        nowX = 0;
        nowY = 0;
        int tailX = 0;
        int tailY = 0;
        queue.add(new Pair(tailX, tailY));
        table[tailY][tailX] = 1;

        while (true) {
            int newX = nowX + dx[dir];
            int newY = nowY + dy[dir];
            ans += 1;

            if (newX < 0 || newX >= n || newY < 0 || newY >= n) break;

            if (table[newY][newX] == 2) {
                queue.add(new Pair(newX, newY));
            } else if (table[newY][newX] == 0) {
                queue.add(new Pair(newX, newY));
                Pair p = queue.poll();
                table[p.y][p.x] = 0;
            }
            else break;

            table[newY][newX] = 1;

            if (directionChange.containsKey(ans)) {
                char c = directionChange.get(ans);
                if (c == 'L') {
                    dir = (dir + 3) % 4;
                } else {
                    dir = (dir + 1) % 4;
                }
            }
            nowX = newX;
            nowY = newY;
        }

        return ans;
    }
}
