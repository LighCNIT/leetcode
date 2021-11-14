/**
 * 有序链表转二叉搜索数
 */

class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){ this.val = val;}
    ListNode(int var,ListNode node){
        this.val = var;
        this.next = node;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val){ this.val = val;}
    TreeNode(int val,TreeNode left,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class LeetCode109 {


    /**
     * 思路：首先是要怎么找到根结点？显然如果链表长度是奇数就是中间，偶数就是中间两个
     * 这里的做法是：定义一个快指针一个慢指针。快指针是慢指针的两倍，然后遍历到快指针指向的是最后一个元素，
     * 此时慢指针指向的就是根结点。然后左右子树继续递归生成即可
     * 时间复杂度nlog（n）
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head,null);
    }

    public TreeNode buildTree(ListNode left,ListNode right){
        ListNode media = getMedian(left,right);
        TreeNode root = new TreeNode(media.val);
         root.left = buildTree(left, media);
         root.right = buildTree(media.next,right);
        return root;
    }

    public ListNode getMedian(ListNode left,ListNode right){
        ListNode fast = left;
        ListNode slow = left;
        while(fast != right && fast.next!=right){
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
