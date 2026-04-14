import java.util.HashMap;

import org.w3c.dom.Node;

public class CopyListWithRandomPointer {
    /*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)return null;
        HashMap<Node,Node>mp=new HashMap<>();

        Node oldTemp=head.next;
        Node newHead=new Node(head.val);
        Node newTemp=newHead;
        mp.put(head,newHead);
       
        while(oldTemp!=null){
            Node copyNode=new Node(oldTemp.val);
            mp.put(oldTemp,copyNode);
            newTemp.next=copyNode;
            newTemp=newTemp.next;
            oldTemp=oldTemp.next;
            
        }

        oldTemp=head;
        newTemp=newHead;
        while(oldTemp!=null){
            newTemp.random=mp.get(oldTemp.random);
            newTemp=newTemp.next;
            oldTemp=oldTemp.next;
        }
        return newHead;

        
    }
}
}
