import java.util.*;

public class ClassyNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int L = sc.nextInt();
            int R = sc.nextInt();
            int ans = 0;
            int temp=L;
            for (int i = L; i <= R; i++) {
                if (i <= 1109) ans++;
                else if (isClassy(i)) {
                    System.out.print(i-temp+" ");
                    temp=i;
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }
   static boolean isClassy(int n){
        int t=0;
        while(n>0){
            t+=(n%10!=0)?1:0;
            n/=10;
        }
        return t<=3;
    }
}
