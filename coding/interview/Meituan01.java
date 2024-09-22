package interview;

import java.util.Random;

/**
 * @author yuyunlong
 * @date 2024/9/21 14:59
 * @description 一个数组，随机打乱元素位置，不能在原位置，要求时间复杂度O(N)，空间复杂度O(1)
 */
public class Meituan01 {

    //解法：使用 Fisher-Yates 洗牌来确保所有元素都被随机打乱。
    //在洗牌过程中，确保每个元素不会被放回到原位置上。
    public static void shuffle(int[] arr) {
        Random random = new Random();

        for (int i = arr.length - 1; i >= 0; i--) {
            int j = random.nextInt(i + 1);
            // 确保每个元素不会在原来的位置
            if (j == i) {
                // 如果选择的下标和当前位置相同，选择另一个下标，确保不会是原位置
                j = (j + 1) % (i + 1);
            }
            //swap
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        shuffle(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
