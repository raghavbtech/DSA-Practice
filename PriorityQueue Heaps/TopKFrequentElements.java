import java.util.*;;
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans=new int[k];
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->b[0]-a[0]);
        //{freq,val}
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i:nums)
        {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int j:map.keySet())
        {
            pq.add(new int[]{map.get(j),j});
        }
        
        for(int i=0;i<k;i++)
        {
            ans[i]=pq.poll()[1];
        }
        return ans;
        
    }
}