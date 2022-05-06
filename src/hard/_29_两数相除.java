package hard;

/**
 * 
 * @author lz
 * @date 2021/07/21 21:09
 **/
public class _29_两数相除 {
    public static void main(String[] args) {
        int dividend = 7, divisor = -3;
        int res = divide(dividend, divisor);
    }

    public static int divide(int dividend, int divisor) {
        if (dividend == 0)
            return 0;
        long d1 = Math.abs((long)dividend);
        long d2 = Math.abs((long)divisor);
        long res = helper(d1, d2);

        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            res = -res;
        }
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
            return Integer.MAX_VALUE;
        return (int)res;
    }

    // 关键点，每次将除数增加2倍
    public static long helper(long d1, long d2) {
        if (d1 < d2) {
            return 0;
        }
        long cnt = 1, td = d2;
        while ((td + td) <= d1) {
            cnt += cnt;
            td += td;
        }
        return cnt + helper(d1 - td, d2);
    }
}
