import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @ClassName LongestSubstr
 * @Description 最长子串问题
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 * 示例1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 *     请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 *
 * @Author 李光华
 * @Date 2019/7/5 16:13
 **/
public class LongestSubstr {

    /**
     * @Description: 构建一个map存储每个字符的以及位置，
     *  发现有重复的则更改value的值遍历完最后字符就可以得到最大子串长度
     *  时间复杂度度 O(n)
     * @param str
     * @return
     * @author 李光华
     * @date 2020/6/3  15:55
     */
    public static int getMaxSubstr(String str){
        Map<Character,Integer> map = Maps.newHashMap();
        int n = str.length(),ans = 0;
        for (int start=0,end=0;end<n;end++){
            char aa = str.charAt(end);
            if (map.containsKey(aa)){
                start = Math.max(map.get(aa),start);
            }
            ans = Math.max(ans,end-start+1);
            map.put(str.charAt(end),end+1);
        }
        System.out.println(map);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(getMaxSubstr("abcdabbdcefb"));
    }
}
