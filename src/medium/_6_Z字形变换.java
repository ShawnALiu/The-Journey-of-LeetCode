package medium;

public class _6_Z字形变换 {

    public static void main(String[] args) {
        String s1 = "PAYPALISHIRING", s2 = "PAYPALISHIRING", s3 = "A";
        int numRows1 = 3, numRows2 = 4, numRows3 = 1;
        String res = convert(s3, numRows3);
    }

    public static String convert(String s, int numRows) {
        if (s == null || s.length() == 0) {
            return null;
        }
        // 很重要
        if (s.length() == 1 || numRows == 1)
            return s;
        int charInd1, charInd2, loopSize = 2 * numRows - 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int loop = 0; i + loopSize * loop < s.length(); loop++) {
                if (i == 0 || i == numRows - 1) {
                    sb.append(s.charAt(i + loopSize * loop));
                    continue;
                }
                charInd1 = i + loopSize * loop;
                charInd2 = loopSize * (loop + 1) - i;
                sb.append(s.charAt(charInd1));
                if (charInd2 < s.length())
                    sb.append(s.charAt(charInd2));
            }
        }
        return sb.toString();
    }
}
