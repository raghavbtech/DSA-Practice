import java.util.Stack;

import javax.swing.tree.TreeNode;

public class FlattenTreeIntoLinkedList {
    //Iterative
    class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();

            if(curr.right != null) stack.push(curr.right);
            if(curr.left != null) stack.push(curr.left);

            if(!stack.isEmpty()){
                curr.right = stack.peek();
            }

            curr.left = null;
        }
    }
}

//recursion
class Solution {
    TreeNode prev=null;
    public void flatten(TreeNode root) {
        if(root==null)return;

        flatten(root.right);
        flatten(root.left);
        root.right=prev;
        root.left=null;
        prev=root;
        
        
    }
}

}
