package Interview24;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution  {
    public ListNode partition(ListNode head, int x) {
        ListNode other = new ListNode(-1);
        ListNode myhead = new ListNode(-1);
        myhead.next = head;
        ListNode pre = myhead;
        ListNode q = other;
        while (pre.next != null){
            if(pre.next.val >=x){
                q.next = pre.next;
                q = q.next;
                pre.next = q.next;
            }
            else
                pre = pre.next;

        }
        q.next = null;
        pre.next = other.next;
        return myhead.next;

    }
}