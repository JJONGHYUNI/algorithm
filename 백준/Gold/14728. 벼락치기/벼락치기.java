import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, t, answer = 0;
    static int[] times;
    static int[] scores;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        times = new int[n + 1];
        scores = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            times[i] = Integer.parseInt(st.nextToken());
            scores[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n + 1][t + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= t; j++) {
                if (times[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - times[i]] + scores[i]);
                    continue;
                }
                dp[i][j] = dp[i - 1][j];
            }
        }

        System.out.print(dp[n][t]);
    }

    // 시간 복잡도 2^100 ?
//    private static void dfs(int idx, int time, int score) {
//        if (time <= 0 || idx >= n) {
//            answer = Math.max(score, answer);
//            return;
//        }
//
//        for (int i = idx; i < n; i++) {
//            if (visited[i] || time - times[i] < 0) {
//                continue;
//            }
//
//            visited[i] = true;
//            dfs(i + 1, time - times[i], score + scores[i]);
//            visited[i] = false;
//        }
//    }
}