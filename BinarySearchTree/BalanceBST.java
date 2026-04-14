import java.util.ArrayList;

import javax.swing.tree.TreeNode;

public class BalanceBST {
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
    private void inorder(ArrayList<Integer>in,TreeNode root)
    {
        if(root==null)return;
        inorder(in,root.left);
        in.add(root.val);
        inorder(in,root.right);

    }
    private TreeNode createBST(int start,int end,ArrayList<Integer>inorder)
    {
        if(start>end)
        {
            return null;
        }
        int mid=(start+end)/2;
        TreeNode root=new TreeNode(inorder.get(mid));
        root.left=createBST(start,mid-1,inorder);
        root.right=createBST(mid+1,end,inorder);
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer>inor=new ArrayList<>();
        inorder(inor,root);
        return createBST(0,inor.size()-1,inor);
    }
}
}
