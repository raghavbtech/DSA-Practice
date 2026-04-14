import javax.swing.tree.TreeNode;

public class UnivaluedBinaryTree {
    public boolean helper(TreeNode root,int val){
        if(root==null){
            return true;
        }
        if(root.val!=val){
            return false;
        }

        return helper(root.left,val) && helper(root.right,val);
    }
    public boolean isUnivalTree(TreeNode root) {
        if(root==null)return true;
        return helper(root,root.val);
    }
}
