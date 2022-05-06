package medium;

/**
 * @author lz
 * @date 2021/09/07 22:56
 **/
public class _80_删除有序数组中的重复项II {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int res = removeDuplicates(nums);
    }

    public static int removeDuplicates(int[] nums) {
        int vis = 1, ins = 1, cnt = 1;
        while (vis < nums.length) {
            if (nums[vis] != nums[vis - 1]) {
                nums[ins++] = nums[vis++];
                cnt = 1;
            } else {
                cnt++;
                if (cnt <= 2) {
                    nums[ins++] = nums[vis++];
                } else {
                    vis++;
                }
            }
        }
        return ins;
    }
}
