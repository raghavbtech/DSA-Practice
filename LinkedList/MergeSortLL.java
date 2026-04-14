import java.util.*;


public class MergeSortLL {
    class Node{
        int data;
        Node next;
        public Node(int d){
            this.data=d;
            this.next=null;
        }
    };

    public Node findMid(Node head){
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public Node merge(Node head1,Node head2){
        Node dummy=new Node(-1);
        Node temp=dummy;

        while(head1!=null && head2!=null){
            if(head1.data<=head2.data){
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            }
            else{
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
        }
        while(head1!=null){
            temp.next=head1;
            head1=head1.next;
            temp=temp.next;
        }

        while(head2!=null){
            temp.next=head2;
            head2=head2.next;
            temp=temp.next;
        }

        return dummy.next;
    }
    
    public Node mergeSort(Node head){
        if(head==null || head.next==null)return head;
        Node mid=findMid(head);
        
        Node rightHead=mid.next;
        mid.next=null;

        Node newLeft=mergeSort(head);
        Node newRight=mergeSort(rightHead);
        
        return merge(newLeft,newRight);
    }

    public static void main(String[] args) {
        
    }
    
}
