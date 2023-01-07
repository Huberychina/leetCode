package leetcode.editor.cn;//给你一个链表数组，每个链表都已经按升序排列。
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 2273 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class MergeKASCList {
    public static void main(String[] args) {
//        ListNode node10 = new ListNode(1);
//        ListNode node11 = new ListNode(1);
//        ListNode node12 = new ListNode(3);
//        node10.next = node11;
//        node11.next = node12;
//        ListNode node20 = new ListNode(2);
//        ListNode node21 = new ListNode(3);
//        ListNode node22 = new ListNode(3);
//        node20.next = node21;
//        node21.next = node22;
//        ListNode head = (new Solution()).mergeKLists(new ListNode[]{node10,node20});
//        while(head.next != null){
//            System.out.println(head.next.val);
//            head = head.next;
//        }
        ListNode listNode = new ListNode(1);
        ListNode temp = listNode;
        listNode = new ListNode(2);
        System.out.println(temp.val);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = mergeKListsHelper(lists,0,lists.length-1);
        return head;
    }
    public ListNode mergeKListsHelper(ListNode[] lists,int left,int right) {
        if(left>right) return null;
        if(left == right) return lists[left];

        //分治
        int middle= (left + right)/2;
        ListNode leftHead = mergeKListsHelper(lists,left,middle);
        ListNode rightHead =  mergeKListsHelper(lists,middle+1,right);
        return getMergedList(leftHead,rightHead);
    }
    public ListNode getMergedList(ListNode left,ListNode right){
        ListNode headOrigin = new ListNode(0);
        ListNode leftTemp = left,rightTemp = right,head=headOrigin;
        while(leftTemp != null && rightTemp != null){
            if(leftTemp.val < rightTemp.val){
                head.next = leftTemp;
                leftTemp = leftTemp.next;
            }else {
                head.next = rightTemp;
                rightTemp = rightTemp.next;
            }
            head = head.next;
        }
        head.next = leftTemp == null ? rightTemp:leftTemp;
        return headOrigin.next;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
