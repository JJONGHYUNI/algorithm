import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 0은 안 지운거, 1은 지운 경우
        int[][] dp = new int[n + 1][2];
        dp[1][0] = arr[1];

        int answer = arr[1];

        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.max(arr[i], dp[i - 1][0] + arr[i]);
            dp[i][1] = Math.max(dp[i - 1][1] + arr[i], dp[i - 1][0]);

            answer = Math.max(Math.max(answer, dp[i][0]), dp[i][1]);
        }

        System.out.print(answer);
    }
}