package leetcode2024.medium;

/**
 * @author yuyunlong
 * @date 2024/9/22 14:16
 * @description 172. 阶乘后的零
 */
public class LeetCode172 {

    //看里面2 * 5 的组合个数有多少个就行
    public int trailingZeroes(int n) {
        int num5 = 0;
        for (int i = 5; i <= n; i += 5) {
            int temp = i;
            while (temp % 5 == 0) {
                temp /= 5;
                num5++;
            }
        }
        return num5;
    }

}
