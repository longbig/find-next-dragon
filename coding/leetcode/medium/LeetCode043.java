package leetcode.medium;

/**
 * @author yuyunlong
 * @date 2021/6/12 12:58 下午
 * @description 字符串相乘
 */
public class LeetCode043 {

    //优化的方法，用一维数组存储结果，最后转字符串
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length(), n = num2.length();
        int[] array = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            int extra = 0;
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                int sum = x * y + array[i + j + 1];
                array[i + j + 1] = sum % 10;
                array[i + j] += sum / 10;
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length; i++) {
            if (i == 0 && array[i] == 0) {
                continue;
            }
            sb.append(array[i]);
        }
        return sb.toString();
    }


        public String multiply1(String num1, String num2) {
        //传统方法, 相乘相加
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length(), n = num2.length();

        String sb2 = "0";
        for (int i = m - 1; i >= 0; i--) {
            StringBuffer sb = new StringBuffer();
            int carry = 0;
            for (int j = m - 1; j > i; j--) {
                sb.append('0');
            }

            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                int sum = x * y + carry;

                sb.append(sum % 10);
                carry = sum / 10;
            }
            if (carry != 0) {
                sb.append(carry % 10);
            }


            sb2 = addString(sb2, sb.reverse().toString());
        }

        return sb2;

    }

    private String addString(String s1, String s2) {
        int len1 = s1.length() - 1, len2 = s2.length() - 1;
        int carry = 0;
        StringBuffer re = new StringBuffer();
        while (len1 >= 0 || len2 >= 0 || carry != 0) {
            int x = len1 < 0 ? 0 : s1.charAt(len1) - '0';
            int y = len2 < 0 ? 0 : s2.charAt(len2) - '0';
            int sum = x + y + carry;
            re.append(sum % 10);
            carry = sum / 10;
            len1--;
            len2--;
        }
        String rest = re.reverse().toString();
        return rest;
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        LeetCode043 test = new LeetCode043();
        System.out.println(test.multiply(num1, num2));
    }
}
