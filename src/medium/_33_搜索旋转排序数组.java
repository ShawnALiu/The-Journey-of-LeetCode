package medium;

/**
 * @author lz
 * @date 2021/07/25 17:13
 **/
public class _33_搜索旋转排序数组 {
    public static void main(String[] args) {
        int[] nums = {3, 1};
        int target = 1;
        int res = search(nums, target);
    }

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;

        while (left <= right) {
            mid = (right - left) / 2 + left;
            if (target == nums[mid]) {
                return mid;
            }
            // 分3种情况讨论以确定有序子数组的范围
            if (nums[left] < nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[left] > nums[mid]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else { // 此时 nums[left] == nums[mid], 由于nums[mid]！=target，因此left++
                // 此处用于判断当nums数组有重复元素时，该题题干明确没有重复元素，可不加
                if (target == nums[left])
                    return left;
                left++;
            }
        }
        return -1;
    }
}
