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

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode tempHead = new ListNode();
        ListNode tail = tempHead;
        ListNode iterator1 = list1;
        ListNode iterator2 = list2;

        while (iterator1 != null && iterator2 != null) {
            if (iterator1.val < iterator2.val) {
                tail.next = iterator1;
                tail = tail.next; 
                iterator1 = iterator1.next;
            } else {
                tail.next = iterator2;
                tail = tail.next;
                iterator2 = iterator2.next;
            }
        }

        while (iterator1 != null) {
            tail.next = iterator1;
            tail = tail.next; 
            iterator1 = iterator1.next;
        }

        while (iterator2 != null) {
            tail.next = iterator2;
            tail = tail.next; 
            iterator2 = iterator2.next;
        }
        return tempHead.next;
    }
}