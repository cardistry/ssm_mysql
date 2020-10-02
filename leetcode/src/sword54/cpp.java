package sword54;

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}



class Solution {
    public int kthLargest(TreeNode root, int k) {
        if(root == null)
            return -1;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty() || root != null){
            while (root != null){
               stack.push(root);
               root = root.right;
            }
            if (!stack.isEmpty()){
                root = stack.pop();
                if(--k == 0)
                    return root.val ;
                root = root.left;
            }
        }
        return -1;
    }
}