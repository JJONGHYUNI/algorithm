import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n][n];
        int[][] arr = new int[n][n];
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = arr[i][j];
                if (tmp == 0) {
                    continue;
                }
                if (i + tmp < n) {
                    dp[i + tmp][j] += dp[i][j];
                }
                if (j + tmp < n) {
                    dp[i][j + tmp] += dp[i][j];
                }
            }
        }
        System.out.print(dp[n-1][n-1]);
     }
}