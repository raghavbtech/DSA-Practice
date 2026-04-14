import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class MaximumLevelSumOfBinaryTree {

class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 1;
        int level = 1;

        while(!q.isEmpty()) {

            int size = q.size();
            int sum = 0;

            for(int i = 0; i < size; i++) {
                TreeNode node = q.remove();
                sum += node.val;

                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }

            if(sum > maxSum) {
                maxSum = sum;
                maxLevel = level;
            }

            level++;
        }

        return maxLevel;
    }
}
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
    public int maxLevelSum(TreeNode root) {
        if(root==null)return 0;

        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        q.add(null);
        int maxSum=Integer.MIN_VALUE;
        int maxLevel=0;
        int currSum=0;
        int currLevel=0;
        while(!q.isEmpty())
        {
            TreeNode curr=q.remove();
            
            if(curr==null){
                currLevel++;
                if(currSum>maxSum)
                {
                    maxSum=currSum;
                    maxLevel=currLevel;
                }
                currSum=0;
                if(q.isEmpty())
                {
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                currSum+=curr.val;
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null)
                {
                    q.add(curr.right);
                }
            }
        }
        return maxLevel;
        

    }
}
}
