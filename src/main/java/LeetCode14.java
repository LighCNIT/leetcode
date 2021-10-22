/**
 * @author dell
 * @version 1.0
 * @description: 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串""。
 *
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/10/14 10:55
 */
public class LeetCode14 {

	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) return "";
		String first = strs[0];//取出第一个作为初始比较的串
		for (int i = 1; i < strs.length; i++) {
			int j = 0;
			for (; j < first.length() && j < strs[i].length(); j++) {
				if (first.charAt(j) != strs[i].charAt(j)) {
					break;
				}
			}
			first = first.substring(0, j);
			if (first.equals("")) return "";
		}
		return first;
	}

	public static void main(String[] args) {
		System.out.println(new LeetCode14().longestCommonPrefix(new String[]{"flower","flow","flight"}));
	}
}
