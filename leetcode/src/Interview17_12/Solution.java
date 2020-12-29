package Interview17_12;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    TreeNode head = new TreeNode(-1);
    TreeNode pre = head;
    public TreeNode convertBiNode(TreeNode root) {
        if(root == null)
            return null;

        if(root.left != null)
            convertBiNode(root.left);

        pre.right = root;
        root.left = null;    //防止成环
        pre = root;
        if(root.right != null){
            convertBiNode(root.right);
        }
        return head.right;

    }
}