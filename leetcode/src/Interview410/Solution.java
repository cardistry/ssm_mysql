package Interview410;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if(t2 == null)
            return true;
        if(t1 == null)
            return false;
        if(t1.val != t2.val)
            return checkSubTree(t1.left,t2) || checkSubTree(t1.right,t2);
        else
            return checkSubTree(t1.left,t2) || checkSubTree(t1.right,t2) || isTheSame(t1,t2);

    }
    public boolean isTheSame(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null)
            return true;
        if(t1 == null || t2 == null)
            return true;
        if(t1.val != t2.val)
            return false;
        return isTheSame(t1.left,t2.left) && isTheSame(t1.right,t2.right);
    }
}
