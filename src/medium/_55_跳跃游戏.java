package medium;
/**
 * 
 * @author lz
 * @date 2021/08/14 23:46
 **/
public class _55_跳跃游戏 {

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        boolean res= canJump(nums);
    }

    public static boolean canJump(int[] nums) {
        int maxInd=0;
        for(int i=0;i< nums.length;i++) {
            if(maxInd>= nums.length-1) {
                return true;
            }
            if(i>maxInd) {
                return false;
            }
            maxInd=Math.max(maxInd,i+nums[i]);
        }
        return true;
    }

}
