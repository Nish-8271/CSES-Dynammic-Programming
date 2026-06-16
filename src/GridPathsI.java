import java.util.*;
public class GridPathsI {
    static int n;
    static List<String> list;
    static final int MOD=1_000_000_007;
    public static void main(String[] args) {
         list =new ArrayList<>();
        Scanner in=new Scanner(System.in);
        n=in.nextInt();
        for(int i=0;i<n;i++){
            list.add((in.next().toString()));
        }
        System.out.println(solve());
        }
        static int solve(){
        int dp[][]=new int[n][n];
        if(list.get(0).charAt(0)=='*')return 0;
        if(list.get(n-1).charAt(n-1)=='*')return 0;
        dp[0][0]=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0)continue;
                int ways=0;
                if(list.get(i).charAt(j)=='*'){
                    dp[i][j]=0;
                    continue;
                }
                if(i-1>=0){
                    ways+=dp[i-1][j];
                }
                if(j-1>=0){
                    ways+=dp[i][j-1];
                }
                dp[i][j]=ways%MOD;
            }
        }
        return dp[n-1][n-1];
        }
    }
