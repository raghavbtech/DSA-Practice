class Solution {
    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;

    }
    private void reverse(int[] nums,int start,int end){
        while(start<end){
            swap(nums,start++,end--);
        }
    }
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int i=n-2;

        //find non decreasing element from the right
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }

        //findd the next greater element to the right of i
        if(i>=0){
            int j=n-1;
            while(nums[j]<=nums[i]){
                j--;
            }
            swap(nums,i,j);
        }

        //reverse after i;
        reverse(nums,i+1,n-1);
          
    }
}




class Practice{
    public static void nextPermutation(int[] nums){
        int n=nums.length;
        int i=n-2;
        //find first non decreasing number
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }

        if(i>=0){
            int j=n-1;
            while(j>=0 && nums[j]<=nums[i]){
                j--;
            }
            swap(nums,i,j);
        }

        //reverse after i
        reverse(nums,i+1,n-1);
    }
}