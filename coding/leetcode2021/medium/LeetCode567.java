package leetcode2021.medium;

/**
 * @author yuyunlong
 * @date 2021/2/10 8:34 下午
 * @description
 */
public class LeetCode567 {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() == 0 && s2.length() == 0) {
            return true;
        }
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] array1 = new int[26];
        int[] array2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            array1[s1.charAt(i) - 'a']++;
            array2[s2.charAt(i) - 'a']++;
        }

        int left = 0, right = s1.length() - 1;
        while (right < s2.length()) {
            if (checkTwo(array1, array2)) {
                return true;
            }
            array2[s2.charAt(left) - 'a']--;
            left++;
            right++;
            if (right < s2.length()) {
                array2[s2.charAt(right) - 'a']++;
            }
        }
        return false;
    }

    private boolean checkTwo(int[] array1, int[] array2) {
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidboaoo";
        LeetCode567 test = new LeetCode567();
        System.out.println(test.checkInclusion(s1, s2));
    }
}
