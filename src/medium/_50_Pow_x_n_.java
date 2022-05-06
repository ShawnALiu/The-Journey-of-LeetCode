package medium;

/**
 * 
 * @author lz
 * @date 2021/08/08 00:13
 **/
public class _50_Pow_x_n_ {

    public static void main(String[] args) {
        double x = 2.00000;
        int n = -2147483648;
        double res = myPow(x, n);
    }

    public static double myPow(double x, int n) {
        // 需要转换为long,防止溢出
        long N = n;
        // 需要考虑负数
        return N > 0 ? helper(x, N) : 1. / helper(x, -N);
    }

    // 快速幂
    public static double helper(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double tmp = helper(x, N / 2);
        return N % 2 == 0 ? tmp * tmp : tmp * tmp * x;
    }
}
