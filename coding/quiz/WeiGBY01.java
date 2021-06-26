package quiz;

/**
 * @author yuyunlong
 * @date 2021/6/14 1:19 下午
 * @description 微观博弈笔试题
 */
public class WeiGBY01 {
    /**
     * 旋转字符串
     * @param A string字符串
     * @param B string字符串
     * @return bool布尔型
     */
    public boolean solve (String A, String B) {
        // write code here
        for (int i = 0; i < A.length(); i++) {
            if (B.equals(revol(A, i))) {
                return true;
            }
        }
        return false;

    }

    private String revol(String s, int x) {
        //字符串旋转
        String l1 = s.substring(0, x);
        String l2 = s.substring(x, s.length());
        return l2 + l1;
    }
}
