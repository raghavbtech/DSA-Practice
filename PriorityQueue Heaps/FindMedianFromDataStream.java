import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    class MedianFinder {
    PriorityQueue<Integer>maxHeap; //leftside
    PriorityQueue<Integer>minHeap; //rightside
    public MedianFinder() {
        maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        minHeap=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        //add to left side
        maxHeap.add(num);

        //move left->right
        minHeap.add(maxHeap.poll());

        //balance size
        if(minHeap.size()>maxHeap.size())
        {
            maxHeap.add(minHeap.poll());
        }
    }

    
    public double findMedian() {
        //odd case
        if(maxHeap.size()>minHeap.size())
        {
            return maxHeap.peek();
        }
        return (minHeap.peek()+maxHeap.peek())/2.0;    
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
}
