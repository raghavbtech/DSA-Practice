import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class LevelOrderTraversal {
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>ans=new ArrayList<>();
        if(root==null)return ans;
        Deque<TreeNode>dq=new LinkedList<>();
        dq.addLast(root);
        dq.addLast(null);
        List<Integer>currList=new ArrayList<>();
        while(!dq.isEmpty()){
            TreeNode curr=dq.removeFirst();
            if(curr==null){
                ans.add(new ArrayList<>(currList));
                currList.clear();
                if(dq.isEmpty()){
                    break;
                }
                else{
                    dq.addLast(null);
                }
            }
            else{
                currList.add(curr.val);
                if(curr.left!=null){
                    dq.addLast(curr.left);
                }
                if(curr.right!=null){
                    dq.addLast(curr.right);
                }
            }

        }
        return ans;
        
    }
}
    
}
