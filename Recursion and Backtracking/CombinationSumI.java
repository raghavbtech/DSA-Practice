import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumI {
    //my code(not good but correct)
   
    // public void solve(int currSum,int i,int[] candidates,int target,List<List<Integer>>ans,List<Integer>curr){
    //     //base case
    //     if(currSum==target){
    //         ans.add(new ArrayList<>(curr));
    //         return;
    //     }
    //     if(currSum>target || i==candidates.length){
    //         return;
    //     }

    //     //recursion
    //     //add to current
    //     curr.add(candidates[i]);
    //     solve(currSum+candidates[i],i,candidates,target,ans,curr);
    //     curr.remove(curr.size() - 1);

    //     //not add to current
    //     solve(currSum,i+1,candidates,target,ans,curr);
    // }
    // public List<List<Integer>> combinationSum(int[] candidates, int target) {
    //     List<List<Integer>>ans=new ArrayList<>();
    //     solve(0,0,candidates,target,ans,new ArrayList<>());
    //     return ans;
        
    // }


    // correct code(Interview point of view)
    public void backtrack(int[] nums,int target,int start,List<Integer>curr,List<List<Integer>>result){
        if(target==0){
            result.add(new ArrayList<>(curr));
        }

        for(int i=start;i<nums.length;i++){
            if(nums[i]>target)break;

            curr.add(nums[i]);
            backtrack(nums, target-nums[i], i, curr, result);
            curr.remove(curr.size()-1);

        }
    }
    public List<List<Integer>> combinationSum(int[] nums,int target){
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer>curr=new ArrayList<>();
        backtrack(nums,target,0,curr,ans);
        return ans;

    }
}

