package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lz
 * @date 2021/09/29 21:27
 **/
public class SortAlgTest {

    public static void bubbleSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 1; j < n - i; j++) {
                if (nums[j] < nums[j - 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = tmp;
                }
            }
        }
    }

    public static void insertSort(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int toInsert = i - 1;
            int key = nums[i];
            while (toInsert >= 0 && nums[toInsert] >= key) {
                nums[toInsert + 1] = nums[toInsert];
                toInsert--;
            }
            //需要+1
            nums[toInsert + 1] = key;
        }
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left, j = right, key = nums[left];
        while (i < j) {
            while (i < j && nums[j] >= key) j--;
            while (i < j && nums[i] <= key) i++;
            if (i < j) {
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
            }
        }
        // left 和 i 位置的数据交换
        nums[left] = nums[i];
        nums[i] = key;
        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
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

    private static void mergeTwo(int[] nums, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left, j = mid + 1, ind = 0;
        while (i <= mid || j <= right) {
            if (i > mid) {
                tmp[ind++] = nums[j++];
                continue;
            }
            if (j > right) {
                tmp[ind++] = nums[i++];
                continue;
            }
            if (nums[i] < nums[j]) {
                tmp[ind++] = nums[i++];
            } else {
                tmp[ind++] = nums[j++];
            }
        }
        for (int k = left; k <= right; k++) {
            nums[k] = tmp[k - left];
        }
    }

    public static void main(String[] args) {
        //int[] nums = {1, 3, 5, 4, 8, 6};
        //bubbleSort(nums);
//        insertSort(nums);
        //quickSort(nums, 0, nums.length - 1);
        //mergeSort(nums, 0, nums.length - 1);

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");

        for (String item : list) {
            if ("1".equals(item)) {
                list.remove(item);
            }
        }
    }

}
