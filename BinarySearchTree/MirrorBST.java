import org.w3c.dom.Node;

public class MirrorBST {
    public static Node createMirror(Node root){
        if(root == null) return null;

        Node leftMirror = createMirror(root. left);
        Node rightMirror = createMirror(root.right);

        root.left = rightMirror;
        root.right = leftMirror;
        return root;
        }
    }
