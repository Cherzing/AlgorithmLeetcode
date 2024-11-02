package cn.cherzing;


import org.junit.Test;

/**
 * @author Cherzing
 * @date 2024/10/28 0028 15:55
 * @description DeleteDuplicates
 */
public class DeleteDuplicates {
    @Test
    public void testDeleteDuplicates() {
        Solution solution = new Solution();
        Solution.ListNode node1 = new Solution.ListNode(1);
        Solution.ListNode node2 = new Solution.ListNode(2);
        Solution.ListNode node3 = new Solution.ListNode(3);
        Solution.ListNode node4 = new Solution.ListNode(3);
        Solution.ListNode node5 = new Solution.ListNode(3);
        Solution.ListNode node6 = new Solution.ListNode(3);
        Solution.ListNode node7 = new Solution.ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        Solution.ListNode head = solution.deleteDuplicatesMe(node1);
        System.out.println(head.val);
//        while (head != null ){
//            head = head.next;
//            System.out.println(head);
//        }

    }
}

class Solution {
    /**
     * 遍历每个整个链表，
     * 如果前一个节点等于后一个节点，
     * 则删去后一个节点，
     * 将后面一个节点的后面的节点提前
     * @param head
     * @return
     */
    public ListNode deleteDuplicatesMe(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }

        ListNode current = head;
        while (current != null && current.next != null){

            if (current.val == current.next.val){
                current.next = current.next.next;
            }
            else {
                current = current.next;
            }

        }
        return head;
    }

    public void printList(ListNode head){
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static class ListNode {
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
}