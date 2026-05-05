/*
    TC: O(n)
    SC: O(1)
*/

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        int n = 1;
        ListNode tail = head;
        while(tail.next != null) {
            n++;
            tail = tail.next;
        }

        tail.next = head;
        k %= n;
        k = n - k - 1;
        while(k-- > 0) {
            head = head.next;
        }

        tail = head.next;
        head.next = null;
        return tail;
    }
}