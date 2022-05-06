package medium;

import java.util.ArrayList;
import java.util.List;

public class _17_电话号码的字母组合 {
    public static void main(String[] args) {
        String digits = "";
        List<String> res = letterCombinations(digits);
    }

    public static char[][] table = {{}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
        {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        helper(res, digits, sb, 0);
        return res;
    }

    // 回溯法
    public static void helper(List<String> res, String digits, StringBuilder sb, int t) {
        if (t == digits.length()) {
            res.add(sb.toString());
            return;
        }
        int digit = Integer.parseInt(String.valueOf(digits.charAt(t))) - 1;
        for (int i = 0; i < table[digit].length; i++) {
            sb.append(table[digit][i]);
            helper(res, digits, sb, t + 1);
            sb.deleteCharAt(t);
        }
    }
}
