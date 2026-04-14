public class ZigZagTraversal {
    class Node{
        int data;
        Node next;
        public Node(int d){
            this.data=d;
            this.next=null;
        }
    }
    public Node zigzag(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

        }
        Node RightHead=slow.next;
        slow.next=null;
        Node prev=null;
        Node curr=RightHead;
        Node next=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        RightHead=prev;
        Node leftHead=head;
        Node nextL=null,nextR=null;
        while(leftHead!=null && RightHead!=null ){
            nextL=leftHead.next;
            leftHead.next=RightHead;

            nextR=RightHead.next;
            RightHead.next=nextL;

            leftHead=nextL;
            RightHead=nextR;

        }

        return head;
    }
    public static void main(String[] args) {
        
    }
}
