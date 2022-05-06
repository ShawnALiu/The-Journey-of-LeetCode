package medium;

/**
 * @author lz
 * @date 2021/08/30 23:06
 **/
public class _75_颜色分类 {

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
    }

    // 要求原地算法，O(1)
    // 只扫描一遍，因此不能另外创建一个数组
    public static void sortColors(int[] nums) {
        int vis = 0, ins0 = 0, ins2 = nums.length - 1;
        // vis只能扫描到 ins2位置，因为ins2之后的都排好了，否则会把2放中间，1放最后了
        while (vis <= ins2) {
            if (nums[vis] == 0) {
                nums[ins0++] = 0;
                vis++;
                // 遇到2的时候，需要把插入位置的数置换过去
            } else if (nums[vis] == 2) {
                nums[vis] = nums[ins2];
                nums[ins2--] = 2;
                // 遇到1，不操作
            } else {
                vis++;
            }
        }
        // 将 0 和 2 之间置1
        for (int i = ins0; i <= ins2; i++) {
            nums[i] = 1;
        }
    }
}
