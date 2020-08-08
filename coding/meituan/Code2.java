package meituan;

import java.util.Scanner;

/**
 * @author yuyunlong
 * @date 2020/8/8 4:25 下午
 * @description
 */
public class Code2 {

    public static void main(String[] args) {
        Scanner  scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] array = new int[n][];
        for (int i = 0; i < n; i++) {
            array[i][0] = scanner.nextInt();
            array[i][1] = scanner.nextInt();
        }
        handle(array, n);
    }

    public static void handle(int[][] array, int n) {
        int sumValue = 0;
        int settle = 0;

        for (int i = 0; i < n; i++) {
            int x = array[i][0];
            int y = array[i][1];
            if (x >= y) {
                sumValue += x;
                settle += (x - y);
            }
            if (x < y) {
                sumValue += x;
                settle += x;
            }
        }
        System.out.println(sumValue + " " + settle);
    }
}
