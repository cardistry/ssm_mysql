package Interview49;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {

    List<List<Integer>> reses = new LinkedList<>();
    LinkedList<Integer> res = new LinkedList<>();
    public List<List<Integer>> BSTSequences(TreeNode root) {
        if(root==null){
            reses.add(res);
            return reses;
        }
        HashSet<TreeNode> curLevel = new HashSet<>();
        curLevel.add(root);
        dfs(curLevel);
        return reses;
    }
    public void dfs(HashSet<TreeNode> curLevel) {
        //当前集合没有需要遍历的元素，说明遍历到底
        if(curLevel.size() == 0){
            reses.add(new LinkedList<>(res));
            return;
        }

        HashSet<TreeNode> nextLevel = new HashSet<>(curLevel);
        for (TreeNode curNode:curLevel){
            res.add(curNode.val);
            nextLevel.remove(curNode);
            if(curNode.left!=null)
                nextLevel.add(curNode.left);
            if(curNode.right != null)
                nextLevel.add(curNode.right);
            dfs(nextLevel);
            if(curNode.left!=null)
                nextLevel.remove(curNode.left);
            if(curNode.right != null)
                nextLevel.remove(curNode.right);
            res.removeLast();
            nextLevel.add(curNode);
        }
    }
}
