package Interview21;


 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
       boolean[] record = new boolean[20001];
       ListNode pre = head;
       ListNode p = head;
       while (p != null){
           int val = p.val;
           if(!record[val]){
               record[val] = true;
               pre = p;
           }
           else {
               pre.next = p.next;
           }
           p = p.next;

       }
       return head;
    }
}