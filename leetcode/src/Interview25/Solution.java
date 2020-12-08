package Interview25;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int flag = 0;
        ListNode p = l1,q = l2;
        ListNode head = new ListNode(-1);
        ListNode s = head;
        while (p != null && q != null){
            int sum = p.val + q.val + flag;
            int res = sum % 10;
            flag = sum / 10;
            s.next = new ListNode(res);
            s = s.next;
            p = p.next;
            q = q.next;
        }
        if(p == null && q == null){
            if(flag == 1){
                s.next = new ListNode(1);
            }
        }
        if(p != null){
            while(p != null){
                int sum = p.val + flag;
                int res = sum % 10;
                flag = sum / 10;
                s.next = new ListNode(res);
                p = p.next;
                s = s.next;
            }
            if(flag == 1){
                s.next = new ListNode(1);
            }
        }
        if(q != null){
            while (q != null){
                int sum = q.val + flag;
                int res = sum % 10;
                flag = sum / 10;
                s.next = new ListNode(res);
                q = q.next;
                s = s.next;
            }
            if(flag == 1){
                s.next = new ListNode(1);
            }
        }
        return head.next;

    }
}