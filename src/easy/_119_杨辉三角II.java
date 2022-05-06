package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author lz
 * @date 2022/01/05 22:15
 **/
public class _119_杨辉三角II {

    public static void main(String[] args) {
        int rowIndex = 3;
        List<Integer> res = getRow(rowIndex);
    }

    public static List<Integer> getRow(int rowIndex) {
        if (rowIndex <= 1) {
            return Collections.nCopies(rowIndex + 1, 1);
        }
        List<Integer> pre = getRow(rowIndex - 1);
        List<Integer> ret = new ArrayList<>(rowIndex + 1);
        ret.add(1);
        for (int i = 0; i < pre.size() - 1; i++) {
            ret.add(pre.get(i) + pre.get(i + 1));
        }
        ret.add(1);
        return ret;
    }

}
