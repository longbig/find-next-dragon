package quiz;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yuyunlong
 * @date 2021/6/14 1:25 下午
 * @description
 */
public class WeiGBY02 {
    /**
     * find topK in two sorted array
     * @param arr1 int整型一维数组 the array1
     * @param arr2 int整型一维数组 the array2
     * @param k int整型 the k
     * @return int整型一维数组
     *  时间复杂度：O(k logk)
     */
    public int[] findTopKinTwoSortedArray (int[] arr1, int[] arr2, int k) {
        // write code here
        //大顶堆，长度为k
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int l1 = arr1.length - 1, l2 = arr2.length - 1;
        for (int i = 0; i < k; i++) {
            int x = arr1[l1 - i];
            for (int j = 0; j < k; j++) {
                int y = arr2[l2 - i];
                int sum = x + y;
                heap.add(sum);

            }
        }


//        for (int i = arr1.length - 1; i >= (arr1.length - k); i--) {
//            for (int j = arr2.length - 1; j >= (arr2.length - k); j--) {
//                int temp = arr1[i] + arr2[j];
//                heap.add(temp);
//
//            }
//
//        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 5, 7, 9, 11};
        int k = 4;
        WeiGBY02 test = new WeiGBY02();
        int[] re = test.findTopKinTwoSortedArray(arr1, arr2, k);
        for (int i = 0; i < re.length; i++) {
            System.out.println(re);
        }
    }
}
