import java.util.Arrays;

public class KnightsTour {
    static int[] nextRowPos={-2,-2,-1,1,-1,1,2,2};
    static int[] nextColPos={1,-1,2,2,-2,-2,1,-1};
    public static boolean solve(int x,int y,int[][] ans,int number,int n){
        //base case
        if(number==n*n){
            return true;
        }

        //recursion
        for(int i=0;i<8;i++){
            int nextRow=x+nextRowPos[i];
            int nextCol=y+nextColPos[i];
            if(nextRow>=0 && nextCol>=0 && nextRow<n && nextCol<n && ans[nextRow][nextCol]==-1){
                ans[nextRow][nextCol]=number;

                if(solve(nextRow, nextCol, ans, number+1, n)){
                    return true;
                };
                ans[nextRow][nextCol]=-1;
            }
        }
        return false;
    }
    public static int[][] nKnights(int n){
        int[][] ans=new int[n][n];
        for(int[] arr:ans){
            Arrays.fill(arr, -1);
        }
        ans[0][0]=0;
        solve(0,0,ans,1,n);
        return ans;

    }
    public static void main(String[] args) {
        int n=8;
        int[][] ans=nKnights(n);
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
        
    }
}
