package easy;

/**
 * @author lz
 * @date 2021/08/24 22:42
 **/
public class _69_x的平方根 {

    public static void main(String[] args) {
        int x = 2147395600;
        int res = mySqrt(x);
    }

    // [滚动数组]的方法
    public static int mySqrt1(int x) {
        int pre = 0;
        long preSquare = 0, i = 0;
        while (preSquare <= x) {
            long tmpSquare = i * i;
            if (tmpSquare > x) {
                break;
            }
            preSquare = tmpSquare;
            pre = (int) i;
            i++;
        }
        return pre;
    }

    // 二分法
    public static int mySqrt(int x) {
        int l = 0, r = x, ans = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
