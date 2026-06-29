import java.util.*;

public class CountTowers {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        int[] queries = new int[t];

        int maxN = 0;
        for (int i = 0; i < t; i++) {
            queries[i] = in.nextInt();
            maxN = Math.max(maxN, queries[i]);
        }

        long[][] dp = new long[maxN + 1][2];

        // Base case
        dp[1][0] = 1;
        dp[1][1] = 1;

        // Precompute once
        for (int i = 2; i <= maxN; i++) {
            dp[i][0] = (4 * dp[i - 1][0] + dp[i - 1][1]) % MOD;
            dp[i][1] = (dp[i - 1][0] + 2 * dp[i - 1][1]) % MOD;
        }

        StringBuilder ans = new StringBuilder();

        for (int n : queries) {
            long ways = (dp[n][0] + dp[n][1]) % MOD;
            ans.append(ways).append('\n');
        }

        System.out.print(ans);
    }
}