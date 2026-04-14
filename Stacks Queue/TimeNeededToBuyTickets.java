import java.util.ArrayDeque;
import java.util.Queue;

public class TimeNeededToBuyTickets {
    class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer>q=new ArrayDeque<>();
        for(int i=0;i<tickets.length;i++){
            q.offer(i);
        }

        int time=0;
        while(!q.isEmpty()){
            int person=q.poll();
            time++;
            tickets[person]--;
            if(tickets[person]>0)q.offer(person);
            if(person == k && tickets[person] == 0) break;
        }
        return time;
        
    }
}class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        int target = tickets[k];

        for(int i = 0; i < tickets.length; i++) {
            if(i <= k)
                time += Math.min(tickets[i], target);
            else
                time += Math.min(tickets[i], target - 1);
        }

        return time;
    }
}

}
