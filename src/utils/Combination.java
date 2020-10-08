package utils;

// some implementation of nCr
public class Combination {

    // Use backtracking
    public static void generate(int[] arr, boolean[] visited, int start, int n, int ind, int r) {
        if (ind == r) {
            print(arr, visited, r);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            generate(arr, visited, i + 1, n, ind + 1, r);
            visited[i] = false;
        }
    }

    private static void print(int[] arr, boolean[] visited, int r) {
        StringBuilder res = new StringBuilder();
        res.append("[");
        for (int i = 0; i < visited.length; i++) {
            if (visited[i])  {
                res.append(arr[i]);
                r--;
                if (r > 0) res.append(", ");
            }
        }
        res.append("]");
        System.out.println(res.toString());
    }

    public static void main(String[] args) {
        generate(new int[]{1, 2, 3, 4, 5}, new boolean[5], 0, 5, 0, 2);
    }
}
