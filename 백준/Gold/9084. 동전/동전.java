import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] coins = new int[n];
            for (int j = 0; j < n; j++) {
                coins[j] = Integer.parseInt(st.nextToken());
            }
            int m = Integer.parseInt(br.readLine());
            int[] dp = new int[m + 1];
            for (int coin: coins) {
                for(int k = 1; k <= m; k++) {
                    if (k - coin > 0) {
                        dp[k] += dp[k-coin];
                    } else if (k - coin == 0) {
                        dp[k]++;
                    }
                }
            }
            sb.append(dp[m] + "\n");
        }
        System.out.println(sb);
    }
}