import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
            dp[n - i + 1][1] = 1;
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i][0] = Math.max(dp[j][0] + 1, dp[i][0]);
                }

                if (arr[n - i + 1] > arr[n - j + 1]) {
                    dp[n - i + 1][1] = Math.max(dp[n - j + 1][1] + 1, dp[n - i + 1][1]);
                }
            }
        }

        int ans = -1;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dp[i][0] + dp[i][1]);
        }

        System.out.print(ans - 1);
    }
}
