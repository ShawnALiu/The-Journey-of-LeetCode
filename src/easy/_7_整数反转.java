package easy;

public class _7_整数反转 {
    public static void main(String[] args) {
        int x = 0;
        int res = reverse(x);
        // System.out.println(res);
    }

    public static int reverse(int x) {
        int flag = x >= 0 ? 1 : -1;
        long longX = Math.abs((long)x), revX = 0, res;
        while (longX > 0) {
            res = longX % 10;
            revX = revX * 10 + res;
            longX /= 10;
        }
        revX *= flag;
        if (revX > Integer.MAX_VALUE || revX < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)revX;
    }
}
