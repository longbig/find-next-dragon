package leetcode2021.easy;

import java.util.*;

/**
 * @author yuyunlong
 * @date 2021/6/9 11:40 下午
 * @description 前K个高频元素
 */
public class LeetCode347 {

    //topK问题借助堆解决，这道题就是求 出现次数数组 中top k个元素问题
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        //小顶堆，第一个是元素值，第二个是次数
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (heap.size() == k) {
                int[] temp = heap.peek();
                if (entry.getValue() > temp[1]) {
                    heap.poll();
                    heap.offer(new int[]{entry.getKey(), entry.getValue()});
                }
            } else {
                heap.offer(new int[]{entry.getKey(), entry.getValue()});
            }

        }
        int[] result = new int[heap.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = heap.poll()[0];
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode347 test = new LeetCode347();
        int[] nums = new int[]{1,1,1,2,2,3};
        int k = 2;
        int[] result = test.topKFrequent(nums, k);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }



    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            Integer value = hashMap.get(key);
            if (value != null) {
                value++;
                hashMap.put(key, value);
            } else {
                hashMap.put(key, 1);
            }
        }

        for (int i = k; i > 0; i--) {
            int max = 0, key = 0;
            for (Map.Entry<Integer, Integer> integerIntegerEntry : hashMap.entrySet()) {
                if (integerIntegerEntry.getValue() > max) {
                    key = integerIntegerEntry.getKey();
                    max = integerIntegerEntry.getValue();
                }
            }
            list.add(key);
            hashMap.remove(key);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;

    }
}
