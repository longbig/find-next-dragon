package leetcode2024.compitetion.week411;

/**
 * @author yuyunlong
 * @date 2024/8/18 10:31
 * @description 1. 统计满足 K 约束的子字符串数量 I
 *
 * 给你一个 二进制 字符串 s 和一个整数 k。
 *
 * 如果一个 二进制字符串 满足以下任一条件，则认为该字符串满足 k 约束：
 *
 * 字符串中 0 的数量最多为 k。
 * 字符串中 1 的数量最多为 k。
 * 返回一个整数，表示 s 的所有满足 k 约束 的
 * 子字符串
 * 的数量。
 */
public class Competition411Q1 {

    public int countKConstraintSubstrings(String s, int k) {
        char[] array = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (check(array, i, j, k)) {
                    sum++;
                }
            }
        }
        return sum;
    }

    private boolean check(char[] array, int i, int j, int k) {
        int count0 = 0, count1 = 0;
        for (int zz = i; zz <= j; zz++) {
            if (array[zz] == '0') count0++;
            if (array[zz] == '1') count1++;
        }
        return count0 <= k || count1 <= k;
    }

    public static void main(String[] args) {
        Competition411Q1 test = new Competition411Q1();
        String s = "11111";
        int k = 1;
        int result = test.countKConstraintSubstrings(s, k);
        System.out.println(result);
    }
}
