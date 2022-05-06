package medium;

public class _12_整数转罗马数字 {

    // 分4档来执行
    private static int[] div = new int[] {1000, 100, 10, 1};

    private static String[][] list = {{"0", "0", "0", "M"}, // 1000
        {"CM", "D", "CD", "C"}, // 900,500,400,100
        {"XC", "L", "XL", "X"}, // 90,50,40,10
        {"IX", "V", "IV", "I"}}; // 9,5,4,1

    public static void main(String[] args) {
        int num = 3999;
        String s = intToRoman(num);
    }

    public static String intToRoman(int num) {
        StringBuffer sb = new StringBuffer();
        int n = 0;
        while (num > 0) {
            for (int d = 0; d < div.length; d++) {
                if (num >= div[d]) {
                    n = num / div[d];
                    num %= div[d];
                    if (n >= 9) {
                        sb.append(list[d][0]);
                    } else if (n >= 6) {
                        sb.append(list[d][1]);
                        for (int j = 0; j < n - 5; j++) {
                            sb.append(list[d][3]);
                        }
                    } else if (n == 5) {
                        sb.append(list[d][1]);
                    } else if (n == 4) {
                        sb.append(list[d][2]);
                    } else {
                        for (int j = 0; j < n; j++) {
                            sb.append(list[d][3]);
                        }
                    }
                }
            }
        }
        return sb.toString();
    }
}
