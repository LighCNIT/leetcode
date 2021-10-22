/**
 * @ClassName LeetCode10
 * @Description 正则匹配
 * 给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。
 *
 * 说明:
 *
 * s可能为空，且只包含从a-z的小写字母。
 * p可能为空，且只包含从a-z的小写字母，以及字符.和*。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author 李光华
 * @Date 2019/11/23 15:29
 **/
public class LeetCode10 {

    /**
     * @title
     * @description 思路：这道题显然是可以用动态规划来解决的。
     * DP[i][j]表示s的前i个是否能被p的前j个匹配
     * 这里需要讨论几种情况：
     * 1.如果p的第j个字符是小写字母 ： f[i][j] = f[i-1][j-1]继续往后匹配
     * 2.如果p的第j个字符是*： f[i][j]=f[i][j−2]
     * 3. 在任意情况下，只要 p[j]p[j] 是 .，那么 p[j]p[j] 一定成功匹配 ss 中的任意一个小写字母。
     * 还要注意边界条件 DP[0][0] = true,空是能匹配的
     * @author admin
     * @updateTime 2021/10/13 12:00
     * @throws
     */
    public  boolean isMatch(String s,String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] DP = new boolean[m + 1][n + 1];
        DP[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    DP[i][j] = DP[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        DP[i][j] = DP[i][j] || DP[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        DP[i][j] = DP[i - 1][j - 1];
                    }
                }
            }
        }
        return DP[m][n];
    }

    public  boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
