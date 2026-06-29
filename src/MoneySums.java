import java.util.Scanner;

import static java.lang.System.in;

public class MoneySums {
    static Scanner in=new Scanner(System.in);
    public static void main(String[] args) {
        solve();
    }
    static void solve(){
        int n=in.nextInt();
        int coins[]=new int[n];

        for(int i=0;i<n;i++){
            coins[i]=in.nextInt();
        }

        boolean possible[]=new boolean[(int)(1e5+1)];
        possible[0]=true;

        for(int i=1;i<=n;i++){
            boolean temp[]=new boolean[(int)(1e5+1)];
            int curr=coins[i-1];

            for(int j=0;j+curr<=(int)1e5;j++){
                if(possible[j]){
                    temp[j]=true;          // don't take current coin
                    temp[j+curr]=true;     // take current coin
                }
            }

            // sums larger than 1e5-curr can still be carried forward
            for(int j=(int)1e5-curr+1;j<=(int)1e5;j++){
                if(possible[j]) temp[j]=true;
            }

            possible=temp;   // move this OUTSIDE the inner loop
        }

        int cnt=0;
        for(int i=1;i<=(int)1e5;i++){
            if(possible[i]) cnt++;
        }

        System.out.println(cnt);

        for(int i=1;i<=(int)1e5;i++){
            if(possible[i]){
                System.out.print(i+" ");
            }
        }
    }
}
