public class BinaryTreeMaximumpathSum {
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxSum=Integer.MIN_VALUE;
    public int dfs(TreeNode root)
    {
         if(root==null)return 0;

        int leftSum=Math.max(0,dfs(root.left));
        int rightSum=Math.max(0,dfs(root.right));

        int through=root.val+leftSum+rightSum;
        maxSum=Math.max(maxSum,through);

        return root.val+Math.max(leftSum,rightSum);

    }
    public int maxPathSum(TreeNode root) {
        if(root==null)return 0;
        maxSum=Integer.MIN_VALUE;
        dfs(root);
        return maxSum;

        
        
    }
}
}
