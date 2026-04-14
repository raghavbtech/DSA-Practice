public class FriendsProblem {
    public static int totWays(int n){
        //base case
        if(n==1 || n==2){
            return n;
        }
        //kaam
        //single
        int fnm1=totWays(n-1);

        //pairing
        int fnm2=(n-1)*totWays(n-2);


        return fnm1+fnm2;
    }

    //dp
    public static int dptotalways(int n){
        
        if(n<=1)return 1;
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;

        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+(i-1)*dp[i-2];
        }

        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(dptotalways(0));
    }

    
}
