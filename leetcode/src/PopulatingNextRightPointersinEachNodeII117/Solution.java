package PopulatingNextRightPointersinEachNodeII117;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};


public class Solution {

    public Node connect(Node root) {
        int num;
        Queue <Node> myQueue = new LinkedList<Node>();
        if(root == null){
            return null;
        }
        myQueue.add(root);
        while (!myQueue.isEmpty()){
            Node pre = null,p;
            num = myQueue.size();
            for(int i = 0; i < num; ++i){
                p = myQueue.poll();
                if(i != 0)
                    pre.next = p;
                p.next = null;
                pre = p;
                if(p.left != null){
                    myQueue.add(p.left);
                }
                if(p.right != null){
                    myQueue.add(p.right);
                }
            }
        }
        return root;
    }
}

