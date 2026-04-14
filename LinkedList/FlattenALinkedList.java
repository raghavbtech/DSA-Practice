import java.util.ArrayDeque;
import java.util.Deque;

import org.w3c.dom.Node;

public class FlattenALinkedList {
    //recursion
    //     public Node flatten(Node head) {
    //     Node curr=head;

    //     while(curr!=null){
    //         if(curr.child!=null){
    //             Node next=curr.next;
    //             curr.next=flatten(curr.child);
    //             curr.next.prev=curr;
    //             curr.child=null;

    //             while(curr.next!=null){
    //                 curr=curr.next;
    //             }
    //             if(next!=null){
    //                 curr.next=next;
    //                 next.prev=curr;
    //             }

    //         }
    //         curr=curr.next;
    //     }
    //     return head;
        

        
    // }

    /*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

// class Solution {
//     public Node flatten(Node head) {
//         if(head==null)return head;
//         Node curr=head;
//         Deque<Node>stack=new ArrayDeque<>();

//         while(curr!=null){
//             if(curr.child!=null){
//                 if(curr.next!=null){
//                     stack.push(curr.next);
//                 }
//                 curr.next=curr.child;
//                 curr.next.prev=curr;
//                 curr.child=null;

//             }
//             else if(curr.next==null && !stack.isEmpty()){
//                 Node nextNode=stack.pop();
//                 curr.next=nextNode;
//                 nextNode.prev=curr;
//             }
//             curr=curr.next;
//         }

//         return head;



        
//     }
// }
}
