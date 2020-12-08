package Interview44;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return flag;
    }

    private int dfs(TreeNode n){
        if(n == null || !flag)
            return 0;
        int leftDepth = dfs(n.left)+1;
        int rightDepth = dfs(n.right)+1;
        if(Math.abs(leftDepth-rightDepth) > 1)
            flag = false;
        return Math.max(leftDepth,rightDepth);
    }
}

