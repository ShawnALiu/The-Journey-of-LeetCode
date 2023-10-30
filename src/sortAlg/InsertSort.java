package sortAlg;

/**
 * 创建空数组B，已有无序数组A，遍历A，将每一个元素插入到B中
 * 每次插入完，前面的数(数组B)是有序的
 *
 * @author lz
 * @date 2023/07/10 23:18
 **/
public class InsertSort {

    public static void insertSort(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            //待插入的数
            int key = nums[i];
            //待比较的位置
            int j = i - 1;
            //如果key比当前数小，则将当前数向后移
            while (j >= 0 && key < nums[j]) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 8, 6};
        insertSort(nums);
    }
}
