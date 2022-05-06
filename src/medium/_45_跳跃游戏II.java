package medium;

/**
 * 
 * @author lz
 * @date 2021/08/03 22:25
 **/
public class _45_跳跃游戏II {
    public static void main(String[] args) {
        int[] nums = {2, 3, 0, 1, 4};
        int res = jump(nums);
    }

    public static int jump(int[] nums) {
        // 1.如果长度为1，则直接在终点，不需要走
        if (nums.length == 1) {
            return 0;
        }
        // 2.否则始终要走最后一步，到maxInd，因此step初始化为1，代表最后一步
        int curInd = 0, maxInd = nums[0], step = 1;
        // 3.循环条件为maxInd小于终点，因为题目的前提说了始终能到达终点
        while (maxInd < nums.length - 1) {
            // 4.记录下一步的起点和终点，遍历该段，更新下下步的maxInd
            int start = curInd, end = maxInd;
            for (int i = start; i <= end && i < nums.length; i++) {
                if (i + nums[i] > maxInd) {
                    maxInd = i + nums[i];
                    curInd = i;
                }
            }
            // 5.下一步走了，step++
            step++;
        }
        return step;
    }
}
