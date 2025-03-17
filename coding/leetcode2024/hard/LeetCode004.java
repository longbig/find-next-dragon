package leetcode2024.hard;

/**
 * @author yuyunlong
 * @date 2025/3/16 17:06
 * @description 寻找两个正序数组的中位数
 *
 * 算法逻辑
 *
 * 只需要找到合并后数组的中间位置的元素，不需要真正合并整个数组
 * 使用两个指针分别遍历数组A和数组B
 * 在每次迭代中，选择较小的元素前进
 * 遍历到中间位置时停止
 *
 * 这题要想看懂O(lg(m + n))时间复杂度的解法太难了！
 * 最后只能用O(m + n)时间复杂度的解法
 */
public class LeetCode004 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //定义两个指针，用于输出最后结果
        int m = nums1.length, n = nums2.length;
        int len = m + n;
        int left = -1, right = -1;
        int index1 = 0, index2 = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            //填充数组，获取中间的两个值
            if (index1 < m && (index2 >= n || nums1[index1] < nums2[index2])) {
                right = nums1[index1];
                index1++;
            } else {
                right = nums2[index2];
                index2++;
            }
        }
        if (len % 2 == 0) {
            return (left + right) / 2.0;
        }
        return right;
    }
}
