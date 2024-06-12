import java.io.*;
import java.util.*;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        find();

    }

    private static void find() {
        // 0은 서남, 1은 남, 2는 동남
        int[][][] dp = new int[n + 1][m][3];
        for (int j = 0; j < m; j++) {
            dp[1][j][0] = map[0][j];
            dp[1][j][1] = map[0][j];
            dp[1][j][2] = map[0][j];

        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], 100001);
                if (j == 0) {
                    dp[i][j][0] = Math.min(dp[i - 1][j + 1][1] + map[i - 1][j], dp[i][j][0]);
                    dp[i][j][0] = Math.min(dp[i - 1][j + 1][2] + map[i - 1][j], dp[i][j][0]);
                    dp[i][j][1] = dp[i - 1][j][0] + map[i - 1][j];
                    continue;
                }
                if (j == m - 1) {
                    dp[i][j][2] = Math.min(dp[i - 1][j - 1][1] + map[i - 1][j], dp[i][j][2]);
                    dp[i][j][2] = Math.min(dp[i - 1][j - 1][0] + map[i - 1][j], dp[i][j][2]);
                    dp[i][j][1] = dp[i - 1][j][2] + map[i - 1][j];
                    continue;
                }
                dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + map[i - 1][j];
                dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + map[i - 1][j];
                dp[i][j][2] = Math.min(dp[i - 1][j - 1][0], dp[i - 1][j - 1][1]) + map[i - 1][j];
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            answer = Math.min(dp[n][j][0], answer);
            answer = Math.min(dp[n][j][1], answer);
            answer = Math.min(dp[n][j][2], answer);
        }

        System.out.print(answer);
    }
}