package LC148;


import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}




class Solution {
    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode res;
        int num = 0;
        ListNode p = head;
        if(head == null)
            return;
        while (p != null){
            stack.push(p);
            p = p.next;
            ++num;
        }
       ListNode cur = head;
       p = head.next;
       int count = 0;
       while (true){
         if(++count == num)
               break;
         cur.next = stack.pop();
         cur = cur.next;
         cur.next = null;
         if(++count == num)
              break;
         cur.next = p;
         p = p.next;
         cur = cur.next;
         cur.next = null;

       }

    }
}