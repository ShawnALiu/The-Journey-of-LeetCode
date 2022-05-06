package medium;

/**
 * 
 * @author lz
 * @date 2021/07/26 22:39
 **/
public class _34_在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] res = searchRange(nums, target);
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = findFirstLargerEqual(nums, target);
        res[1] = findLastSmallEqual(nums, target);
        return res;
    }

    public static int findFirstLargerEqual(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }

    public static int findLastSmallEqual(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (right < 0 || nums[right] != target)
            return -1;
        return right;
    }
}
