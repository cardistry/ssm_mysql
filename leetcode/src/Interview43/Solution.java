package Interview43;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode[] listOfDepth(TreeNode tree) {
        List<ListNode> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(tree != null)
            queue.offer(tree);
        ListNode head = new ListNode(-1);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<ListNode> list = new ArrayList<>();
            ListNode p = head;
            while (size > 0){
                TreeNode cur = queue.poll();
                p.next = new ListNode(cur.val);
                if(cur.left != null)
                    queue.offer(cur.left);
                if(cur.right != null)
                    queue.offer(cur.right);
                --size;
                p = p.next;
            }
            res.add(head.next);
            p.next = null;

        }
        return res.toArray(new ListNode[] {});

    }
}