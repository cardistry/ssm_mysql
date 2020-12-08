package Interview22;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public int kthToLast(ListNode head, int k) {
        ListNode p = head;
        ListNode pre = head;
        for (int i = 1; i < k ; i++)
            p = p.next;
        while (p.next != null){
            p = p.next;
            pre = pre.next;
        }
        return pre.val;
    }
}