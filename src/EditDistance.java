import java.util.*;
public class EditDistance {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s1= in.next();
        String s2= in.next();
        int n=s1.length();
        int m=s2.length();
        int dp[][]=new int[n+1][m+1];
//        dp[i][j]== means the minimum number of ops to to make the  substring(i,n1) ==substring(j,n2)
        //Base case , if one reaches it's end what's will be the required ops to make the 2nd same
        for(int i=0;i<=m;i++){
            dp[n][i]=m-i;
        }
        for(int i=0;i<=n;i++){
            dp[i][m]=n-i;
        }
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(s1.charAt(i)==s2.charAt(j)){
                    dp[i][j]=dp[i+1][j+1];
                }else {
                    int insertMin = Math.min(dp[i][j + 1], dp[i + 1][j]);
                    dp[i][j] = 1 + Math.min(insertMin, dp[i + 1][j + 1]);
                }
            }
        }
        System.out.println(dp[0][0]);
    }
}
