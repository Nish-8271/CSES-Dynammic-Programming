import java.util.*;
public class MinCoins {
    static int dp[];
    static int coins[];
    static final int INF = Integer.MAX_VALUE / 2;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        coins = new int[n];
        dp = new int[x + 1];
        for (int i = 0; i < n; i++)
            coins[i] = in.nextInt();
        Arrays.fill(dp, -1);
//        int ans = solve(x);
//        if (ans >= INF)
//            System.out.println(-1);
//        else
//            System.out.println(ans);
        dp[0]=0;
        for(int i=1;i<=x;i++){
            dp[i]=INF;
            for(int coin:coins){
                if(i-coin>=0){
                    dp[i]=Math.min(dp[i],1+dp[i-coin]);
                }
            }
        }
        if(dp[x]==INF){
            System.out.println(-1);
        }else{
            System.out.println(dp[x]);
        }
    }
    private static int solve(int x) {
        if (x < 0)
            return INF;
        if (x == 0)
            return 0;
        if (dp[x] != -1)
            return dp[x];
        int temp = INF;
        for (int i = 0; i < coins.length; i++) {
            temp = Math.min(temp, 1 + solve(x - coins[i]));
        }
        return dp[x] = temp;
    }
}