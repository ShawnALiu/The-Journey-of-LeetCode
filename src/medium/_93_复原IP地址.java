package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lz
 * @date 2021/10/19 23:36
 **/
public class _93_复原IP地址 {

    public static void main(String[] args) {
        String s = "101023";
        List<String> res = restoreIpAddresses(s);
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        String sb = null;
        int startInd = 0, k = 0;
        backtrace(res, s, sb, startInd, k);
        return res;
    }

    public static void backtrace(List<String> res, String s, String sb, int startInd, int k) {
        if (k == 4 && startInd < s.length()) {
            return;
        }
        if (k == 4 && startInd == s.length()) {
            res.add(String.valueOf(sb));
            return;
        }
        for (int i = 1; i <= 3 && startInd + i <= s.length(); i++) {
            String numStr = s.substring(startInd, startInd + i);
            int num = Integer.parseInt(numStr);
            if (i != 1 && numStr.charAt(0) == '0') {
                continue;
            }
            if (num < 0 || num > 255) {
                continue;
            }
            String tmpSb = sb;
            if (tmpSb == null) {
                tmpSb = String.valueOf(num);
            } else {
                tmpSb = tmpSb + "." + num;
            }
            startInd += i;
            backtrace(res, s, tmpSb, startInd, k + 1);
            startInd -= i;
        }
    }
}
