class Solution {
    public int maxArea(int[] height) {
        int left=0,right=height.length-1;
        int currMax=0;
        while(left<right){
            int width=right-left;
            int heightWater=Math.min(height[left],height[right]);
            currMax=Math.max(currMax,width*heightWater);
            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }

        }
        return currMax;
        
    }
}


class Practice{
    public static int maxWater(int[] height){
        int left=0,right=height.length-1;
        int currMax=0;
        while(left<right){
            int width=right-left;
            int heightWater=Math.min(height[left],height[right]);
            currMax=Math.max(currMax, heightWater*width);
            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return currMax;
    }
}