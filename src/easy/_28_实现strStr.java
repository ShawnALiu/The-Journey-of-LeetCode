package easy;

/**
 * 
 * @author lz
 * @date 2021/07/20 22:39
 **/
public class _28_实现strStr {
    public static void main(String[] args) {
        String haystack = "", needle = "";
        int res = strStr(haystack, needle);
    }

    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
