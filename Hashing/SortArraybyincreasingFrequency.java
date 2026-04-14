import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SortArraybyincreasingFrequency {
    class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();

        for(int num:nums)
        {
            map.put(num,map.getOrDefault(num,0)+1);
        }

        List<Integer>[] bucket=new ArrayList[nums.length+1];
        for(int key:map.keySet())
        {
            int freq=map.get(key);
            if(bucket[freq]==null)
            {
                bucket[freq]=new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        int[] result=new int[nums.length];
        int k=0;
        for(int i=0;i<bucket.length;i++)
        {
            if(bucket[i]==null)continue;
            Collections.sort(bucket[i],Collections.reverseOrder());
            for(int num:bucket[i])
            {
                for(int j=0;j<i;j++)
                {
                    result[k++]=num;
                }
            }
        }
        return result;
        
    }
}
}
