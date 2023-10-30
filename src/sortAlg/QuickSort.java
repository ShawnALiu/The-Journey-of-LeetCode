package sortAlg;

/**
 * @author lz
 * @date 2023/07/10 23:37
 **/
public class QuickSort {

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int key = nums[left];
        int i = left, j = right;
        while (i < j) {
            //必须先右边
            while (i < j && nums[j] >= key)
                j--;
            if (i < j)
                swap(nums, i++, j);

            while (i < j && nums[i] <= key)
                i++;
            if (i < j)
                swap(nums, i, j--);

            //必须在循环里面
            quickSort(nums, left, i - 1);
            quickSort(nums, i + 1, right);
        }

    }

    public static void main(String[] args) {
        int[] nums = {10, 1, 2, 3, 4, 11, 11, 2, 8, 6};
        quickSort(nums, 0, nums.length - 1);
    }
}
