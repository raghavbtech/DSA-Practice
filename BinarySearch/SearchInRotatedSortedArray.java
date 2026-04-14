public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[left]<=nums[mid]){  //left half is sorted
                if(nums[left]<=target && target<nums[mid]){
                    right=mid-1;  //move left
                }
                else{
                    left=mid+1;   //move right
                }
            }
            else{    //right half is sorted
                if(target>nums[mid] && target<=nums[right]){
                    left=mid+1;  //move right
                }
                else{
                    right=mid-1;  //move left
                }
            }
        }
        return -1;
        
    }
}
