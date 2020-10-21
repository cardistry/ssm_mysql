package LC102;


import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> myQueue = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> tmp;
        if(root == null)
            return res;
        myQueue.addLast(root);
        while (!myQueue.isEmpty()){
            int count =myQueue.size();
            tmp = new LinkedList<>();
            for(int i = 0 ; i < count; ++i){
                TreeNode curNode = myQueue.pollFirst();
                tmp.add(curNode.val);
                if(curNode.left != null)
                    myQueue.addLast(curNode.left);
                if(curNode.right != null)
                    myQueue.addLast(curNode.right);
            }
            res.add(tmp);

        }
        return res;

    }
}