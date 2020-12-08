package Interview45;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    TreeNode pre ;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true ;
        Boolean L = isValidBST(root.left);
        if(pre != null && pre.val >= root.val) return false ;
        pre = root ;
        Boolean R = isValidBST(root.right) ;
        return L && R ;
    }
}
