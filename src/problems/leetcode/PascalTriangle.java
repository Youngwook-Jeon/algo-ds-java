package problems.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        if (numRows == 0) return ret;

        ret.add(Arrays.asList(1));

        if (numRows == 1) return ret;
        ret.add(Arrays.asList(1, 1));
        List<Integer> sub;
        for (int i = 2; i < numRows; i++) {
            sub = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    sub.add(1);
                } else {
                    List<Integer> lst = ret.get(i - 1);
                    sub.add(lst.get(j - 1) + lst.get(j));
                }
            }
            ret.add(sub);
        }

        return ret;
    }

    public static void main(String[] args) {
        PascalTriangle pascalTriangle = new PascalTriangle();
        System.out.println(pascalTriangle.generate(10));
    }
}
