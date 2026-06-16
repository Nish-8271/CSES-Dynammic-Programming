import java.util.*;
public class Dice {
    static final int MOD=1_000_000_007;
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
       int n=in.nextInt();
//       dp=new int[n+1];
//       Arrays.fill(dp,-1);
//        solve(n);
        //Let's solve in iterative way
        //State : dp[i]=number of ways to make sum==i
        //Transition: dp[i]=dp[i-1]+dp[i-2]....+dp[i-6]
        //final problem : dp[n]
        int prev[]={0,0,0,0,0,1};//dp[0]=1,dp[-1]=0,...dp[-5]=0
        int curr[]=new int[6];
        for(int i=1;i<=n;i++){
            for(int j=1;j<6;j++){
                curr[j-1]=prev[j]%MOD;
            }
            long ways=0;
            for(int j=0;j<6;j++){
                ways=(ways+prev[j])%MOD;
            }
            curr[5]=(int)ways%MOD;
            for(int j=0;j<6;j++){
                prev[j]=curr[j];
            }
        }
        System.out.println(curr[5]);
    }
}
