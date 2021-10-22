import java.util.Stack;

/**
 * @author dell
 * @version 1.0
 * @description: 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。

 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 * 示例2：
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例3：
 * 输入：s = "(]"
 * 输出：false
 * 示例4：
 * 输入：s = "([)]"
 * 输出：false
 * 示例5：
 * 输入：s = "{[]}"
 * 输出：true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/10/20 10:09
 */
public class LeetCode20 {

	/**
	 * @title
	 * @description 思路：
	 * 1循环便利字符串，然后构建一个栈，遇见{ ，[ ,( 这边就直接进栈 。（反向）
	 * 2然后判断栈是否为空，空表示只有 },],)右边元素显然不成立；然后进行出栈，出栈的时候判断是否和字符串相等。因为栈是满足先进后出的原则
	 *
	 * 时间复杂度为O（n）
	 * @author admin
	 * @updateTime 2021/10/20 10:19
	 * @throws
	 */
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()){
			if (c == '{') stack.push('}');
			else if (c == '[') stack.push(']');
			else if (c == '(') stack.push(')');
			else if (stack.isEmpty() || c != stack.pop()) return false; // 这里意味着前面有一部分成对，后面没有了。或者stack本身就是空的
		}
		return stack.isEmpty(); // 空表示有成对的
	}

	public static void main(String[] args) {
		System.out.println(new LeetCode20().isValid("(()())"));
	}
}
