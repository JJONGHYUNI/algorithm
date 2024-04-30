import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] wines = new int[n];
        for (int i = 0; i < n; i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[n][3];
        dp[0][0] = 0;
        dp[0][1] = wines[0];
        dp[0][2] = 0;

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][0] = Math.max(dp[i][0], dp[i - 1][2]);
            dp[i][1] = dp[i - 1][0] + wines[i];
            dp[i][2] = dp[i - 1][1] + wines[i];
        }

        System.out.print(Arrays.stream(dp[n - 1]).max().getAsInt());
    }
}