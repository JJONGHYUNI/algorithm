import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] a, b;
    static int[][] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        b = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], - 1);
        }

        System.out.print(solve(0, 0));
    }

    private static int solve(int l, int r) {
        if (l == n || r == n) {
            return 0;
        }

        if (dp[l][r] != -1) {
            return dp[l][r];
        }
        
        dp[l][r] = Math.max(solve(l + 1, r + 1), solve(l + 1, r));

        if (a[l] > b[r]) {
            dp[l][r] = Math.max(dp[l][r], solve(l, r + 1) + b[r]);
        }

        return dp[l][r];
    }
}