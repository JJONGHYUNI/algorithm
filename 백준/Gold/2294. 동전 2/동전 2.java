import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Set<Integer> coins = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            int coin = Integer.parseInt(br.readLine());
            if (coin > k) {
                continue;
            }
            coins.add(coin);
        }

        int[] dp = new int[k + 1];
        Arrays.fill(dp, 10001);
        dp[0] = 0;

        for (int coin : coins) {
            dp[coin] = 1;
            for (int i = 1; i <= k; i++) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        if (dp[k] == 10001) {
            System.out.print(-1);
            return;
        }
        System.out.print(dp[k]);
    }
}