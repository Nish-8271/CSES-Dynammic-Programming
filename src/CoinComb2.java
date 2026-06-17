import java.util.*;
public class CoinComb2 {

    static int dp[][];
    static int coins[];
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n= in.nextInt();
       int x=in.nextInt();
        dp=new int[n+1][x+1];
//        for(int[] a:dp){
//            Arrays.fill(a,-1);
//        }
        coins=new int[n];
        for (int i = 0; i <n ; i++) {
            coins[i]=in.nextInt();
        }
//        System.out.println(solve(0,x));
        for(int i=n-1;i>=0;i--){
            dp[i][0]=1; //Base case
        }
        for(int i=n-1;i>=0;i--){
            for(int j=1;j<=x;j++){
                long ways=0;
                if(i+1<n)ways=(ways+dp[i+1][j])%MOD;
                if(j-coins[i]>=0)ways=(ways+dp[i][j-coins[i]])%MOD;
                dp[i][j]=(int)ways%MOD;
            }
        }
        System.out.println(dp[0][x]);
    }
    private static int solve(int i, int x) {
        if(x<0)return 0;
        if(x==0)return 1;
        if(i==coins.length)return 0;
        if(dp[i][x]!=-1){
            return dp[i][x]%MOD;
        }
        return dp[i][x]=(int)(((long)solve(i+1,x)%MOD + (long)solve(i,x-coins[i])%MOD) % MOD);
    }
}
