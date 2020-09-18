package problems.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InvertString {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        int ans = solver(str);
        System.out.println(ans);
    }

    private static int solver(String str) {
        int[] arr = new int[2];
        char curr = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != curr) {
                arr[curr - '0']++;
                curr = str.charAt(i);
            }
        }
        arr[curr - '0']++;
        return Math.min(arr[0], arr[1]);
    }
}
