
class Solution {
    public int reversePairs(int[] nums){
        return (int)ms(nums, 0, nums.length-1);
        
    }
    private long ms(int[] nums,int left,int right){
        long count=0;
        if(left<right){
            int mid=left+(right-left)/2;
            count+=ms(nums, left, mid);
            count+=ms(nums, mid+1, right);
            count+=countReverse(nums,left,mid,right);
            merge(nums,left,mid,right);
        }
        return count;
    }
    private long countReverse(int[] nums,int left,int mid,int right){
        int j=mid+1;
        long count=0;
        for(int i=left;i<=mid;i++){
            while(j<=right && (long)nums[i]>2L*nums[j]){
                j++;
            }
            count+=j-(mid+1);
        }
        return count;
    }
    private void merge(int[] nums,int left,int mid,int right){
        ArrayList<Integer>ans=new ArrayList<>();
        int i=left;
        int j=mid+1;
        while(i<=mid && j<=right){
            if(nums[i]<=nums[j]){
                ans.add(nums[i++]);
            }
            else{
                ans.add(nums[j++]);
            }
        }
        while(i<=mid){
            ans.add(nums[i++]);
        }
        while(j<=right){
            ans.add(nums[j++]);
        }

        for(int k=0;k<ans.size();k++){
            nums[left+k]=ans.get(k);
        }
    }
}