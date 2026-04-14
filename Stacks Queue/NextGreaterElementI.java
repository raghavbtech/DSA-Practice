import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementI {
    class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer>st=new Stack<>();
        HashMap<Integer,Integer>hm=new HashMap<>();
        int[] ans=new int[nums1.length];
        for(int i=nums2.length-1;i>=0;i--){
            int curr=nums2[i];
            while(!st.isEmpty() && st.peek()<=curr){
                st.pop();
            }
            if(st.isEmpty()){
                hm.put(curr,-1);
            }
            else{
                hm.put(curr,st.peek());
            }
            st.push(curr);
        }
        for(int i=0;i<ans.length;i++){
            ans[i]=hm.get(nums1[i]);
        }
        return ans;


        
    }
}
    
}
