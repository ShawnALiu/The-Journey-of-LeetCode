package hard;

/**
 * @author lz
 * @date 2021/08/22 00:58
 **/
public class _65_有效数字 {

    public static void main(String[] args) {
        String s = "2e0";
        boolean res = isNumber(s);
    }

    public static boolean isNumber(String s) {
        boolean numFlag = false;
        boolean eFlag = false;
        boolean dotFlag = false;
        boolean signFlag = false;
        for (int i = 0; i < s.length(); i++) {
            if ((!numFlag && (s.charAt(i) == 'e' || s.charAt(i) == 'E'))
                    || (eFlag && (s.charAt(i) == 'e' || s.charAt(i) == 'E' || s.charAt(i) == '.'))
                    || (dotFlag && (s.charAt(i) == '.' || s.charAt(i) == 'e' || s.charAt(i) == 'E' || s.charAt(i) == '+' || s.charAt(i) == '-'))
                    || (signFlag && (s.charAt(i) == '+' || s.charAt(i) == '-'))
            ) {
                return false;
            }
            if (!numFlag && !eFlag && !dotFlag && !signFlag && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
                signFlag = true;
                continue;
            }
            if (numFlag && !eFlag && (s.charAt(i) == 'e' || s.charAt(i) == 'E')) {
                eFlag = true;
                continue;
            }
            if (!eFlag && !dotFlag && s.charAt(i) == '.') {
                dotFlag = true;
                continue;
            }
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                if (!numFlag) {
                    numFlag = true;
                }
            } else {
                return false;
            }
        }
        return numFlag;
    }
}
