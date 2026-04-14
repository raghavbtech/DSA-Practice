import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {
    static class Info implements Comparable<Info>{
    int i;
    int j;
    int cost;

    public Info(int i,int j,int cost){
        this.i=i;
        this.j=j;
        this.cost=cost;
    }

    public int compareTo(Info o){
        return this.cost-o.cost;
    }
}

    public static int minCost(int[][] grid)
    {
        int n=grid.length;
        int m=grid[0].length;
        PriorityQueue<Info>pq=new PriorityQueue<>();
        int[][] dist=new int[n][m];

        for(int[] row:dist)
        {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        pq.add(new Info(0, 0, grid[0][0]));
        dist[0][0]=grid[0][0];
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
        while(!pq.isEmpty())
        {
            Info curr=pq.poll();

            if(curr.i==n-1 && curr.j==m-1)return curr.cost;

            for(int[] d:dir)
            {
                int ni=curr.i+d[0];
                int nj=curr.j+d[1];

                if(ni>=0 && nj>=0 && ni<n && nj<m){
                    int newCost=curr.cost+grid[ni][nj];
                    if(newCost<dist[ni][nj])
                    {
                        dist[ni][nj]=newCost;
                        pq.add(new Info(ni, nj, newCost));
                    }
                }
            }
        }
        return -1;

    }

    //Without info class
//     import java.util.*;

// class Solution {

//     public static int minCost(int[][] grid){

//         int n = grid.length;
//         int m = grid[0].length;

//         PriorityQueue<int[]> pq =
//             new PriorityQueue<>((a,b)->a[0]-b[0]);

//         int[][] dist = new int[n][m];

//         for(int[] row : dist)
//             Arrays.fill(row,Integer.MAX_VALUE);

//         pq.add(new int[]{grid[0][0],0,0});
//         dist[0][0] = grid[0][0];

//         int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

//         while(!pq.isEmpty())
//         {
//             int[] curr = pq.poll();

//             int cost = curr[0];
//             int i = curr[1];
//             int j = curr[2];

//             if(i == n-1 && j == m-1)
//                 return cost;

//             for(int[] d : dir)
//             {
//                 int ni = i + d[0];
//                 int nj = j + d[1];

//                 if(ni>=0 && nj>=0 && ni<n && nj<m)
//                 {
//                     int newCost = cost + grid[ni][nj];

//                     if(newCost < dist[ni][nj])
//                     {
//                         dist[ni][nj] = newCost;
//                         pq.add(new int[]{newCost,ni,nj});
//                     }
//                 }
//             }
//         }

//         return -1;
//     }
// }
    public static void main(String[] args) {
        
    }
}
