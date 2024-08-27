package leetcode2021;

/**
 * @author yuyunlong
 * @date 2020/8/2 10:48 下午
 * @description 罗马数字转整数
 */
public class LeetCode13 {
    /**
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * <p>
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     *
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        int result = 0;
        char ch = s.charAt(0);
        int preValue = getValue(ch);

        for (int i = 1; i < s.length(); i++) {
            int value = getValue(s.charAt(i));
            if (preValue < value) {
                result -= preValue;
            }else {
                result += preValue;
            }
            preValue = value;
        }
        result += preValue;
        return result;
    }

    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }


    public static void main(String[] args) {
        LeetCode13 leetCode13 = new LeetCode13();
        int res = leetCode13.romanToInt("MCMXCIV");
        System.out.println(res);
    }
}
