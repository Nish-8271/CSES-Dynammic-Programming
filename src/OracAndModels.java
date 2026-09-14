//https://codeforces.com/problemset/problem/1350/B
import java.io.*;
import java.util.*;

public class OracAndModels {
    static OracAndModels.FastReader in;
    static PrintWriter out;

    public static void main(String[] args) throws IOException {
        in = new OracAndModels.FastReader();
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = in.nextInt(); // number of test cases (remove if single test case)
        while (t-- > 0) {
            solve();
        }
        out.flush();
        out.close();
    }

    static void solve() throws IOException {
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = in.nextInt();

        int[] dp=new int[n+1];
        Arrays.fill(dp,1);
//      State: dp[i]=> Represents the maximum number of models can be bought with satisfying the condition
        for (int i = 0; i < n; i++) {
            int pos = i + 1;
            for (int multiple = 2 * pos; multiple <= n; multiple += pos) {
                int j = multiple - 1;
                if (arr[j] > arr[i]) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }

        System.out.println(arrMax(dp));
    }
    //-------Array Max--------
    static int arrMax(int[] arr){
        int max=Integer.MIN_VALUE;
        for(int i:arr){
            max=Math.max(max,i);
        }
        return max;
    }
    // ---------- Fast I/O ----------
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        String nextLine() throws IOException {
            return br.readLine();
        }

        int[] nextIntArray(int n) throws IOException {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = nextInt();
            return arr;
        }

        long[] nextLongArray(int n) throws IOException {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) arr[i] = nextLong();
            return arr;
        }
    }
}
