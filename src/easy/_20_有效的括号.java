package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * @author lz
 * @date 2021/07/16 22:08
 **/
public class _20_有效的括号 {
    public static void main(String[] args) {
        String s = "()[]{}";
        boolean res = isValid(s);
    }

    public static boolean isValid(String s) {
        Map<Character, Character> mp = new HashMap<Character, Character>() {
            {
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }
        };

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                st.push(s.charAt(i));
                continue;
            }
            if (!st.empty() && st.peek() == mp.get(s.charAt(i))) {
                st.pop();
            } else {
                return false;
            }
        }
        if (!st.empty())
            return false;
        return true;
    }
}
