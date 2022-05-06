package medium;

/**
 * @author lz
 * @date 2021/10/25 23:05
 **/
public class _96_不同的二叉搜索树 {

    public static void main(String[] args) {
        int n = 3;
        int res = numTrees(n);
    }

    /**
     * 给定一个有序序列 1,...,n-1,n，为了构建出一棵二叉搜索树，我们可以遍历每个数字 i，
     * 将该数字作为树根，将 1,...,i-1 序列作为左子树，将 (i+1),...,n 序列作为右子树。
     * 接着我们可以按照同样的方式递归构建左子树和右子树。
     * <p>
     * 一、题目要求是计算不同二叉搜索树的个数。为此，我们可以定义两个函数：
     * 1. G(n): 长度为 n 的序列能构成的不同二叉搜索树的个数。
     * 2. F(i, n) 以 i 为根、序列长度为 n 的不同二叉搜索树个数 (1 \leq i \leq n)(1≤i≤n)。
     * 则 -> G(n) = sum(F(i, n)),  2<=i<=n
     * G(0)=1, G(1)=1
     * <p>
     * 二、计算 F(i, n)
     * F(i, n) = G(i-1) * G(n - i)
     * <p>
     * 三、递归公式
     * G(n) = sum(G(i-1) * G(n - i)),  2<=i<=n
     *
     * @param n 序列长度
     * @return 二叉搜索树的个数
     */
    public static int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; i++) {      // 从 G(2)计算到 G(n)
            for (int j = 1; j <= i; j++) {  // 按递归公式计算 G(i)
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

    // 方法2：数学求解出递归公式
}
