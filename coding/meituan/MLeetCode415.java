package meituan;

/**
 * @author yuyunlong
 * @date 2021/6/8 10:10 上午
 * @description 字符串相加
 */
public class MLeetCode415 {

    public String addStrings(String num1, String num2) {
        int len1 = num1.length() - 1, len2 = num2.length() - 1, extra = 0;
        StringBuffer sb = new StringBuffer();
        while (len1 >= 0 || len2 >= 0 || extra != 0) {
            int x = len1 >= 0 ? num1.charAt(len1) - '0' : 0;
            int y = len2 >= 0 ? num2.charAt(len2) - '0' : 0;
            int add = x + y + extra;
            sb.append(add % 10);
            extra = add / 10;
            len1--;
            len2--;
        }
        return sb.reverse().toString();

    }
}
