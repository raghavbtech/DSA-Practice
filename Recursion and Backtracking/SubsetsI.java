import java.util.ArrayList;
import java.util.List;

public class SubsetsI {
    
    public void solve(int index,int[] nums,List<Integer>curr,List<List<Integer>>ans){
        if(index==nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }

        if(index>=nums.length)return;


        //include in subset
        curr.add(nums[index]);
        solve(index+1,nums,curr,ans);
        curr.remove(curr.size()-1);   //backtrack


        //does not include in subset
        solve(index+1,nums,curr,ans);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        solve(0,nums,new ArrayList<>(),ans);
        return ans;
        
    }
}

