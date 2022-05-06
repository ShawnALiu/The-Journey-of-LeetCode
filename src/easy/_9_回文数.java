package easy;

public class _9_回文数 {
    public static void main(String[] args) {
        int x = 10;
        boolean res = isPalindrome(x);
    }

    public static boolean isPalindrome(int x) {
        // 负数不是
        // 尾数为0时，则要求首位也为0，只有0满足该条件
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revX = 0;
        // 当x <= revX说明已转换了一半长度
        while (x > 0 && x > revX) {
            revX = revX * 10 + (x % 10);
            x /= 10;
        }
        // 偶数长度时，转换后相等
        // 奇数长度时，去除转换后的最后一个数字，才相等
        return x == revX || x == revX / 10;
    }
}
