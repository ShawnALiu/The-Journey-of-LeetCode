package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author lz
 * @date 2021/08/14 23:58
 **/
public class _56_合并区间 {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] res=merge(intervals);
    }

    public static int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        // 按左端点对数组排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        //合并
        for (int i=0;i<intervals.length;i++) {
            int left=intervals[i][0],right=intervals[i][1];
            //首先查看有没有交集，没有的话，添加当前数组
            if(res.size()==0 || res.get(res.size()-1)[1]<left) {
                res.add(new int[]{left,right});
            }else {
                int preRight=res.get(res.size()-1)[1];
                res.get(res.size()-1)[1]=Math.max(preRight,right);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
