public class FindClosestElementInBST {
    static class Node{
        int data;
        Node left;
        Node right;
    }

    static int minDiffNode(Node root,int k)
    {
        int closest=root.data;

        while(root!=null)
        {
            if(Math.abs(root.data-k)<Math.abs(closest-k))
            {
                closest=root.data;
            }

            if(root.data<k)
            {
                root=root.right;
            }
            else if(root.data>k)
            {
                root=root.left;
            }
            else{
                break;
            }
        }
        return closest;
    }
}
