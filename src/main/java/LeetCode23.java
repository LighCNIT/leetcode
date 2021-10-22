import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author dell
 * @version 1.0
 * @description: 合并K个升序链表
 *
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 *
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：lists = [[]]
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/10/21 12:23
 */
public class LeetCode23 {

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
	}

	/**
	 * @title 
	 * @description  此方法利用的时优先级队列的特性： 因为优先级队列 本质上是一个二叉小顶堆。可以用一棵完全二叉树表示（任意一个非叶子节点的权值，都不大于其左右子节点的权值）
	 *
	 * 此题的思路是 动态构建一个优先级队列，然后每次调用poll函数取出并删除堆顶元素（因为堆本身是有序的），然后继续构建新堆，取出堆顶元素，取出直到堆为空。这个时候就是有序的了
	 * @author admin 
	 * @updateTime 2021/10/21 12:30 
	 * @throws 
	 */
	public static ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0) return null;
		ListNode dummyNode = new ListNode(0);
		ListNode curr = dummyNode;
		PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}
		});
		for (ListNode listNode : lists) {
			if (listNode == null) continue;
			priorityQueue.add(listNode);
		}

		while (!priorityQueue.isEmpty()) {
			ListNode nextNode = priorityQueue.poll();  // 获取并删除堆首元素
			curr.next = nextNode;
			curr = curr.next;
			if (nextNode.next != null) {
				priorityQueue.add(nextNode.next);
			}
		}
		return dummyNode.next;
	}

	public static void main(String[] args) {
		//  [[1,4,5],[1,3,4],[2,6]]
		ListNode[] listNodes = new ListNode[]{new ListNode(1,new ListNode(4,new ListNode(5))),new ListNode(1,new ListNode(3,new ListNode(4)))
				,new ListNode(2,new ListNode(6))};

		mergeKLists(listNodes);
	}
}
