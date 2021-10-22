/**
 * @author dell
 * @version 1.0
 * @description: 给你一个字符串 s，找到 s 中最长的回文子串。
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 * 输入：s = "ac"
 * 输出："a"
 *
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/10/12 10:24
 */
public class LeetCode5 {

	/**
	 * @title
	 * @description 思路：这里可以使用动态规划算法来解决
	 * 三个步骤： 1.问题拆解  当一个子串是回文串的时候，将其首尾字母去除仍是回文串（长度大于2）
	 *          2.状态定义   我们可以用P（i，j）表示字符串s的i到j个字母组成的串 P（i，j）注意边界条件
	 *          3.递推方程  所以满足P（i，j）是一个回文串的方程就出来了
	 *          P（i，j） = P（i+1，j-1） && S[i] == S[j]
	 *   时间复杂度 O（n²）
	 * @author admin
	 * @updateTime 2021/10/12 10:59
	 * @throws
	 */
	public String longestPalindrome(String s) {
		int n = s.length();
		int start = 0, max = 1;
		boolean[][] P = new boolean[n][n];
		for (int j = 0; j < n; ++j) { //循环递推
			for (int i = 0; i <= j; ++i) {
				if (j - i < 2) {
					P[i][j] = s.charAt(i) == s.charAt(j);
				} else {
					P[i][j] = P[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
				}
				if (P[i][j] && j - i + 1 > max) {
					max = j - i + 1;
					start = i;
				}
			}
		}
		return s.substring(start, start + max);
	}

	public static void main(String[] args) {
		System.out.println(new LeetCode5().longestPalindrome("12321121"));
	}
}
