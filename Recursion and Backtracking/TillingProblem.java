public class TillingProblem {
    public static int tillingProblem(int n){   //2xn is the floor size
        //base case
        if(n==0 || n==1){
            return 1;
        }

        //kaam
        //vertical
        int fnm1=tillingProblem(n-1);

        //horizontal
        int fnm2=tillingProblem(n-2);

        int totWays=fnm1+fnm2;
        
        return totWays;
    }

    public static int dpTillingProblem(int n){
        
        int[] dp=new int[n+1];

        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];

    }
    public static void main(String[] args) {
        
    }
}
