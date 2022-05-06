package medium;
/**
 * 
 * @author lz
 * @date 2021/08/16 22:49
 **/
public class _59_螺旋矩阵II {

    public static void main(String[] args) {
        int n=3;
        int[][] res = generateMatrix(n);
    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int count=1;
        int top=0,bottom=n-1,left=0,right=n-1;
        while (top<=bottom && left <= right) {
            for(int col=left;col<=right;col++) {
                matrix[top][col]=count++;
            }
            for(int row=top+1;row<=bottom;row++) {
                matrix[row][right]=count++;
            }
            if(top<bottom && left < right) {
                for(int col=right-1;col>=left;col--) {
                    matrix[bottom][col]=count++;
                }
                for(int row=bottom-1;row>top;row--) {
                    matrix[row][left]=count++;
                }
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        return matrix;
    }
}
