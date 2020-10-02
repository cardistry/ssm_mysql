package sword55Ⅱ;

 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

}

class Solution {
    public boolean isBalanced(TreeNode root) {
        return myBalanced(root) != -1;
    }
    public int myBalanced(TreeNode root){
        if(root == null)
            return 0;
        int left,right;
        if((left = myBalanced(root.left))!= -1 && (right = myBalanced(root.right))!= -1
            && Math.abs(left - right) <= 1){
            return Math.max(left,right) + 1;
        }
        else
            return -1;

    }
}