package medium;

import java.util.ArrayList;
import java.util.List;

public class _22_括号生成 {

    public static void main(String[] args) {
        int n = 4;
        List<String> res = generateParenthesis(n);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    // 合法的括号字符串：
    // 保证从头开始的顺序子序列的 左括号数目 大于等于 右括号数目，在最后左右括号数目相等
    // 因此，反推。在构建过程中，保证左括号数目 大于等于 右括号数目。回溯保证左右括号数目一样。
    public static void backtrack(List<String> res, StringBuilder sb, int left, int right, int n) {
        if (sb.length() == n * 2) {
            res.add(sb.toString());
            return;
        }

        if (left < n) {
            sb.append("(");
            backtrack(res, sb, left + 1, right, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (right < left) {
            sb.append(")");
            backtrack(res, sb, left, right + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
