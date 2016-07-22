/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
     private int size(ListNode head) {
        
        if (head == null) {
            return 0;
        }
        int size = 0;
        //ListNode dummy = new ListNode(0);
        //dummy.next = head;
        ListNode curt =  head;
        while (curt != null) {
            size ++;
            curt = curt.next;
        }
        return size;
    }
    public ListNode rotateRight(ListNode head, int k) {
        // write your code here 
        if (head == null) {
            return null;
        }
        
        int size = size(head);
        k = k % size;

        if (k == 0) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curt = head;
        
        int index = size - k;
        for (int i = 0; i < index - 1; i++) {
            curt = curt.next;
        }
        ListNode head2 = curt.next;
        curt.next = null;
        ListNode tail = head2;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = dummy.next;
        return head2;
    }
}