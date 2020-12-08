package Interview46;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root==null || p==null){
            return null;
        }
        if(root.val<=p.val){
            TreeNode right = inorderSuccessor(root.right,p);
            return right;
        }else{
            TreeNode left= inorderSuccessor(root.left,p);
            return (left!=null)?left:root;
        }

    }
}

