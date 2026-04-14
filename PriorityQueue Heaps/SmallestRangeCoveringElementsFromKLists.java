import java.util.List;
import java.util.PriorityQueue;

public class SmallestRangeCoveringElementsFromKLists {

    class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        //{value,listIndex,elementIndex}
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.size();i++)
        {
            int val=nums.get(i).get(0);
            pq.add(new int[]{val,i,0});
            max=Math.max(max,val);
        }

        int start=0,end=Integer.MAX_VALUE;

        while(true)
        {
            int[] curr=pq.poll();
            int min=curr[0];
            int listIdx=curr[1];
            int eleIdx=curr[2];


            //update best range
            if(max-min<end-start)
            {
                start=min;
                end=max;
            }


            //list exhausted
            if(eleIdx+1==nums.get(listIdx).size())
            {
                break;
            }

            int nextVal=nums.get(listIdx).get(eleIdx+1);
            pq.add(new int[]{nextVal,listIdx,eleIdx+1});

            max=Math.max(max,nextVal);
        }

        return new int[]{start,end};
        
    }
}
}