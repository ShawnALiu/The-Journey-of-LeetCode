package hard;

public class _4_寻找两个正序数组的中位数 {
    public static void main(String[] args) {
        int mid1 = (0 + 1) / 2;
        int[] nums1 = {1, 3}, nums2 = {2};
        double midNum = findMedianSortedArrays2(nums1, nums2);

        System.out.println(mid1);
    }

    // 方法1：将2个有序数组合并成1个有序数组，再挑选中位数，时间复杂度O(m+n)
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        if (nums1.length + nums2.length == 0)
            return 0;
        int[] nums = mergeTwoArray(nums1, nums2);
        if (nums.length % 2 == 0) {
            return (nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2.;
        }
        return nums[(nums.length - 1) / 2];
    }

    public static int[] mergeTwoArray(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length || j < nums2.length) {
            if (i >= nums1.length) {
                nums[k++] = nums2[j++];
                continue;
            }
            if (j >= nums2.length) {
                nums[k++] = nums1[i++];
                continue;
            }
            nums[k++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
        }
        return nums;
    }

    // 方法2：二分法，时间复杂度O（log(m+n))
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        if (length % 2 == 0) {
            int n = helper(nums1, nums2, 0, 0, length / 2);
            int m = helper(nums1, nums2, 0, 0, length / 2 + 1);
            return (n + m) / 2.;
        }
        return helper(nums1, nums2, 0, 0, (length + 1) / 2);
    }

    // 还没完成
    public static int helper(int[] nums1, int[] nums2, int start1, int start2, int target) {

        int res = 0;
        int end1 = nums1.length, end2 = nums2.length;
        if (start1 >= end1)
            return nums2[start2 + target - 1];
        if (start2 >= end2)
            return nums1[start1 + target - 1];
        int mid1 = (start1 + end1) / 2, mid2 = (start2 + end2) / 2;
        if (target == 0) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        if (nums1[mid1] <= nums2[mid2]) {
            if (target - (mid1 - start1 + 1) == 0)
                return nums1[mid1];
            res = helper(nums1, nums2, mid1 + 1, start2, target - (mid1 - start1 + 1));
        } else {
            if (target - (mid2 - start2 + 1) == 0)
                return nums2[mid2];
            res = helper(nums1, nums2, start1, mid2 + 1, target - (mid2 - start2 + 1));
        }
        return res;
    }
}
