import java.util.PriorityQueue;

public class KthSortedElementInASortedMatrix {
    // class Solution {
    // public int kthSmallest(int[][] matrix, int k) {
    //     int n=matrix.length;

    //     //{val,row,col}
    //     PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
    //     for(int i=0;i<n;i++)
    //     {
    //         pq.add(new int[]{matrix[i][0],i,0});
    //     }

    //     int ans=0;

    //     for(int i=0;i<k;i++){
    //         int[]curr=pq.poll();
    //         ans=curr[0];
    //         int r=curr[1];
    //         int c=curr[2];

    //         if(c+1<n)
    //         {
    //             pq.add(new int[]{matrix[r][c+1],r,c+1});
    //         }
    //     }
    //     return ans;
        
    // }
// }   
    public int kthSmallest(int[][] matrix, int k){
        int n=matrix.length;
        int low=matrix[0][0];
        int high=matrix[n-1][n-1];
        while(low<high)
        {
            int mid=(low+high)/2;

            int count=countLessEqual(matrix,mid);

            if(count<k){
                low=mid+1;   //need bigger values
            }
            else{
                high=mid;    //possible ans
            }
        }
        return low;
    }
    private int countLessEqual(int[][] matrix,int mid)
    {
        int n=matrix.length;
        int row=n-1;
        int col=0;
        int count=0;

        while(row>=0 && col<n){
            if(matrix[row][col]<=mid)
            {
                count+=row+1;
                col++;
            }
            else{
                row--;
            }
        }
        return count;
    }
}
