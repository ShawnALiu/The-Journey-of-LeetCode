package sortAlg;

/**
 * @author lz
 * @date 2023/07/11 01:10
 **/
public class MergeSort {

    private static void mergeTwo(int[] nums, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        //必须是mid+1
        int ind1 = left, ind2 = mid + 1, ind = 0;
        while (ind1 <= mid || ind2 <= right) {
            if (ind1 <= mid && ind2 <= right) {
                if (nums[ind1] <= nums[ind2]) {
                    tmp[ind++] = nums[ind1++];
                } else {
                    tmp[ind++] = nums[ind2++];
                }
            }
            if (ind1 > mid && ind2 <= right) {
                tmp[ind++] = nums[ind2++];
            }
            if (ind1 <= mid && ind2 > right) {
                tmp[ind++] = nums[ind1++];
            }
        }
        //复制回原数组
        for (int i = left; i <= right; i++) {
            nums[i] = tmp[i - left];
        }
    }

    public static void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        mergeTwo(nums, left, mid, right);
    }

    public static void main(String[] args) {
        int[] nums = {10, 1, 2, 3, 4, 11, 11, 2, 8, 6};
        mergeSort(nums, 0, nums.length - 1);
    }

}
