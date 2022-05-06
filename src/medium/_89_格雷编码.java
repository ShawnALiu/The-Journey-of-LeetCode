package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author lz
 * @date 2021/10/10 18:42
 **/
public class _89_格雷编码 {

    public static void main(String[] args) {
        int n = 2;
        List<Integer> res = grayCode(n);
    }

    //方法1：土办法，每个位置改变
    public static List<Integer> grayCode1(int n) {
        List<Integer> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(0);
        }
        res.add(0);
        HashSet<String> visited = new HashSet<>();
        visited.add(sb.toString());
        while (visited.size() != Math.pow(2, n)) {
            for (int i = 0; i < n; i++) {
                StringBuilder tmpSb = new StringBuilder(sb);
                if (tmpSb.toString().charAt(i) == '0') {
                    tmpSb.replace(i, i + 1, "1");
                } else {
                    tmpSb.replace(i, i + 1, "0");
                }
                if (!visited.contains(tmpSb.toString())) {
                    visited.add(tmpSb.toString());
                    res.add(binaryToDecimal(tmpSb.toString()));
                    sb = tmpSb;
                    break;
                }
            }
        }
        return res;
    }

    public static int binaryToDecimal(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                res += Math.pow(2, s.length() - i - 1);
            }
        }
        return res;
    }

    //方法2：镜像反射法，详见https://leetcode-cn.com/problems/gray-code/solution/gray-code-jing-xiang-fan-she-fa-by-jyd/
    public static List<Integer> grayCode(int n) {
        List<Integer> nums = new ArrayList<Integer>() {{
            add(0);
        }};
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = nums.size() - 1; j >= 0; j--) {
                nums.add(head + nums.get(j));
            }
            head <<= 1;
        }
        return nums;
    }
}
