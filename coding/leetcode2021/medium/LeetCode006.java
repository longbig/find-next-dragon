package leetcode2021.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuyunlong
 * @date 2021/5/28 9:20 上午
 * @description Z字形变换
 */
public class LeetCode006 {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int maxRow = Math.min(s.length(), numRows) - 1;
        int nowRow = 0;
        List<StringBuilder> strList = new ArrayList<>();
        for (int i = 0; i <= maxRow; i++) {
            strList.add(new StringBuilder());
        }
        boolean down = true;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            StringBuilder stringBuilder = strList.get(nowRow);
            stringBuilder.append(ch);
            if (nowRow == maxRow) {
                down = false;
            } else if (nowRow == 0) {
                down = true;
            }
            nowRow = down ? nowRow + 1 : nowRow - 1;
        }
        String result = "";
        for (StringBuilder stringBuilder : strList) {
            result += stringBuilder.toString();
        }
        return result;
    }
}
