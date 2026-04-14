import java.util.*;

import javax.swing.tree.TreeNode;
public class TwoSumBST {
    class Node{
        int data;
        Node left,right;
        public Node(int data)
        {
            this.data=data;
            this.left=this.right=null;
        }
    }


    public int countPairs(Node root1,Node root2,int x)
    {
        Stack<Node>s1=new Stack<>();
        Stack<Node>s2=new Stack<>();

        Node curr1=root1;
        Node curr2=root2;
        int count=0;
        while(true)
        {
            while(curr1.left!=null)
            {
                s1.push(curr1);
                curr1=curr1.left;
            }
            while(curr2.right!=null)
            {
                s2.push(curr2);
                curr2=curr2.right;
            }

            if(s1.empty() || s2.empty())
            {
                break;
            }

            Node n1=s1.peek();
            Node n2=s2.peek();

            int sum=n1.data+n2.data;
            if(sum==x)
            {
                count++;
                s1.pop();
                s2.pop();
                curr1=n1.right;
                curr2=n2.left;
            }
            else if(sum<x)
            {
                s1.pop();
                curr1=n1.right;
            }
            else{
                s2.pop();
                curr2=n2.left;
            }
        }
        return count;
    }

    class Solution {

    void store(TreeNode root, HashSet<Integer> set) {
        if (root == null) return;

        set.add(root.val);
        store(root.left, set);
        store(root.right, set);
    }

    int countPairs(TreeNode root, HashSet<Integer> set, int x) {
        if (root == null) return 0;

        int count = 0;

        if (set.contains(x - root.val))
            count++;

        count += countPairs(root.left, set, x);
        count += countPairs(root.right, set, x);

        return count;
    }

    public int countPairs(TreeNode root1, TreeNode root2, int x) {

        HashSet<Integer> set = new HashSet<>();

        store(root1, set);

        return countPairs(root2, set, x);
    }
}
}
