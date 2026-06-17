import java.util.*;
public class CoinComb2 {

//    static int dp[][];
    static int coins[];
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n= in.nextInt();
       int x=in.nextInt();

//        for(int[] a:dp){
//            Arrays.fill(a,-1);
//        }
        coins=new int[n];
        for (int i = 0; i <n ; i++) {
            coins[i]=in.nextInt();
        }
//        System.out.println(solve(0,x));

        // 1d dp
        int[] dp2 = new int[x + 1];
        dp2[0] = 1;

        for (int coin : coins) {
            for (int sum = coin; sum <= x; sum++) {
                dp2[sum] = (int)(((long)dp2[sum] + dp2[sum - coin]) % MOD);
            }
        }

        System.out.println(dp2[x]);
    }

}
