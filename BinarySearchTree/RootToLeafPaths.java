import java.util.ArrayList;

import SearchInBST.Node;

public class RootToLeafPaths {
    public static void printRoot2Leaf(Node root,ArrayList<Integer>path)
    {
        if(root==null)
        {
            return;
        }
        path.add(root.data);
        if(root.left==null && root.right==null)
        {
            printPath(path);
        }
        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);
        path.remove(path.size()-1);        
    }
}
