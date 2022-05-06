package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author lz
 * @date 2021/07/21 21:31
 **/
public class _30_串联所有单词的子串 {
    public static void main(String[] args) {
        String s = "barfoofoobarthefoobarman";
        String[] words = {"bar", "foo", "the"};
        List<Integer> res = findSubstring(s, words);
    }

    // 滑动窗口，与经典题不同的是，这里以单词为基本单位,且单词的长度都一样
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        // 定义窗口
        Map<String, Integer> need = new HashMap<>(), window = new HashMap<>();
        // 统计
        int wordNum = words.length;
        int wordLength = words[0].length();
        for (String s1 : words) {
            need.put(s1, need.getOrDefault(s1, 0) + 1);
        }
        // 开始滑动窗口
        for (int i = 0; i < wordLength; i++) {
            window.clear();
            int left = i, right = i, valid = 0;
            while (right + wordLength <= s.length()) {
                String tmpWord = s.substring(right, right + wordLength);
                right += wordLength;
                if (need.containsKey(tmpWord)) {
                    window.put(tmpWord, window.getOrDefault(tmpWord, 0) + 1);
                    if (window.get(tmpWord).equals(need.get(tmpWord))) {
                        valid++;
                    }
                }
                // 判断是不是长度已经是所有单词的和了，此时即可判断是不是个单词的串联
                while (right - left == wordLength * wordNum) {
                    // 是
                    if (valid == need.size()) {
                        res.add(left);
                    }
                    // 不是，则移动left一个单词的长度,继续向后判断
                    tmpWord = s.substring(left, left + wordLength);
                    left += wordLength;
                    if (window.containsKey(tmpWord)) {
                        // 先判断是不是相等，如果相等，那么left在移动后，就不等了
                        // valid就需要减1了
                        if (window.get(tmpWord).equals(need.get(tmpWord))) {
                            valid--;
                        }
                        // 得前面相等判断完，才能减
                        window.put(tmpWord, window.get(tmpWord) - 1);
                    }
                }
            }
        }
        return res;
    }
}
