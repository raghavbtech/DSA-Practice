public class OddEvenList {
     class Solution {
    public ListNode oddEvenList(ListNode head) {
        
        if(head == null) return null;   // Important edge case
        
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenStart = even;

        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenStart;   // Attach even list at end

        return head;
    }
}
}


