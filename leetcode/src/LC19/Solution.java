package LC19;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p,pre,cur;
        cur = head;
        int i = 1;
        for(i = 1 ; i < n && cur.next != null ;++i){
            cur = cur.next;
        }
        if(cur.next == null && i >= n-1)
            return head.next;
        else if(cur.next == null)
            return head;
        pre = p = head;
        while (cur.next != null){
            cur = cur.next;
            pre = p;
            p = p.next;
        }
        pre.next = p.next;
        return head;
    }
}