package leetcode2024.medium;

/**
 * @author yuyunlong
 * @date 2024/9/21 16:10
 * @description 66. 加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
public class LeetCode066 {

    //从末尾开始遍历，注意进位，以及最后是否需要进位就行
    public int[] plusOne(int[] digits) {
        if (digits == null) {
            return null;
        }

        boolean flag = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (flag || i == digits.length - 1) {
                digits[i]++;
            }
            if (digits[i] >= 10) {
                digits[i] = digits[i] % 10;
                flag = true;
            } else {
                flag = false;
            }
        }
        //注意进位
        if (flag) {
            int[] newArray = new int[digits.length + 1];
            System.arraycopy(digits, 0, newArray, 1, digits.length);
            newArray[0] = 1;
            return newArray;
        }
        return digits;
    }
}
