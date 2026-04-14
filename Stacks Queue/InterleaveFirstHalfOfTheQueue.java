import java.util.LinkedList;
import java.util.Queue;

public class InterleaveFirstHalfOfTheQueue {
    class Solution {
    public void rearrangeQueue(Queue<Integer> q) {
        Queue<Integer>f=new LinkedList<>();
        int half=q.size()/2;
        for(int i=0;i<half;i++){
            f.add(q.poll());
        }
        
        while(!f.isEmpty()){
            q.add(f.poll());
            q.add(q.poll());
        }
        
    }
}

}
