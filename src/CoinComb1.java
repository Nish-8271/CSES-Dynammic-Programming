import java.util.*;
public class CoinComb1 {
    static int x;
    static long dp[];
    static int coins[];
    static final int MOD = 1_000_000_007;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        x = in.nextInt();
        dp = new long[x + 1];
        Arrays.fill(dp, -1);
        coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = in.nextInt();
        }

//        int ans=solve(x);
//        System.out.println(ans);
        //iterative solution
        dp[0]=1; //we have found a waay to reach amount
        for(int i=1;i<=x;i++){
            dp[i]=0;
            for(int coin:coins){
                if(i-coin>=0){
                    dp[i]=(dp[i]%MOD+dp[i-coin]%MOD)%MOD;
                }
            }
        }
        System.out.println(dp[x]);
    }

//    private static int solve(int x) {
//        if(x<0)return 0;
//        if(x==0)return 1;//the amount finally became zero means there is a way to achieve the amount
//        if(dp[x]!=-1)return dp[x];
//        dp[x]=0;
//        for(int coin:coins){
//            dp[x]=(dp[x]+solve(x-coin))%MOD;
//        }
//        return dp[x]%MOD;
//    }

}
