/*
    TC: O(n)
    SC: O(1)
*/

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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = {1000000, -1};
        if(head == null) return new int[]{-1, -1};

        int first = -1, last = -1;
        int idx = 1;
        int p = -1;

        int prev = head.val;
        head = head.next;
        while(head.next != null) {
            if((head.val > prev && head.val > head.next.val) || (head.val < prev && head.val < head.next.val)) {
                if(p != -1) ans[0] = Math.min(ans[0], idx - p);
                if(first == -1) {
                    first = idx;
                    p = idx;
                } else {
                    last = idx;
                    p = idx;
                }
            }

            prev = head.val;
            head = head.next;
            idx++;
        }

        if(last != -1) ans[1] = last - first;

        return ans[0] == 1000000? new int[]{-1, -1}: ans;
    }
}