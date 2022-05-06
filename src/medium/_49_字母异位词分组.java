package medium;

import java.util.*;

/**
 * 
 * @author lz
 * @date 2021/08/06 23:09
 **/
public class _49_字母异位词分组 {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = groupAnagrams(strs);
    }

    // 计数
    public static List<List<String>> groupAnagrams(String[] strs) {
        // 不能用int[]作为key，这样重复时无法识别
        // 也可以将出现了的字母和次数拼接起来作为键，比如a出现了3次，即a3
        Map<List<Integer>, List<String>> exist = new HashMap<>();
        for (String s : strs) {
            // 如果要初始化固定数目的0填充的数组，需要用到Collections.nCopies(n, o)
            // 否则List<Integer> mark = new ArrayList<>(n),只是设置了个初始容量，里面还是null
            List<Integer> mark = new ArrayList<>(Collections.nCopies(26, 0));
            for (int i = 0; i < s.length(); i++) {
                int ind = s.charAt(i) - 'a';
                mark.set(ind, mark.get(ind) + 1);
            }
            // 记得调用getOrDefault方法，不用提前判断键在不在
            List<String> list = exist.getOrDefault(mark, new ArrayList<>());
            list.add(s);
            // 更新map，如果存在，将会替换里面旧的（k,v）
            exist.put(mark, list);
        }
        return new ArrayList<>(exist.values());
    }

    // 对字符串排序，排序后的一定相等，
    public static List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

}
