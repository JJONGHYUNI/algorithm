import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static final int LEN = 1_000_001;
    private static final int MOD = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[][] dp = new long[LEN][4];
        dp[1] = new long[]{0, 1, 0, 0};
        dp[2] = new long[]{0, 0, 1, 0};
        dp[3] = new long[]{0, 1, 1, 1};

        int t = Integer.parseInt(br.readLine());

        for (int i = 4; i < LEN; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % MOD;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % MOD;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append((dp[n][1] + dp[n][2] + dp[n][3]) % MOD).append("\n");
        }
        System.out.print(sb);
    }
}