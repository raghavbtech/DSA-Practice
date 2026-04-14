import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumOperatiionsToHalfArraySum {
    class Solution {
    public int halveArray(int[] nums) {
        // PriorityQueue<Double>pq=new PriorityQueue<>((a,b)->b.compareTo(a));
        PriorityQueue<Double>pq=new PriorityQueue<>(Collections.reverseOrder());
        double sum=0;
        for(int i:nums)
        {
            pq.add((double)i);
            sum+=i;
        }
        double target=sum/2;
        double reduced=0;
        int opr=0;
        while(reduced<target)
        {
            double max=pq.poll();
            double half=max/2;
            reduced+=half;
            pq.add(half);
            opr++;
        }
        return opr;
        
    }
}
}
