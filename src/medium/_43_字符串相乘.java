package medium;

/**
 * 
 * @author lz
 * @date 2021/08/01 20:21
 **/
public class _43_字符串相乘 {

    public static void main(String[] args) {
        String num1 = "123", num2 = "456";
        String res = multiply(num1, num2);
    }

    public static String multiply(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        if (n1 == 0 || n2 == 0 || num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        // 开始计算，每次从后往前取 num2 的1位，与num1相乘
        int ind = n2 - 1, padding;
        String res = "";
        while (ind >= 0) {
            padding = n2 - 1 - ind;
            StringBuilder sb = new StringBuilder();
            int tmp, carry = 0;
            for (int i = n1 - 1; i >= 0; i--) {
                tmp = (num1.charAt(i) - '0') * (num2.charAt(ind) - '0') + carry;
                carry = tmp / 10;
                tmp %= 10;
                sb.append(tmp);
            }
            // 一定要记得处理进位carry
            if (carry > 0) {
                sb.append(carry);
            }
            sb.reverse();
            for (int i = 0; i < padding; i++) {
                sb.append(0);
            }
            res = StringAdd(res, sb.toString());
            ind--;
        }

        return res;
    }

    public static String StringAdd(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        if (n1 == 0 || num1.equals("0")) {
            return num2;
        }
        if (n2 == 0 || num2.equals("0")) {
            return num1;
        }
        int ind1 = num1.length() - 1, ind2 = num2.length() - 1, carry = 0;
        StringBuilder sb = new StringBuilder();
        // 分3个部分相加，一定不能忘了是否有进位carry
        while (ind1 >= 0 || ind2 >= 0 || carry > 0) {
            int tmp = 0;
            if (ind1 >= 0) {
                tmp += (num1.charAt(ind1) - '0');
                ind1--;
            }
            if (ind2 >= 0) {
                tmp += (num2.charAt(ind2) - '0');
                ind2--;
            }
            if (carry > 0) {
                tmp += carry;
            }
            carry = tmp / 10;
            tmp %= 10;
            sb.append(tmp);
        }
        return sb.reverse().toString();
    }
}
