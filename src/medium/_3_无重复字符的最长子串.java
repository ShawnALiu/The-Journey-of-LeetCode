package medium;

import java.util.HashSet;
import java.util.Set;

public class _3_无重复字符的最长子串 {

    public static void main(String[] args) {
        String s = "au";
        int res = lengthOfLongestSubstring(s);

    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1)
            return s.length();
        Set exist = new HashSet();
        int longest = 0, left = 0, right = 0;

        while (right < s.length()) {
            if (exist.contains(s.charAt(right))) {
                while (exist.contains(s.charAt(right))) {
                    exist.remove(s.charAt(left));
                    left++;
                }
            }
            longest = Math.max(longest, right - left + 1);
            exist.add(s.charAt(right));
            right++;
        }
        return longest;
    }
}
