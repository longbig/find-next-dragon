package leetcode2021.compitetion;

/**
 * @author yuyunlong
 * @date 2021/1/10 10:50 上午
 * @description 解码异或数组
 */
public class LeetCode5649 {

    public int[] decode(int[] encoded, int first) {
        if (encoded.length == 0) {
            return null;
        }
        int decode[] = new int[encoded.length + 1];
        decode[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            int temp = Math.abs(encoded[i] ^ first);
            decode[i + 1] = temp;
            first = temp;
        }
        return decode;
    }

    public static void main(String[] args) {
        int[] encoded = new int[]{6};
        int first = 1;
        LeetCode5649 test = new LeetCode5649();
        int[] result = test.decode(encoded, first);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
