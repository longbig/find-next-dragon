package leetcode.hard;

import java.util.Arrays;


/**
 * @author yuyunlong
 * @date 2021/2/3 1:21 下午
 * @description 滑动窗口中位数问题
 */
public class LeetCode480 {

    public static void main(String[] args) {
        LeetCode480 leetCode480 = new LeetCode480();
        int[] nums = new int[]{1,4,2,3};
        int k = 4;
        double[] result = leetCode480.medianSlidingWindow(nums, k);
        for (double v : result) {
            System.out.println(v);
        }
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        int left = 0, right = k - 1;
        int[] numsB = Arrays.copyOf(nums, k);
        maoSort(numsB);

        while(right < nums.length) {
            System.out.print("now: ");
            for (int B : numsB) {
                System.out.print(B + ",");
            }
            System.out.println();
            result[left] = findMideum(numsB, k);
            removeLeft(numsB, nums[left]);
//            System.out.println("removeLeft: ");
//            for (int B : numsB) {
//                System.out.print(B + ",");
//            }
//            System.out.println();
            left++;
            right++;
            if (right >= nums.length) {
                break;
            }
            addRight(numsB, nums[right]);

//            System.out.println("addRight: ");
//            for (int B : numsB) {
//                System.out.print(B + ",");
//            }
//            System.out.println();

        }
        return result;


    }

    private void removeLeft(int[] numsB, int leftValue) {
        int index = 0;
        while(index < numsB.length && numsB[index] != leftValue) {
            index++;
        }
        if (index >= numsB.length) {
            return;
        }
        for (int i = index; i < numsB.length - 1; i++) {
            numsB[i] = numsB[i + 1];
        }
    }

    private void addRight(int[] numsB, int rightValue) {
        int index = 0;
        int i = 0;
        for (; i < numsB.length - 1; i++) {
            if (numsB[i] >= rightValue) {
                index = i;
                break;
            }
        }

        if (i == numsB.length - 1) {
            numsB[numsB.length - 1] = rightValue;
            return;
        }

        for (int j = numsB.length - 1; j > index; j--) {
            numsB[j] = numsB[j - 1];
        }
        numsB[index] = rightValue;
    }

    private double findMideum(int[] numsB, int k) {
        if (k % 2 == 1) {
            return numsB[k / 2];
        } else {
            double result = ((double) numsB[k / 2] + numsB[k / 2 - 1]) / 2;
            return result;
        }
    }

    private void maoSort(int[] nums) {
        int N = nums.length;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (nums[i] > nums[j]) {
                    swap(nums, i, j);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
