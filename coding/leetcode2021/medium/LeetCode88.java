package leetcode2021.medium;

/**
 * @author yuyunlong
 * @date 2021/2/6 8:48 下午
 * @description
 */
public class LeetCode88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1, index2 = n - 1;
        int indexRight = m + n - 1;

        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] >= nums2[index2]) {
                nums1[indexRight] = nums1[index1];
                index1--;
                indexRight--;
            } else {
                nums1[indexRight] = nums2[index2];
                index2--;
                indexRight--;
            }
        }

        while (index2 >= 0) {
            nums1[indexRight--] = nums2[index2--];
        }
    }

    public static void main(String[] args) {
        LeetCode88 test = new LeetCode88();
        int[] nums1 = new int[]{1,4,6,0,0,0};
        int[] nums2 = new int[]{2,5,7};
        test.merge(nums1, 3, nums2, 3);
        for (int i : nums1) {
            System.out.print(i + ",");

        }
    }
}
