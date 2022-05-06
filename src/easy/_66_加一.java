package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author lz
 * @date 2021/08/23 23:17
 **/
public class _66_加一 {

    public static void main(String[] args) {
        int[] digits = {1, 2, 3};
        int[] res = plusOne(digits);
    }

    public static int[] plusOne(int[] digits) {
        List<Integer> list = new ArrayList<>();
        int ind = digits.length - 1, add = 1, tmp;
        // 这样 || 的写法，在while里面一定要判断每个条件的合法性
        while (ind >= 0 || add != 0) {
            tmp = ind >= 0 ? add + digits[ind] : add;
            add = tmp / 10;
            tmp %= 10;
            list.add(tmp);
            ind--;
        }
        Collections.reverse(list);
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}
