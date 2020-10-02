package PostiOrder;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
    TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}

class Solution1 {
    List<Integer> list = new ArrayList<Integer>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null)
            return null;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
        return list ;
    }
}

class Solution2 {
    List<Integer> list = new ArrayList<Integer>();
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        if(root == null)
            return list;
        stack1.push(root);
        while (!stack1.isEmpty()){
            TreeNode curNode = stack1.pop();
            stack2.push(curNode);
            if(curNode.left != null)
                stack1.push(curNode.left);
            if(curNode.right != null)
                stack1.push(curNode.right);
        }
        while (!stack2.isEmpty()){
            list.add(stack2.pop().val);
        }
        return  list;
    }
}

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null){
            return list;
        }
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.right == null || root.right == prev){
                list.add(root.val);
                prev = root;
                root = null;
            }else {
                stack.push(root);
                root = root.right;
            }

        }
        return list;
    }
}