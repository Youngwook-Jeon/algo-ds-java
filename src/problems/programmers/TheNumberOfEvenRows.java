package problems.programmers;

// https://programmers.co.kr/learn/courses/30/lessons/68647
class TheNumberOfEvenRows {

    final int MODULUS = 10000019;
    long[][] nCr;
    int[] numOfOnesInColumn;
    long[][] dp;

    public int solution(int[][] a) {
        int r = a.length;
        int c = a[0].length;

        calcCombinations(r);
        countOnes(a);

        // dp[i][j] : b의 i번째 열까지 주어진 조건에 맞게 채웠을 경우, 1의 갯수가 짝수인 행의 갯수가 j인 b의 경우의
        dp = new long[c + 1][r + 1];
        dp[1][r - numOfOnesInColumn[0]] = nCr[r][numOfOnesInColumn[0]];
        for (int i = 1; i < c; i++) {
            int ones = numOfOnesInColumn[i];
            for (int j = 0; j <= r; j++) {
                // j개의 짝수 행들 중 k개를 택하여 1을 추가함, 즉 홀수 행이 되어버리는 경우임
                // 나머지 ones - k개의 1들은 기존의 홀수 행에 추가하여 새로운 짝수 행을 만드는 경우임
                for (int k = 0; k <= ones; k++) {
                    if (k > j) continue;
                    int numOfEven = (j - k) + (ones - k);
                    if (numOfEven > r) continue;
                    long prevCases = ((nCr[j][k] * nCr[r - j][ones - k] % MODULUS) * dp[i][j]) % MODULUS;
                    dp[i + 1][numOfEven] = (dp[i + 1][numOfEven] + prevCases) % MODULUS;
                }
            }
        }

        return (int)dp[c][r];
    }

    private void calcCombinations(int r) {
        nCr = new long[r + 1][r + 1];
        nCr[0][0] = 1;
        for (int i = 1; i < r + 1; i++) {
            for (int j = 0; j < r + 1; j++) {
                if (j == 0 || i == j) nCr[i][j] = 1;
                else  {
                    nCr[i][j] = (nCr[i - 1][j - 1] + nCr[i - 1][j]) % MODULUS;
                }
            }
        }
    }

    private void countOnes(int[][] a) {
        numOfOnesInColumn = new int[a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 1) numOfOnesInColumn[j]++;
            }
        }
    }
}
