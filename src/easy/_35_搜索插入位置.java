package easy;

/**
 * 
 * @author lz
 * @date 2021/07/27 21:46
 **/
public class _35_搜索插入位置 {
    public static void main(String[] args) {
        int[] nums = {1};
        int target = 0;
        int res = searchInsert(nums, target);
    }

    public static int searchInsert(int[] nums, int target) {
        return findFirstLargerEqual(nums, target);
    }

    public static int findFirstLargerEqual(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (left < 0)
            return 0;
        return left;
    }
}
