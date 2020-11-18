package LC129;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

class Solution {

//    public int sumNumbers(TreeNode root) {
//        if(root == null)
//            return 0;
//        return myNum(root,0);
//    }

//    public int myNum(TreeNode root,int sum){
//        int curSum = 10 * sum + root.val;
//        if(root.left == null && root.right == null)
//            return curSum;
//        int left,right ;
//        left = right = 0;
//        if(root.left != null)
//            left = myNum(root.left,curSum);
//        if(root.right != null)
//            right = myNum(root.right,curSum);
//        return  left + right;
//    }
}