package easy;

/**
 * @author lz
 * @date 2021/08/24 22:12
 **/
public class _67_二进制求和 {

    public static void main(String[] args) {
        String a = "11", b = "1";
        String res = addBinary(a, b);
    }

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int add = 0, ind1 = a.length() - 1, ind2 = b.length() - 1;
        while (ind1 >= 0 || ind2 >= 0 || add != 0) {
            int tmpSum = 0;
            if (ind1 >= 0) {
                // 不能使用强转，会被转换成ascii码
                tmpSum += (a.charAt(ind1) - '0');
                ind1--;
            }
            if (ind2 >= 0) {
                tmpSum += (b.charAt(ind2) - '0');
                ind2--;
            }
            tmpSum += add;
            add = tmpSum / 2;
            tmpSum %= 2;
            sb.append(tmpSum);
        }
        sb.reverse();
        return sb.toString();
    }
}
