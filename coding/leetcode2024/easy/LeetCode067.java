package leetcode2024.easy;

/**
 * @author yuyunlong
 * @date 2024/10/5 23:00
 * @description 67. 二进制求和
 *
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 */
public class LeetCode067 {

    //模拟二进制计算
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }
        boolean flag = false;
        StringBuffer result = new StringBuffer();
        int indexA = a.length() - 1, indexB = b.length() - 1;
        while (indexA >= 0 || indexB >= 0) {
            char chA = '0', chB = '0';
            if (indexA >= 0) {
                chA = a.charAt(indexA);
            }
            if (indexB >= 0) {
                chB = b.charAt(indexB);
            }
            //求和
            if (flag) {
                if (chA == '1' && chB == '1') {
                    result.append("1");
                    flag = true;
                } else if (chA == '1' || chB == '1') {
                    result.append("0");
                    flag = true;
                } else {
                    result.append("1");
                    flag = false;
                }
            } else {
                if (chA == '1' && chB == '1') {
                    result.append("0");
                    flag = true;
                } else if (chA == '1' || chB == '1') {
                    result.append("1");
                    flag = false;
                } else {
                    result.append("0");
                    flag = false;
                }
            }
            indexA--;
            indexB--;
        }

        //进位
        if (flag) {
            result.append("1");
        }
        return result.reverse().toString();
    }
}
