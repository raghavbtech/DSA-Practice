import java.util.*;

class Solution {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int j = 0;

        // Max-heap storing indices, comparing by value
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> nums[b] - nums[a]);

        for (int i = 0; i < n; i++) {
            // Add current index
            pq.add(i);

            // Remove indices that are out of this window
            while (pq.peek() <= i - k) {
                pq.poll();
            }

            // Once we have our first full window
            if (i >= k - 1) {
                ans[j++] = nums[pq.peek()];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums={1,3,-1,-3,5,3,6,7};
        int k=3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }
}


class Practice{
    public int[] maxSlidingWindow(int[] nums,int k){
        if(nums==null || k==0)return new int[0];
        int n=nums.length;
        int ans[]=new int[n-k+1];
        Deque<Integer>dq=new ArrayDeque<>();

        for(int i=0;i<n;i++){
            if(!dq.isEmpty() && dq.peekFirst()<=i-k){
                dq.pollFirst();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
            if(i>=k){
                ans[i-k+1]=nums[dq.peekFirst()];
            }
        }
    }
}