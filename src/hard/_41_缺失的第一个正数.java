package hard;

/**
 * 
 * @author lz
 * @date 2021/07/30 23:08
 **/
public class _41_缺失的第一个正数 {

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        int res = firstMissingPositive(nums);
    }

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // 将 [1,n]之间的数存在数组中对应的位置，即 nums[x-1] = x
        for (int i = 0; i < n; i++) {
            // 当 x = nums[x-1] 时，说明 x 已经在对应的位置，无需再交换
            while (nums[i] >= 1 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                // 不能先赋值 nums[i]，否则再赋值nums[nums[i] - 1]，其中nums[i]已经被改变
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (nums[i - 1] != i) {
                return i;
            }
        }
        return n + 1;
    }

}
