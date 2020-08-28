package problems.leetcode;

public class CountPrimes {

    public int countPrimes1(int n) {
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            boolean isPrime = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) cnt++;
        }

        return cnt;
    }

    public int countPrimes2(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        CountPrimes countPrimes = new CountPrimes();
        long before1 = System.currentTimeMillis();
        int ans1 = countPrimes.countPrimes1(1234567);
        long end1 = System.currentTimeMillis();
        long res1 = (end1 - before1);

        long before2 = System.currentTimeMillis();
        int ans2 = countPrimes.countPrimes2(1234567);
        long end2 = System.currentTimeMillis();
        long res2 = (end2 - before2);

        System.out.println("Method 1: " + res1 + "ms, " + "Method 2: " + res2 + "ms.");
        System.out.println("The answer : " + ans1);
        /* Method 1: 433ms, Method 2: 17ms.
        The answer : 95360 */
    }
}
