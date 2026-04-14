public class ReverseListNodesInKGroup {
    class ListNode{
        int val;
        ListNode next;
        public ListNode(int d){
            this.val=d;
            this.next=null;
        }

    }

    /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head,int k){
        if(head==null || k<=1)return head;
        ListNode temp=head;
        for(int i=0;i<k;i++){
            if(temp==null)return head;
            temp=temp.next;
        }
        ListNode prev=null;
        ListNode curr=head;
        ListNode next=null;
        int count=0;
        while(curr!=null && count<k ){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            count++;
        }
    

        head.next=reverseKGroup(curr,k);
        return prev;

    }
}
    public static void main(String[] args) {
        
    }
}
