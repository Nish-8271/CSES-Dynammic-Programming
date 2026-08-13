//https://cses.fi/problemset/task/3403
import java.util.*;

public class LongestCOmmonSubsequence {
    class Pair{
        int length;
        int value;
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n= in.nextInt();
        int m=in.nextInt();
        int[] arr1=new int[n];
        int[] arr2=new int[m];

        for(int i=0;i<n;i++){
            arr1[i]= in.nextInt();
        }
        for(int i=0;i<m;i++){
            arr2[i]= in.nextInt();
        }
        int[][] dp=new int[n+1][m+1];
        // dp[i][j] = LCS starting from index i in and index j in arr2
        //Base case -> if any one of has ended then it's not possible to making any more longer subseqquence

        //Now we have to store the decision taken at each point;
        for(int i=0;i<=n;i++){
            dp[i][m]=0;
        }
        for(int i=0;i<=m;i++){
            dp[n][i]=0;
        }
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(arr1[i]==arr2[j]){
                    dp[i][j]=1+dp[i+1][j+1];
                }else{
                    dp[i][j]=Math.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }
        System.out.println(dp[0][0]);
    }
}
