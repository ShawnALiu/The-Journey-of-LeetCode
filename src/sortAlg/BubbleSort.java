package sortAlg;

/**
 * 比较n次，每次和前面的数比较，将最大的冒到最后
 * 每次比较完，后面的数是有序的
 *
 * @author lz
 * @date 2023/07/10 23:13
 **/
public class BubbleSort {

    public static void bubbleSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                if (nums[j] < nums[j - 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 8, 6};
        bubbleSort(nums);
    }

}
