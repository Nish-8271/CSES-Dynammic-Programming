import java.util.*;
public class CoinComb2 {

    static int dp[][];
    static int coins[];
    static final int MOD = 1_000_000_007;
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n= in.nextInt();
       int x=in.nextInt();
       dp=new int[n][x+1];
//        for(int[] a:dp){
//            Arrays.fill(a,-1);
//        }
        coins=new int[n];
        for (int i = 0; i <n ; i++) {
            coins[i]=in.nextInt();
        }
        Arrays.sort(coins);
        for(int i=0;i<n;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<=x;i++){
            for(int j=0;j<n;j++){
                int ways=0;
                if(i-coins[j]>=0){
                    ways=(ways+dp[j][i-coins[j]])%MOD;
                }
                if(j+1<n){
                    ways=(ways+dp[j+1][i])%MOD;
                }
                dp[j][i]=ways%MOD;
            }
        }
        System.out.println(dp[0][x]);
        // 1d dp
//        int[] dp2 = new int[x + 1];
//        dp2[0] = 1;
//
//        for (int coin : coins) {
//            for (int sum = coin; sum <= x; sum++) {
//                dp2[sum] = (int)(((long)dp2[sum] + dp2[sum - coin]) % MOD);
//            }
//        }
//        System.out.println(dp2[x]);

    }
}
