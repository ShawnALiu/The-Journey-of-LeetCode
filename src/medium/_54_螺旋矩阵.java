package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author lz
 * @date 2021/08/10 23:50
 **/
public class _54_螺旋矩阵 {

    public static void main(String[] args) {
        int[][] matrix= {{1, 2, 3, 4},{5, 6, 7, 8},{9, 10, 11, 12}};
        List<Integer> res = spiralOrder(matrix);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<>();
        int m= matrix.length;
        int n=matrix[0].length;
        int left=0,right=n-1,top=0,bottom=m-1;
        while(left<=right && top<=bottom) {
            for(int col=left;col<=right;col++) {
                res.add(matrix[top][col]);
            }
            for(int row=top+1;row<=bottom;row++) {
                res.add(matrix[row][right]);
            }
            if(left<right && top < bottom) {
                for (int col=right-1;col>left;col--) {
                    res.add(matrix[bottom][col]);
                }
                for (int row=bottom;row>top;row--) {
                    res.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }
}
