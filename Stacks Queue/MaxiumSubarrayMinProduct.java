import java.util.Stack;

public class MaxiumSubarrayMinProduct {
    class Solution {
    public int maxSumMinProduct(int[] nums) {
        int n=nums.length;
        long[] pre=new long[n+1];
        for(int i=0;i<n;i++){
            pre[i+1]=nums[i]+pre[i];
        }

        Stack<Integer>st=new Stack<>();
        long ans=0;

        for(int i=0;i<=n;i++){
            int curr=(i==n)?0:nums[i];
            while(!st.isEmpty() && curr<nums[st.peek()]){   
                int idx=st.pop();
                int left=(st.isEmpty()?-1:st.peek());
                int right=i;

                long sum=pre[right]-pre[left+1];
                ans=Math.max(ans,sum*nums[idx]);
            }
            st.push(i);
        }
        return (int)(ans%1_000_000_007);
        
    }
}

}
