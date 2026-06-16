import java.util.*;
public class RemovingDigits {
        public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n= in.nextInt();
//        int dp[]=new int[n+1];
//        Arrays.fill(dp,-1);
//        dp[0]=0;
//        for(int i=1;i<=n;i++){
//            int temp=i;
//            dp[i]=Integer.MAX_VALUE;
//            while(temp>0){
//                int digit=temp%10;
//                temp/=10;
//                if(digit!=0){
//                    dp[i]=Math.min(dp[i],1+dp[i-digit]);
//                }
//            }
//        }
//        System.out.println(dp[n]);
            System.out.println(solve(n));
    }
    //Greedy approach -> works here but there is not any proof ,i.e; subtracting the largest digit at evey step
    static int solve(int n){
            int step=0;
            while(n>0){
                char maximumDigit='0';
                String a=Integer.toString(n);
                for(char i:a.toCharArray()){
                    maximumDigit=(char)Math.max(maximumDigit,i);
                }
                step++;
                n-=(maximumDigit-'0');
            }
            return step;
    }
}
