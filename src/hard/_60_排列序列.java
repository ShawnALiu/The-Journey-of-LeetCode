package hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * @author lz
 * @date 2021/08/16 23:01
 **/
public class _60_排列序列 {

    public static void main(String[] args) {
        int n = 3, k = 2;
        String res= getPermutation(n,k);
    }

    public static String getPermutation(int n, int k) {
        StringBuilder sb=new StringBuilder();
        TreeSet<Integer> nums = new TreeSet<>();
        for(int i=1;i<=n;i++) {
            nums.add(i);
        }
        while (k>0) {
            Integer cur;
            Long fac = factorial(nums.size()-1);
            if(k>fac) {
                int index=0;
                while(k>fac) {
                    k-=fac;
                    index++;
                }
                List<Integer> list = new ArrayList<>(nums); //
                cur=list.get(index);  // 即可获取对应下标为index的元素
                sb.append(cur);
                nums.remove(cur);
            }else if(k==fac) {
                cur = nums.pollFirst();
                sb.append(cur);
                break;
            } else{
                cur = nums.pollFirst();
                sb.append(cur);
            }
        }
        //拼接剩下的,由大到小
        //因为k=0,说明剩下的数需要排成最大的数字
        while (nums.size()>0) {
            sb.append(nums.pollLast());
        }
        return sb.toString();
    }

    public static Long factorial(int n) {
        if(n==1 || n==0)
            return 1L;
        return n*factorial(n-1);
    }
}
