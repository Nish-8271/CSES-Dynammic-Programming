import java.util.*;
public class RectangleCutting {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int a=in.nextInt();
        int b=in.nextInt();
      solve(a,b);

    }
    static void solve(int a ,int b){
        int dp[][]=new int[a+1][b+1];
        for(int i=0;i<=a;i++){
            for(int j=0;j<=b;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                } else if (i==j) {
                    dp[i][j]=0;
                }
            }
        }
        for(int i=1;i<=a;i++){
            for(int j=1;j<=b;j++){
                //Cut along the row
                if(i==j)continue;
                int row=Integer.MAX_VALUE;
                for(int k=1;k<i;k++){
                    row=Math.min(row,dp[i-k][j]+dp[k][j]);
                }
                //Cut along column
                int col=Integer.MAX_VALUE;
                for(int k=1;k<j;k++){
                    col=Math.min(col,dp[i][j-k]+dp[i][k]);
                }
                dp[i][j]=1+Math.min(row,col);
            }
        }
        System.out.println(dp[a][b]);
    }
}
