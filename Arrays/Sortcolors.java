class Solution {
    public void sortColors(int[] nums) {
        int zero=0,one=0,two=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)zero++;
            if(nums[i]==1)one++;
            if(nums[i]==2)two++;
        }
        int i=0;
        while(zero-->0){
            nums[i++]=0;
        }
        while(one-->0){
            nums[i++]=1;
        }
        while(two-->0){
            nums[i++]=2;
        }
        
    }
}


class Practice{
    private static void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
    public static void sortColors(int[] nums){
        int low=0,mid=0,high=nums.length-1;
        while(mid<=high){
            if(nums[mid]==0){
                // move 0 to beginning
                swap(nums, low, mid);
                low++;
                mid++;
            }
            else if(nums[mid]==1){
                //leave 1 inplace
                mid++;
            }
            else if(nums[mid]==2){
                // move 2 at the end
                swap(nums, mid, high);
                high--;
            }
        }
    }
}