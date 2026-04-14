import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class BinaryTreeZigZagTraversal {
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>ans=new ArrayList<>();
        if(root == null) return ans;

        Queue<TreeNode>q=new LinkedList<>();
        q.offer(root);
        boolean leftToRight=true;

        while(!q.isEmpty())
        {
            int size=q.size();
            List<Integer>curr=new ArrayList<>();

            for(int i=0;i<size;i++)
            {
                TreeNode node=q.poll();

                if(leftToRight)
                {
                    curr.add(node.val);
                }
                else{
                    curr.add(0,node.val);
                }

                if(node.left!=null)q.offer(node.left);
                if(node.right!=null)q.offer(node.right);
            }
            ans.add(new ArrayList<>(curr));
            leftToRight=!leftToRight;
        }

        return ans;
        
    }
}
}
