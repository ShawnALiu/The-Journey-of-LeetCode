package easy;

public class _13_罗马数字转整数 {

    private static String[][] ROMAN =
        {{"0", "0", "0", "M"}, {"CM", "D", "CD", "C"}, {"XC", "L", "XL", "X"}, {"IX", "V", "IV", "I"},};

    private static int[][] INT = {{0, 0, 0, 1000}, {900, 500, 400, 100}, {90, 50, 40, 10}, {9, 5, 4, 1},};

    public static void main(String[] args) {
        String s = "MCMXCIV";
        int res = romanToInt(s);
    }

    public static int romanToInt(String s) {
        int res = 0;
        int ind = 0;
        while (ind < s.length()) {
            for (int i = 0; i < 4; i++) {
                if (ind + 2 <= s.length() && s.substring(ind, ind + 2).equals(ROMAN[i][0])) {
                    res += INT[i][0];
                    ind += 2;
                } else if (ind + 1 <= s.length() && s.substring(ind, ind + 1).equals(ROMAN[i][1])) {
                    int n = 0;
                    for (int j = ind + 1; j < s.length(); j++) {
                        if (s.charAt(j) == ROMAN[i][3].charAt(0)) {
                            n++;
                        } else {
                            break;
                        }
                    }
                    res = res + INT[i][1] + n * INT[i][3];
                    ind = ind + n + 1;
                } else if (ind + 2 <= s.length() && s.substring(ind, ind + 2).equals(ROMAN[i][2])) {
                    res += INT[i][2];
                    ind += 2;
                } else {
                    int n = 0;
                    for (int j = ind; j < s.length(); j++) {
                        if (s.charAt(j) == ROMAN[i][3].charAt(0)) {
                            n++;
                        } else {
                            break;
                        }
                    }
                    res = res + n * INT[i][3];
                    ind = ind + n;
                }
            }
        }
        return res;
    }
}
