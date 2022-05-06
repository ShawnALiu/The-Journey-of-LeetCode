package medium;

/**
 * 
 * @author lz
 * @date 2021/07/24 18:39
 **/
public class _31_下一个排列 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        nextPermutation(nums);
    }

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 1, j = nums.length - 1;
        // 从后往前找到第一个顺序对，
        // 此时说明，从最后至当前位置全是逆序，即[i~nums.length - 1]是一个降序数组
        while (i >= 1 && nums[i - 1] >= nums[i]) {
            i--;
        }
        if (i >= 1) {
            // 从降序数组里找到大于nums[i - 1]的第一个数
            while (j > i && nums[j] <= nums[i - 1]) {
                j--;
            }
            // 交换位子
            swap(nums, i - 1, j);
        }
        // 将后面的降序改为升序，这样使数组是大于原数组的最小的数
        int left = i, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
