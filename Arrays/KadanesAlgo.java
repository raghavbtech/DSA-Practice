// class Solution {
//     public int maxSubArray(int[] nums) {
//         int maxSum=nums[0];
//         int currSum=nums[0];
//         for(int i=1;i<nums.length;i++){
//             currSum=Math.max(currSum+nums[i],nums[i]);
//             maxSum=Math.max(currSum,maxSum);
//         }
//         return maxSum;
        
//     }
// }

class Practice{
    static int kadane(int[] nums){
        int currSum=nums[0];
        int maxSum=nums[0];
        for(int i=1;i<nums.length;i++){
            currSum=Math.max(currSum+nums[i],nums[i]);
            maxSum=Math.max(maxSum, currSum);
        }
        return maxSum;
    }
    void main()
    {
        System.out.println(kadane(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

}