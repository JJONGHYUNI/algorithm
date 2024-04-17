import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cards = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n + 1];
        dp[1] = cards[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = cards[i - 1];
            for (int j = 1; j < i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j] + cards[j - 1]);
            }
        }
        System.out.print(dp[n]);
    }
}