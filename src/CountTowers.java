import java.util.*;
public class CountTowers {
    static final int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int t= in.nextInt();
        while(t-->0){
            int n=in.nextInt();
            int dp[][]=new int[n][2];
            //Base case
            dp[n-1][0]=1;//Just close at the top
            dp[n-1][1]=1; //Just close at the top
            //States
            //1.dp[i][0]=it represent's number of ways to fill i to n such that last row has 2 growing blocks
            //1.dp[i][1]=it represent's number of ways to fill i to n such that last row has 1 (1*2) growing blocks

            for(int i=n-2;i>=0;i--){
                long ways=0;
                ways=(ways+(long)4*dp[i+1][0])%MOD;
                ways=(ways+dp[i+1][1])%MOD;
                dp[i][0]=(int)ways%MOD;
                ways=0;
                ways=(ways+(long)2*dp[i+1][1])%MOD;
                ways=(ways+dp[i+1][0])%MOD;
                dp[i][1]=(int)ways%MOD;
            }
            System.out.println(dp[0][0]+dp[0][1]);
        }
    }
}
