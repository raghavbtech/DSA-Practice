import java.util.HashMap;

public class SubarraySum{

    public int subArray(int[] nums,int k){
        HashMap<Integer,Integer>hm=new HashMap<>();
        hm.put(0, 1);
        int prefixSum=0;
        int ans=0;
        for(int i=0;i<nums.length;i++){
            prefixSum+=nums[i];
            if(hm.containsKey(prefixSum-k)){
                ans+=hm.get(prefixSum-k);
            }
            hm.put(prefixSum,hm.getOrDefault(hm, 0)+1);
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
    
}