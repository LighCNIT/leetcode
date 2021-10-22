/**
 * @author dell
 * @version 1.0
 * @description:
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *  输入：l1 = [2,4,3], l2 = [5,6,4]
 *  输出：[7,0,8]
 *  解释：342 + 465 = 807.
 *  输入：l1 = [0], l2 = [0]
 *  输出：[0]
 *  输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 *  输出：[8,9,9,9,0,0,0,1]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/10/11 11:13
 */
public class TwoNumbers {

	class ListNode {
		int var;
		ListNode next;

		ListNode() {
		}

		ListNode(int var) {
			this.var = var;
		}

		ListNode(int var, ListNode next) {
			this.var = var;
			this.next = next;
		}

		public String toString(){
			if (this.next!=null){
				return var+","+ next;
			}
			return var+"";
		}
	}
	/**
	 * @description 思路： 这里显然要构造一个链表的数据结构,然后就是元素相加取整，大于10则取10的余数往前进位即可
	 * @author Ligh
	 * @updateTime 2021/10/11 11:32
	 * @throws
	 */
	public ListNode addTwoNumbers(ListNode l1,ListNode l2) {
		ListNode target = new ListNode(0);
		int carry = 0;
		ListNode curr = target;
		while (l1 != null || l2 != null || carry != 0) {
			int s = (l1 == null ? 0 : l1.var) + (l2 == null ? 0 : l2.var) + carry;
			carry = s / 10;
			curr.next = new ListNode(s % 10);
			curr = curr.next;
			l1 = l1 == null ? null : l1.next;
			l2 = l2 == null ? null : l2.next;
		}
		return target.next;
	}

	public static void main(String[] args) {
		TwoNumbers twoNumbers = new TwoNumbers();
		ListNode l1 = twoNumbers.new ListNode(9,twoNumbers.new ListNode(9,twoNumbers.new ListNode(9)));
		ListNode l2 = twoNumbers.new ListNode(9,twoNumbers.new ListNode(9,twoNumbers.new ListNode(9)));
		System.out.println(twoNumbers.addTwoNumbers(l1, l2).toString());
	}
}
