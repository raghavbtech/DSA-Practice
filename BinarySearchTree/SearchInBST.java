public class SearchInBST {
    public class Node{
        Node left,right;;
        int data;
        public Node(int data)
        {
            this.left=null;
            this.right=null;
            this.data=data;
        }
    }

    static boolean searchInBST(Node root,int key)
    {
        if(root==null)
        {
            return false;
        }
        if(root.data==key)return true;

        if(root.data>key)
        {
            return searchInBST(root.left, key);
        }
        else{
            return searchInBST(root.right, key);
        }
    }
}
