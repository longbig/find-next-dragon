package leetcode2025;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuyunlong
 * @date 2025/7/30 23:55
 * @description
 */
public class LeetCode013 {

    //模拟，右边数比左边大的话，左边的数就取负数
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char[] array = s.toCharArray();
        int ans = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int curr = map.get(array[i]);
            if (curr < map.get(array[i + 1])) {
                ans -= curr;
            } else {
                ans += curr;
            }
        }
        ans += map.get(s.length() - 1);
        return ans;
    }
}
