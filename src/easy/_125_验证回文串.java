package easy;

/**
 * @author lz
 * @date 2022/07/10 20:54
 **/
public class _125_验证回文串 {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean ret = isPalindrome(s);
    }


    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (!isLetter(s.charAt(left))) {
                left++;
                if (left >= s.length()) {
                    return true;
                }
            }
            while (!isLetter(s.charAt(right))) {
                right--;
                if (right < 0) {
                    return true;
                }
            }
            if (!equasIgnoreCase(s.charAt(left), s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isLetter(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        }
        if (c >= 'A' && c <= 'Z') {
            return true;
        }
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }

    public static boolean equasIgnoreCase(char a, char b) {
        a = trans(a);
        b = trans(b);
        return a == b;
    }

    public static char trans(char c) {
        if (c >= 'a' && c <= 'z') {
            return c;
        }
        if (c >= 'A' && c <= 'Z') {
            return (char) (c - 'A' + 'a');
        }
        return c;
    }
}
