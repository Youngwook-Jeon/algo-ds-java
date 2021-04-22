package algorithms.patternMatching;

import java.util.Arrays;

public class BruteForce {

    /**
     * array = abcadef
     * pattern = def -> 4
     * @param array
     * @param pattern
     * @return
     */
    public static int firstMatch(char[] array, char[] pattern) {
        for (int a = 0; a <= array.length - pattern.length; a++) {
            for (int p = 0; p < pattern.length; p++) {
                if (array[a + p] != pattern[p]) break;
                if (p == pattern.length - 1) return a;
            }
        }
        return -1;
    }

    public static int[] everyMatch(char[] array, char[] pattern) {
        int[] found = new int[array.length];
        Arrays.fill(found, -1);
        int index = 0;
        for (int a = 0; a <= array.length - pattern.length; a++) {
            for (int p = 0; p < pattern.length; p++) {
                if (array[a + p] != pattern[p]) break;
                if (p == pattern.length - 1) {
                    found[index++] = a;
                }
            }
        }
        return found;
    }

    public static void main(String[] args) {
        char[] array = "abcabcdabcdeabcdef".toCharArray();
        char[] pattern = "abc".toCharArray();
        System.out.println(Arrays.toString(everyMatch(array, pattern)));
    }
}
