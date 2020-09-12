package problems.codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DecreaseTheSumOfDigits {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n > 0) {
            String[] str = br.readLine().split(" ");
            solver(str[0], Integer.parseInt(str[1]));
            n--;
        }
    }

    public static void solver(String str, int s) {
        int[] arr = new int[str.length() + 1];
        int sum = 0;
        long moves = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            arr[str.length() - i - 1] = Character.getNumericValue(str.charAt(i));
            sum += Character.getNumericValue(str.charAt(i));
        }
        int j = 0;
        long powerOfTen = 1;
        while (sum > s) {
            if (arr[j] == 0) {
                j++;
                powerOfTen *= 10;
                continue;
            }
            moves += ((10 - arr[j]) * powerOfTen);
            sum -= arr[j];
            arr[j] = 0;
            powerOfTen *= 10;
            int k = j + 1;
            arr[k] += 1;
            while (arr[k] == 10) {
                arr[k] = 0;
                arr[k + 1] += 1;
                k++;
                sum -= 9;
            }
            sum += 1;
            j++;
        }
        System.out.println(moves);
    }
}
