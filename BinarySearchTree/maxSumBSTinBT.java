import javax.swing.tree.TreeNode;

public class maxSumBSTinBT {
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
    class Info{
        boolean isBST;
        int sum;
        int min;
        int max;
        Info(boolean isBST,int sum,int min,int max)
        {
            this.isBST=isBST;
            this.sum=sum;
            this.min=min;
            this.max=max;
        }
    }
    int maxSum=0;
    private Info maxSumf(TreeNode root)
    {
        if(root==null)
        {
            return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }

        Info leftInfo=maxSumf(root.left);
        Info rightInfo=maxSumf(root.right);
        int sum=root.val+leftInfo.sum+rightInfo.sum;
        int min=Math.min(root.val,Math.min(leftInfo.min,rightInfo.min));
        int max=Math.max(root.val,Math.max(leftInfo.max,rightInfo.max));

        if(root.val<=leftInfo.max  || root.val >= rightInfo.min)
        {
            return new Info(false,sum,min,max);
        }

        if(leftInfo.isBST && rightInfo.isBST)
        {
            maxSum=Math.max(maxSum,sum);
            return new Info(true,sum,min,max);
        }

        return new Info(false,sum,min,max);

    }
    public int maxSumBST(TreeNode root) {
        maxSumf(root);
        return maxSum;
    }
}
}
