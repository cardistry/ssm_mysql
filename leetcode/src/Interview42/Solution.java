package Interview42;


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
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int low, int high) {
        if (low > high) {   // low > high表示子数组为空
            return null;
        }
        // 以mid作为根节点
        int mid = (high - low) / 2 + low;
        TreeNode root = new TreeNode(nums[mid]);
        // 左子数组[low, mid -1]构建左子树
        root.left = helper(nums, low, mid - 1);
        // 右子数组[mid + 1, high]构建右子树
        root.right = helper(nums,mid + 1, high);
        return root;
    }
}

