package hard;

/**
 * 
 * @author lz
 * @date 2021/07/25 00:30
 **/
public class _32_最长有效括号 {
    public static void main(String[] args) {
        String s = "";
        int res = longestValidParentheses(s);
    }

    // 1.本质解法：从前往后统计字符串子串中的左、右括号的数目，若
    // （1）left > right, 则可以继续往后统计
    // （2）left = right, 则已经是有效括号
    // （3）left < right, 则无效括号，停止统计
    public static int longestValidParentheses(String s) {
        int longest = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int left = 0, right = 0, ind = i;
            while (ind < s.length()) {
                if (s.charAt(ind) == '(') {
                    left++;
                } else {
                    right++;
                }
                if (right > left) {
                    break;
                } else if (right == left) {
                    longest = Math.max(longest, left + right);
                }
                ind++;
            }
        }
        return longest;
    }

    // 2.动态规划

    // 3.栈
}
