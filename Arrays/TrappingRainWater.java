class Solution {
    public int trap(int[] height) {
        int left=0,leftMax=0;
        int right=height.length-1,rightMax=0;
        int water=0;
        while(left<right){
            if(height[left]<height[right]){
                if(height[left]>=leftMax){
                    leftMax=height[left];
                }
                else{
                    water+=leftMax-height[left];
                }
                left++;
            }
            else{
                if(height[right]>=rightMax){
                    rightMax=height[right];
                }
                else{
                    water+=rightMax-height[right];
                }
                right--;
            }
        }
        return water;

        
    }
}


class Practice{
    public static int trappingRain(int[] height){
        int left=0,lmax=0,right=height.length-1,rmax=0;
        int ans=0;
        while(left<=right){
            lmax=Math.max(lmax, height[left]);
            rmax=Math.max(rmax, height[right]);

            if(lmax<rmax){
                ans+=lmax-height[left];
                left++;
            }
            else{
                ans+=rmax-height[right];
                right--;
            }
        }
        return ans;
    }
}