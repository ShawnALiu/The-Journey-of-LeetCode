package hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lz
 * @date 2021/08/30 23:26
 **/
public class _76_最小覆盖子串 {

    public static void main(String[] args) {
        String s = "aa", t = "aa";
        String res = minWindow(s, t);
    }

    public static String minWindow(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();


        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (int i = 0; i < lenT; i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }

        char c;
        int minLen = Integer.MAX_VALUE;
        String minStr = null;
        int left = 0, right = 0, valid = 0;
        while (right < lenS) {
            c = s.charAt(right++);
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 不能是 valid == t.length()，因为 t 中会有重复
            while (valid == need.size()) {
                if (right - left < minLen) {
                    minLen = right - left;
                    minStr = s.substring(left, right);
                }
                c = s.charAt(left++);
                if (need.containsKey(c)) {
                    if (window.get(c).equals(need.get(c))) {
                        valid--;
                    }
                    window.put(c, window.get(c) - 1);
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : minStr;
    }
}
