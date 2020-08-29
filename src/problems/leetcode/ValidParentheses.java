package problems.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// https://leetcode.com/explore/interview/card/top-interview-questions-easy/99/others/721/
class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (stack.empty()) return false;
                char top = stack.pop();
                if (top != map.get(c)) return false;
            }
            else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
