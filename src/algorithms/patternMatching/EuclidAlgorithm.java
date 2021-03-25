package algorithms.patternMatching;

// Calculate the GCD between two number A and B
public class EuclidAlgorithm {

    public static int gcd(int number, int divisor) {
        int remaining = number % divisor;
        if (remaining != 0) {
            return gcd(divisor, remaining);
        } else {
            return divisor;
        }
    }

    public static int gcd2(int number, int divisor) {
        while (divisor != 0) {
            int temp = divisor;
            divisor = number % divisor;
            number = temp;
        }

        return number;
    }

    public static void main(String[] args) {
        System.out.println(gcd(27, 18));
        System.out.println(gcd2(27, 18));
        System.out.println(gcd(2800, 300));
        System.out.println(gcd2(2800, 300));
    }
}
