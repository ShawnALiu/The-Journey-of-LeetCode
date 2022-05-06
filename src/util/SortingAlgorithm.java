package util;

/**
 * 排序算法
 *
 * @author lz
 * @date 2021/09/25 23:11
 **/
public class SortingAlgorithm {

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 6, 8, 5, 7, 9, 3, 10, 13, 11, 12};
        quickSort(nums, 0, nums.length - 1);
    }

    /**
     * 快速排序
     *
     * @param nums  数组
     * @param left  左边界索引
     * @param right 右边界索引
     */
    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int key = nums[left];
        int i = left, j = right;
        while (i < j) {
            while (i < j && nums[j] >= key) {
                j--;
            }
            if (i < j) {
                nums[i++] = nums[j];
            }
            while (i < j && nums[i] <= key) {
                i++;
            }
            if (i < j) {
                nums[j--] = nums[i];
            }
            nums[i] = key;
            quickSort(nums, left, i - 1);
            quickSort(nums, i + 1, right);
        }
    }
}
