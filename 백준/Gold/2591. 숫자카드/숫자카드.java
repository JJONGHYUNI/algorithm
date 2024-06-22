import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        char[] s = br.readLine().toCharArray();
        int len = s.length;
        int[][] dp = new int[len + 1][3];
        if (Character.getNumericValue(s[0]) != 0) {
            dp[1][1] = 1;
        }
        int tmp, pre = Character.getNumericValue(s[0]) * 10;

        for (int i = 2; i <= len; i++) {
            tmp = Character.getNumericValue(s[i - 1]);

            if (tmp == 0) {
                if (pre + tmp < 35) {
                    dp[i][2] = dp[i - 1][1];
                }
                continue;
            }
            dp[i][1] = dp[i - 1][1] + dp[i - 1][2];
            if (pre + tmp < 35) {
                dp[i][2] = dp[i - 1][1];
            }

            pre = tmp * 10;
        }
        System.out.print(dp[len][1] + dp[len][2]);
    }
}