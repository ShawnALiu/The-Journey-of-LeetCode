package easy;

/**
 * 
 * @author lz
 * @date 2021/07/20 22:25
 **/
public class _26_删除有序数组中的重复项 {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int res = removeDuplicates(nums);
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int toTravel = 1, toInsert = 1;
        for (; toTravel < nums.length; toTravel++) {
            if (nums[toTravel] != nums[toInsert - 1]) {
                nums[toInsert++] = nums[toTravel];
            }

        }
        return toInsert;
    }
}
