package leetcode2021.compitetion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yuyunlong
 * @date 2020/8/23 10:54 上午
 * @description
 */
public class LeetCode5495 {
    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> result = new ArrayList<>();
        if (rounds.length == 1) {
            result.add(rounds[0]);
            return result;
        }
        int[] anotherR = new int[rounds.length];
        int start = rounds[0], end = rounds[1];
        for (int i = 1; i < rounds.length - 1; i++) {
            start = rounds[i - 1];
            end = rounds[i];
            handle(anotherR, start, end - 1);
        }
//        anotherR[end]++;
        int max = 0;
        for (int i = 0; i < anotherR.length; i++) {
            if (anotherR[i] > max) {
                max = anotherR[i];
            }
        }
        for (int i = 0; i < anotherR.length; i++) {
            if (anotherR[i] == max) {
                result.add(i);
            }
        }
        Collections.sort(result);
        return result;
    }

    public void handle(int[] another, int start, int end) {
        for (int i = start; i <= end; i++) {
            another[i]++;
        }
    }


}
