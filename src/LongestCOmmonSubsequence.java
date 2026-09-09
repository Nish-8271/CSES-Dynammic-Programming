//https://cses.fi/problemset/task/3403
import java.util.*;

public class LongestCOmmonSubsequence {
    static class Pair{
        int length;
        boolean choosen;
        Pair(){
            this.choosen=false;
        }
        Pair(int length){
            this.length=length;
            this.choosen=false;
        }
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

        Pair[][] dp=new Pair[n+1][m+1];
        for(Pair[] arr:dp){
            Arrays.fill(arr,new Pair());
        }
        // dp[i][j] = LCS starting from index i in and index j in arr2
        //Base case -> if any one of has ended then it's not possible to make any more longer subseqquence

        //Now we have to store the decision taken at each point;
        for(int i=0;i<=n;i++){
            dp[i][m].length=0;
        }
        for(int i=0;i<=m;i++){ 
            dp[n][i].length=0;
        }
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(arr1[i]==arr2[j]){
                    dp[i][j].length=1+dp[i+1][j+1].length;
                    dp[i][j].choosen=true;
                }else{
                    dp[i][j].length=Math.max(dp[i][j+1].length,dp[i+1][j].length);
                }
            }
        }
        System.out.println(dp[0][0].length);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(dp[i][j].choosen==true){
                    System.out.print(arr1[i]+" ");
                    continue;
                }
            }
        }
    }
}
