import java.io.*;
import java.util.*;

class Main {
/**
 * 큰 알약은 우선으로 한 개 먹고
 * 0 : H = 1
 * 1 : W H = 1
 * 2 : W HWH, W WHH = 0 * 1 + 1 * 0
 * 3 :
 * 큰작 2개 -> 작은 알약 1개 : W WHWH H, W WWHH H
 * 큰작 1개 -> 작은 알약 1개 -> 큰 알약 1개 : W WH H WH
 * 작은 알약 1개 -> 큰작 2개 : W H WHWH, W H WWHH
 * 4 : 작은 알약 먹는 경우의 수는 1 이므로 생략 가능
 * 큰작 3개 -> 작은 알약 1개 : dp[3] * dp[0]
 * 큰작 2개 -> 작은 알약 1개 -> 큰작 1개 : dp[2] * dp[0] * dp[1]
 * 큰작 1개 -> 작은 알약 1개 -> 큰작 2개 : dp[1] * dp[0] * dp[2]
 * 작은 알약 1개 -> 큰작 3개 : dp[0] * dp[3]
 *
 * 점화식 : dp[i] = dp[i - j - 1] * dp[j]
 */
public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        long[] dp = new long[31];
        dp[0] = dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= 30; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) {
                return;
            }
            System.out.println(dp[n]);
        }
    }
}