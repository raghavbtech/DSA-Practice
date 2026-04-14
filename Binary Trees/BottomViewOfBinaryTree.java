import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BottomViewOfBinaryTree {

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
    class Info{
        int hd;
        Node root;
        Info(Node root,int hd)
        {
            this.hd=hd;
            this.root=root;
        }
    }
    public ArrayList<Integer> bottomView(Node root) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int min=0;
        int max=0;
        Queue<Info>q=new LinkedList<>();
        q.add(new Info(root,0));
        q.add(null);
        while(!q.isEmpty())
        {
            Info curr=q.remove();
            
            if(curr==null)
            {
                if(q.isEmpty())
                {
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                map.put(curr.hd,curr.root.data);
                
                if(curr.root.left!=null)
                {
                    q.add(new Info(curr.root.left,curr.hd-1));
                    min=Math.min(min,curr.hd-1);
                }
                if(curr.root.right!=null)
                {
                    q.add(new Info(curr.root.right,curr.hd+1));
                    max=Math.max(max,curr.hd+1);
                }
            }
        }
        
        ArrayList<Integer>ans=new ArrayList<>();
        for(int i=min;i<=max;i++){
            ans.add(map.get(i));
        }
        return ans;
        
    }
}
}

