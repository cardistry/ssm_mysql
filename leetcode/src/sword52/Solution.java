package sword52;


class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
}
class Solution1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLen(headA);
        int lenB = getLen(headB);
        ListNode pA,pB;
        pA = headA;
        pB = headB;
        if(lenA > lenB )
            for(int i = 0 ; i < lenA - lenB;++i)
                pA = pA.next;
        else
            for(int i = 0 ; i < lenB - lenA;++i)
                pB = pB.next;
        while (pA != pB) {
            pA = pA.next;
            pB = pB.next;
        }
        return pA;
    }
    int getLen(ListNode list){
        int count = 0;
        ListNode p = list;
        while (p != null){
            p = p.next;
            ++count;
        }
        return count;
    }
}

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA,pB;
        pA = headA;
        pB = headB;
        while (pA != pB){
            if(pA == null)
                pA = headB;
            else  pA = pA.next;
            if(pB == null)
                pB = headA;
            else
                pB = pB.next;
        }
        return pA;
    }
}