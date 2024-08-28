package leetcode2024.compitetion.week411;

/**
 * @author yuyunlong
 * @date 2024/8/18 11:22
 * @description Q3. 找出最大的 N 位 K 回文数
 * 给你两个 正整数 n 和 k。
 *
 * 如果整数 x 满足以下全部条件，则该整数是一个 k 回文数：
 *
 * x 是一个
 * 回文数
 * 。
 * x 可以被 k 整除。
 * 以字符串形式返回 最大的  n 位 k 回文数。
 *
 * 注意，该整数 不 含前导零。
 */
public class Competition411Q3 {

    public String largestPalindrome(int n, int k) {
        if (n == 1) {
            for (int i = 9; i > 0; i--) {
                if (i % k == 0) return String.valueOf(i);
            }
            return "";
        }

        StringBuilder left = new StringBuilder();
        for (int i = 0; i < (n + 1) / 2; i++) {
            left.append('9');
        }

        while (left.length() > 0) {
            String palindrome = createPalindrome(left.toString(), n);
            if (isDivisibleByK(palindrome, k)) {
                return palindrome;
            }
            decrementLeft(left);
        }

        return "";
    }

    private String createPalindrome(String left, int n) {
        StringBuilder result = new StringBuilder(left);
        int startIndex = (n % 2 == 0) ? 0 : 1;
        for (int i = left.length() - 1 - startIndex; i >= 0; i--) {
            result.append(left.charAt(i));
        }
        return result.toString();
    }

    private boolean isDivisibleByK(String num, int k) {
        int remainder = 0;
        for (char c : num.toCharArray()) {
            remainder = (remainder * 10 + (c - '0')) % k;
        }
        return remainder == 0;
    }

    private void decrementLeft(StringBuilder left) {
        int i = left.length() - 1;
        while (i >= 0 && left.charAt(i) == '0') {
            left.setCharAt(i, '9');
            i--;
        }
        if (i >= 0) {
            left.setCharAt(i, (char) (left.charAt(i) - 1));
        } else {
            left.deleteCharAt(0);
        }
    }

    public static void main(String[] args) {
        Competition411Q3 competition411Q3 = new Competition411Q3();
        String result = competition411Q3.largestPalindrome(15, 2);
        System.out.println(result);
    }
}
