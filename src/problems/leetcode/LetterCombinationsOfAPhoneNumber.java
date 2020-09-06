package problems.leetcode;

import java.util.*;

class LetterCombinationsOfAPhoneNumber {

    Map<String, String> phone = new HashMap<String, String>();
    List<String> ret = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        phone.put("2", "abc");
        phone.put("3", "def");
        phone.put("4", "ghi");
        phone.put("5", "jkl");
        phone.put("6", "mno");
        phone.put("7", "pqrs");
        phone.put("8", "tuv");
        phone.put("9", "wxyz");

        if (digits.length() == 0) return ret;

        helper("", digits);
        return ret;
    }

    private void helper(String combination, String nextDigits) {
        if (nextDigits.length() == 0) ret.add(combination);
        else {
            String digit = nextDigits.substring(0, 1);
            String alphas = phone.get(digit);

            for (int i = 0; i < alphas.length(); i++) {
                String alpha = alphas.substring(i, i + 1);
                helper(combination + alpha, nextDigits.substring(1));
            }
        }
    }
}
