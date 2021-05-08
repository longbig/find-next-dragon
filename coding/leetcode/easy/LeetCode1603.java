package leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yuyunlong
 * @date 2021/3/19 11:47 下午
 * @description
 */
public class LeetCode1603 {
    private Map<Integer, Integer> hashMap;
    public LeetCode1603(int big, int medium, int small) {
        hashMap = new LinkedHashMap<>();
        hashMap.put(1, big);
        hashMap.put(2, medium);
        hashMap.put(3, small);

    }

    public boolean addCar(int carType) {
       Integer value = hashMap.get(carType);
       if (value == null) {
           return false;
       }
       if (value > 0) {
           hashMap.put(carType, --value);
           return true;
       }
       return false;

    }
}
