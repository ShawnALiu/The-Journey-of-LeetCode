package medium;

import java.util.Stack;

/**
 * @author lz
 * @date 2021/08/25 22:42
 **/
public class _71_简化路径 {

    public static void main(String[] args) {
        String path = "/home//foo/";
        String res = simplifyPath(path);
    }

    public static String simplifyPath(String path) {
        // 栈
        Stack<String> st = new Stack<>();
        // [关键]分割字符，例如"/a"会被分割成 {"", "a"}，会分割出空字符串
        String[] res = path.split("/");
        for (int i = 0; i < res.length; i++) {
            String s = res[i];
            if (s.equals(".") || s.equals("")) continue;
            else if (s.equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else {
                // 因为栈的原因，所以先对单个名字进行翻转
                StringBuilder tmpSb = new StringBuilder(s);
                tmpSb.reverse();
                st.push(tmpSb.toString());
            }
        }
        // 拼接
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.peek());
            st.pop();
            sb.append("/");
        }
        // 再对整体进行翻转
        sb.reverse();
        // 判空
        return sb.toString().equals("") ? "/" : sb.toString();
    }

}
