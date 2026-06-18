import java.util.*;
public class ArrayDesc {
    static final int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n= in.nextInt();
        int m=in.nextInt();
        int arr[]=new int[n];
        int dp[][]=new int[n][m+1];
        for (int i = 0; i < n; i++) {
            arr[i]=in.nextInt();
        }
        for(int[] a:dp){
            Arrays.fill(a,0);
        }
        if(arr[0]==0) {
            for (int i = 1; i <= m; i++) {
                dp[0][i]=1;
            }
        }else{
            //dp[0][anything]=0 //By default it's zero in java
            dp[0][arr[0]]=1;
        }
        for(int i=1;i<n;i++){
            for(int x=1;x<=m;x++){
                if(arr[i]!=0 && arr[i]!=x) continue;
                if(x-1>=0)dp[i][x]=(int)((long)(dp[i][x]+dp[i-1][x-1])%MOD);
                if(x+1<=m)dp[i][x]=(int)((long)(dp[i][x]+dp[i-1][x+1])%MOD);
                dp[i][x]=(int)((long)(dp[i][x]+dp[i-1][x]%MOD));
            }
        }
        int ans=0;
        for(int i=1;i<=m;i++){
            ans=(ans+dp[n-1][i]%MOD)%MOD;
        }
        System.out.println(ans%MOD);
    }
}
