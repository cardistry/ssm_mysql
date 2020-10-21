package AddTwoNumbers;



class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int add = 0;
        ListNode p,q,head,pre;
        p = l1;
        q = l2;
        head = new ListNode();
        pre = head;
        while (p != null && q != null) {
            int count = p.val + q.val + add;
            ListNode cur = new ListNode(count % 10);
            pre.next = cur;
            pre = cur;
            add = count / 10;
            p = p.next;
            q = q.next;

        }
        while (p != null){
            int count = p.val + add;
            ListNode cur = new ListNode(count % 10 );
            pre.next = cur;
            pre = cur;
            add = count / 10;
            p = p.next;


        }
        while (q != null){
            int count = q.val + add;
            ListNode cur = new ListNode(count % 10);
            pre.next = cur;
            pre = cur;
            add = count / 10;
            q = q.next;

        }
        if(add != 0){
            pre.next = new ListNode(1);
        }
        return head.next;
    }
}