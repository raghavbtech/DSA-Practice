import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
   
    public void backtrack(int start ,int target,int[] candidates,List<Integer>curr,List<List<Integer>>ans){
        if(target==0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(i>start && candidates[i]==candidates[i-1]){
                continue;
            }
            if(candidates[i]>target){
                break;
            }
            curr.add(candidates[i]);
            backtrack(i + 1, target - candidates[i], candidates, curr, ans);
            curr.remove(curr.size() - 1); // backtrack
        }

        
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>curr=new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0,target,candidates,curr,ans);
        return ans;
    }

}
