import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static long ans;
    static int n;
    static long[][][] dp;
    static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new long[n + 1][10][1 << 10];

        for (int i = 1; i < 10; i++) {
            dp[1][i][1 << i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int last = 0; last < 10; last++) {
                for (int bit = 0; bit < (1 << 10); bit++) {
                    int tmp = bit | (1 << last);
                    if (last > 0) {
                        dp[i][last][tmp] += dp[i - 1][last - 1][bit] % MOD;
                    }

                    if (last < 9) {
                        dp[i][last][tmp] += dp[i - 1][last + 1][bit] % MOD;
                    }
                }
            }
        }
        long answer = 0;

        for (int last = 0; last < 10; last++) {
            answer += dp[n][last][(1 << 10) - 1];
            answer %= MOD;
        }
        System.out.print(answer);
    }
}