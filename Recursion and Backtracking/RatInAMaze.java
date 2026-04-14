import java.util.ArrayList;
import java.util.Collections;

public class RatInAMaze {
    //one path solution
    // public static boolean solve(int x,int y,int[][] maze,int[][] sol,int n){
    //     //base case
    //     if(x==n-1 && y==n-1 && maze[x][y]==1){
    //         sol[x][y]=1;
    //         return true;
    //     }
        
    //     //recursion
    //     if(x>=0 && y>=0 && x<n && y<n && maze[x][y]==1){
    //         sol[x][y]=1;


    //         //move down
    //         if(solve(x+1, y, maze, sol, n))return true;;

    //         //move right
    //         if(solve(x, y+1, maze, sol, n)) return true;

    //         sol[x][y]=0;
    //         return false;
    //     }
    //     return false;
    // }

    
    
        // public static ArrayList<String> findPath(int[][] maze,int n){
        //     ArrayList<String>ans=new ArrayList<>();
    
        //     if(maze[0][0]==0){
        //         return ans;
        //     }
    
        //     boolean[][] visited=new boolean[n][n];
        //     solve(0,0,maze,n,visited,"",ans);
    
        //     return ans;
        // }

    //all paths solution

  
    public void solve(int x,int y,String path,int[][] maze,boolean[][] visited,int n,ArrayList<String>ans){
        if(x<0 || y<0 || x>=n || y>=n || maze[x][y]==0 || visited[x][y]){
            return;
        }
        
        if(x==n-1 && y==n-1){
            ans.add(path);
            return;
        }
        
        
            visited[x][y]=true;
            //move down
            solve(x+1,y,path+"D",maze,visited,n,ans);
            
            //move right
            solve(x,y+1,path+"R",maze,visited,n,ans);
            
            //move up
            solve(x-1,y,path+"U",maze,visited,n,ans);
            
            //move left
            solve(x,y-1,path+"L",maze,visited,n,ans);
            
            //backtrack
            visited[x][y]=false;
        
    }
    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> ans=new ArrayList<>();
        int n=maze.length;
        if (maze[0][0] == 0) return ans;
        boolean[][] visited=new boolean[n][n];
        solve(0,0,"",maze,visited,maze.length,ans);
        Collections.sort(ans);
        return ans;
        
    }
        
    
    public static void main(String[] args) {
        // int maze[][] = {
        //     {1,0,0,0},
        //     {1,1,0,1},
        //     {0,1,0,0},
        //     {1,1,1,1}
        // };
        
        // int n = 4;
        // int sol[][] = new int[n][n];
        
        // solve(0, 0, maze, sol, n);
        
        // print solution matrix
        // for (int i = 0; i < n; i++) {
            //     for (int j = 0; j < n; j++) {
                //         System.out.print(sol[i][j] + " ");
                //     }
                //     System.out.println();
                // }
        int maze[][] = {
            {1,0,0,0},
            {1,1,0,1},
            {1,1,0,0},
            {0,1,1,1}
        };
        ArrayList<String>ans=findPath(maze, 4);
        System.out.println(ans);

                
    }
}
        