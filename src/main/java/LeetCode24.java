/**
 * @author dell
 * @version 1.0
 * @description: 两两交换链表中的节点
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1]
 *
 * https://lyl0724.github.io/2020/01/25/1/
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/10/22 11:02
 */
public class LeetCode24 {
	static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
		public static ListNode swapPairs(ListNode head) {
			if (head == null || head.next == null){ // 终止条件
				return head;
			}
			// 这里递归调用。可以想象成三个节点 head，next，swapPairs（next.next）
			// 其实就是交换三个节点中的 head，next这两个节点并返回正确的值就行了
			ListNode next = head.next;
			head.next = swapPairs(next.next);
			next.next = head;
			return next;
		}

		public static void main(String[] args) {
			swapPairs(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4)))));
		}
	}

}
