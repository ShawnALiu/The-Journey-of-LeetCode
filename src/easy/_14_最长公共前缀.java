package easy;

public class _14_最长公共前缀 {

    public static void main(String[] args) {
        String[] strs = {"dog", "racecar", "car"};
        String res = longestCommonPrefix(strs);
    }

    public static String longestCommonPrefix(String[] strs) {
        int count = 0;
        if (strs.length == 0)
            return "";
        for (int j = 0;; j++) {
            for (int i = 0; i < strs.length; i++) {
                // 如果 i!=0，程序走到这已经保证了strs[0].charAt(j)是有效的
                if (j >= strs[i].length() || strs[i].charAt(j) != strs[0].charAt(j)) {
                    return strs[0].substring(0, count);
                }
            }
            count++;
        }
    }

}
