import java.util.*;
public class PathWithMinimumEffortLeetCode {
    class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows=heights.length;
        int cols=heights[0].length;
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        int[][] dist=new int[rows][cols];

        for(int[] r:dist)Arrays.fill(r,Integer.MAX_VALUE);
        pq.add(new int[]{0,0,0});  // effort,row,col
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};

        while(!pq.isEmpty())
        {
            int[] curr=pq.poll();

            int effort=curr[0];
            int r=curr[1];
            int c=curr[2];
            if(r==rows-1 && c==cols-1)return effort;

            for(int[] d:dir)
            {
                int nr=r+d[0];
                int nc=c+d[1];

                if(nr>=0 && nc>=0 && nr<rows && nc<cols)
                {
                    int newEffort=Math.max(effort,Math.abs(heights[r][c]-heights[nr][nc]));

                    if(newEffort<dist[nr][nc])
                    {
                        dist[nr][nc]=newEffort;
                        pq.add(new int[]{newEffort,nr,nc});
                    }
                }
            }
        }
            return -1;
        
    }
}
}