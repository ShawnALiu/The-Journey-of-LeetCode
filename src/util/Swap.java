package util;

/**
 * @author lz
 * @date 2021/07/24 19:29
 **/
public class Swap {

    // 泛型不能用于基本数据类型
    public static <T> void swap(T[] nums, int i, int j) {
        T tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
