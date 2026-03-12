import java.util.*;

// class Solution {
//     public int majorityElement(int[] nums) {
//        HashMap<Integer,Integer>hm=new HashMap<>();
//        int times=nums.length/2;
//        for(int i:nums){
//         hm.put(i,hm.getOrDefault(i,0)+1);
//        }
//        for(int num:nums){
//         if(hm.get(num)>times)return num;
//        }
//        return -1;

        
//     }
// }

..........
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));


        
    }
}