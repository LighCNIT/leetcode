import java.util.ArrayList;
import java.util.List;

/**
 * @author dell
 * @version 1.0
 * @description: 括号生成
 *
 * 数字 n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 有效括号组合需满足：左括号必须以正确的顺序闭合。
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/10/20 11:26
 */
public class LeetCode22 {

	List<String> res = new ArrayList<>();

	public List<String> generateParenthesis(int n) {
		if (n <= 0) {
			return res;
		}
		getParenthesis("", n, n);
		return res;
	}

	/**
	 * @title
	 * @description 递归判断 str + "("
	 * @author admin
	 * @updateTime 2021/10/20 11:28
	 * @throws
	 */
	private void getParenthesis(String str, int left, int right) {
		if (left == 0 && right == 0) {
			res.add(str);
			return;
		}
		if (left == right) {
			//剩余左右括号数相等，下一个只能用左括号
			getParenthesis(str + "(", left - 1, right);
		} else if (left < right) {
			//剩余左括号小于右括号，下一个可以用左括号也可以用右括号
			if (left > 0) {
				getParenthesis(str + "(", left - 1, right);
			}
			getParenthesis(str + ")", left, right - 1);
		}
	}
}
