package easy;
/**
 * 
 * @author lz
 * @date 2021/08/16 22:29
 **/
public class _58_最后一个单词的长度 {

    public static void main(String[] args) {
        String s = "luffy is still joyboy";
        int res=lengthOfLastWord(s);
    }

    public static int lengthOfLastWord(String s) {
        int len=0;
        for(int i=s.length()-1;i>=0;i--) {
            // 使用len作为开始标志位
            if(len==0 && s.charAt(i)==' ') {
                continue;
            }
            if(s.charAt(i)==' ') {
                break;
            }else {
                len++;
            }
        }
        return len;
    }
}
