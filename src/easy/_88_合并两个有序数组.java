package easy;

/**
 * @author lz
 * @date 2021/10/07 20:20
 **/
public class _88_合并两个有序数组 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0}, nums2 = {2, 5, 6};
        int m = 3, n = 3;
        merge(nums1, m, nums2, n);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int cur1 = m - 1, cur2 = n - 1, toIns = m + n - 1;
        while (cur1 >= 0 || cur2 >= 0) {
            if (cur1 < 0) {
                nums1[toIns--] = nums2[cur2--];
                continue;
            }
            if (cur2 < 0) {
                nums1[toIns--] = nums1[cur1--];
                continue;
            }
            if (nums1[cur1] >= nums2[cur2]) {
                nums1[toIns--] = nums1[cur1--];
            } else {
                
                nums1[toIns--] = nums2[cur2--];
            }
        }
    }
}
