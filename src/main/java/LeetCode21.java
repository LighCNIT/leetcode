/**
 * @author dell
 * @version 1.0
 * @description: 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 *
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/10/20 10:35
 */
public class LeetCode21 {

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
	 * 使用递归
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		else if (l2 == null) return l1;
		else if (l1.var < l2.var){
			l1.next = mergeTwoLists(l1.next,l2);
			return l1;
		}else{
			l2.next = mergeTwoLists(l1,l2.next);
			return l2;
		}
	}

	public static void main(String[] args) {
		LeetCode21 L = new LeetCode21();
		ListNode l1 =  null;
		ListNode l2 =  L.new ListNode(1);
		System.out.println(new LeetCode21().mergeTwoLists(l1,l2));
	}
}
