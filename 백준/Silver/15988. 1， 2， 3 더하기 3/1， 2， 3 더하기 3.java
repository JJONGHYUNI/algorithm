import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        long[] dp = new long[1_000_001];
        final int MOD = 1_000_000_009;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        int tmp = 3;
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            if (tmp >= n) {
                System.out.println(dp[n]);
                continue;
            }

            for (int j = tmp + 1; j < n + 1; j++) {
                dp[j] += (dp[j - 1] + dp[j - 2] + dp[j -3]) % MOD;
            }
            System.out.println(dp[n]);
            tmp = n;
        }
     }
}