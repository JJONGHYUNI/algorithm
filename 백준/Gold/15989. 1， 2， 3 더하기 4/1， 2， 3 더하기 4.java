import java.io.*;
import java.util.*;

/*
dp[1] = 1   1
dp[2] = 2   1 1 , 2
dp[3] = 3   1 1 1, 1 2, 3
dp[4] = 4   1 1 1 1, 1 1 2, 1 3, 2 2
dp[5] =     1 1 1 1 1, 1 1 1 2, 1 2 2, 1 1 3, 2 3
 */
class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[][] dp = new int[10000 + 1][4];
        dp[1][1] = dp[2][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;
        int n;

        for (int i = 4; i < 10001; i++) {
            dp[i][1] = dp[i - 1][1];
            dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
            dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            sb.append(Arrays.stream(dp[n]).sum()).append("\n");
        }

        System.out.print(sb);
    }
}