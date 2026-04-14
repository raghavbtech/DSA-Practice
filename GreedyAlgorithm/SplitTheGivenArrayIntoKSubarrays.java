public class SplitTheGivenArrayIntoKSubarrays {
    static boolean canSplit(int[] arr,int k,int maxSum){
        int parts=1;
        int sum=0;
        for(int x:arr){
            if(x+sum<=maxSum){
                sum+=x;
            }
            else{
                sum=x;
                parts++;
            }
        }
        return parts<=k;
    }
    static int splitArray(int[] arr,int K){
        int low=0,high=0;
        for(int x:arr){
            low=Math.max(low,x);
            high+=x;
        }

        int ans=high;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(canSplit(arr,K,mid)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }

        return ans;

    }
    
}
