
import java.util.*;

class practice {
    public static int[][] merge(int[][] intervals){

        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> result=new ArrayList<>();

        int[] curr=intervals[0];
        result.add(curr);
        for(int i=1;i<intervals.length;i++){
            int[] next=intervals[i];

            if(next[0]<=curr[1]){
                curr[1]=Math.max(curr[1],next[1]);   //merge
            }
            else{
                curr=next;
                result.add(curr);    // add only when NO overlap
            }
        }

        return result.toArray(new int[result.size()][]);
    }   
    public static void main(String[] args) {
        int[][] intervals={{1,3},{8,10},{2,6},{15,18}};
        
        int[][] ans =merge(intervals);
        System.out.println(Arrays.deepToString(ans));

    }

}


// class Solution {
//     public int[][] merge(int[][] intervals) {
//         Arrays.sort(intervals,(a,b)->a[0]-b[0]);

//         List<int[]>result=new ArrayList<>();

//         int start=intervals[0][0];
//         int end=intervals[0][1];
//         for(int i=1;i<intervals.length;i++){
//             if(intervals[i][0]<=end){
//                 end=Math.max(end,intervals[i][1]);
//             }
//             else{
//                 result.add(new int[]{start,end});
//                 start=intervals[i][0];
//                 end=intervals[i][1];
//             }
//         }
//         result.add(new int[]{start,end});
//         int[][] ans=new int[result.size()][2];
//         for(int i=0;i<ans.length;i++){
//             ans[i]=result.get(i);
//         }
//         return ans;
        
//     }
// }
