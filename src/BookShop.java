import java.util.*;
public class BookShop {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int  n=in.nextInt();
         int x=in.nextInt();
         int prices[]=new int[n];
        for(int i=0;i<n;i++)prices[i]=in.nextInt();
         int pages[]=new int[n];
        for(int i=0;i<n;i++)pages[i]=in.nextInt();
//        dp=new int[n][x+1];
//        for(int[] a:dp){
//            Arrays.fill(a,-1);
//        }
//        for(int i=0;i<n;i++){
//            dp[i][0]=0;
//        }
        int dp[]=new int[x+1];
//        Arrays.fill(dp,-1);
        // Dp[i] = represents maximum amount of pages that can be bought using amount x
         dp[0]=0;


        for (int i = 0; i < n; i++) {
            for (int money = x; money >= prices[i]; money--) {
                dp[money] = Math.max(
                        dp[money],
                        dp[money - prices[i]] + pages[i]
                );
            }
        }

        System.out.println(dp[x]);
//        boolean bought[]=new boolean[n];
//        int ans=solve(x,0,bought);
//        System.out.println(ans);
    }
//    static int solve(int amount,int curr,boolean[] bought){
//        if(amount==0)return 0;
//        if(curr>=n)return 0;
//        if(dp[curr][amount]!=-1)return dp[curr][amount];
//        int ans=solve(amount,curr+1,bought);
//        for(int i=curr;i<n;i++){
//            if(!bought[i]){
//                if(amount-prices[i]>=0){
//                    bought[i]=true;
//                  ans=Math.max(ans,solve(amount-prices[i],i+1,bought)+pages[i]);
//                }
//            }
//            bought[i]=false;//backtrack
//        }
//        return dp[curr][amount]=ans;
//    }

}
