//https://cses.fi/problemset/task/3359

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.*;
public class MinimalGridPath {
        static FastReader in;
        static PrintWriter out;
        public static void main(String[] args) throws IOException {
            in = new FastReader();
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
//            int t = in.nextInt(); // number of test cases (remove if single test case)
//            while (t-- > 0) {
//                solve();
//            }
            solve();
            out.flush();
            out.close();
        }

        static void solve() throws IOException {
                int n= in.nextInt();
                String[] mat=new String[n];
                for(int i=0;i<n;i++){
                    mat[i]=in.next();
                }
                char[][] matrix=new char[n][n];
                boolean[][] visited=new boolean[n][n];
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        matrix[i][j]=mat[i].charAt(j);
                    }
                }
                Queue<int[]> queue=new LinkedList<>();
                queue.offer(new int[]{0,0});
                visited[0][0]=true;
            StringBuilder sb=new StringBuilder();
            sb.append(matrix[0][0]);
            while(!queue.isEmpty()){

            }
        }
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

