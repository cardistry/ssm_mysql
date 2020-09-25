package SumofLeftLeaves404;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
class Solution {
    private enum  State{left,right};
    public int sumOfLeftLeaves(TreeNode root) {
        return DFS(root,State.left);
    }

    int DFS(TreeNode root,State state){
        int leftsum,rightsum;
        leftsum = rightsum = 0;
        if(root == null)
            return 0;
        if(root.left == null && root.right == null){
            if(state == State.left)
                return root.val;
            else
                return 0;
        }
        else {
            if(root.left != null)
                leftsum = DFS(root.left,State.left);
            if(root.right != null)
                rightsum = DFS(root.right,State.right);
            return leftsum + rightsum;
        }
    }
}