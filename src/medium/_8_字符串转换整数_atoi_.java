package medium;

public class _8_字符串转换整数_atoi_ {

    public static void main(String[] args) {
        String s = "9223372036854775808";
        int res = myAtoi(s);
    }

    public static int myAtoi(String s) {
        // 空格、符号规则的标志位，只能检测1次，后续遇到直接结束计算
        boolean space = false, sign = false;
        int flag = 1, res = 0;
        long longRes = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!space && s.charAt(i) == ' ') {
                continue;
            }
            // 空格规则检测结束
            if (!space) {
                space = true;
            }
            if (!sign && s.charAt(i) == '-') {
                flag = -1;
                sign = true;
                continue;
            }
            if (!sign && s.charAt(i) == '+') {
                sign = true;
                continue;
            }
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                break;
            }
            // 符号规则检测结束
            if (!sign) {
                sign = true;
            }
            longRes = longRes * 10 + (s.charAt(i) - '0');
            // 必须判断是否提前结束，因为0 <= s.length <= 200，
            if (longRes < Integer.MIN_VALUE || longRes > Integer.MAX_VALUE) {
                break;
            }
        }
        longRes *= flag;
        // 范围规则
        if (longRes < Integer.MIN_VALUE) {
            res = Integer.MIN_VALUE;
        } else if (longRes > Integer.MAX_VALUE) {
            res = Integer.MAX_VALUE;
        } else {
            res = (int)longRes;
        }
        return res;
    }

}