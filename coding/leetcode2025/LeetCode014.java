package leetcode2025;

/**
 * @author yuyunlong
 * @date 2025/7/26 15:05
 * @description
 */
public class LeetCode014 {

    //初始化ans为第一个字符串，往后两两比较得到两个字符串的最长公共前缀，即为新的ans
    //遍历到最后ans为结果，或者中间ans为空，则不存在
    public String longestCommonPrefix(String[] strs) {
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String nextStr = strs[i];
            StringBuffer stringBuffer = new StringBuffer();
            for (int j = 0; j < nextStr.length() && j < ans.length(); j++) {
                if (ans.charAt(j) == nextStr.charAt(j)) {
                    stringBuffer.append(ans.charAt(j));
                } else {
                    break;
                }
            }
            if (stringBuffer.length() == 0) {
                return "";
            }
            ans = stringBuffer.toString();
        }
        return ans;
    }
}
