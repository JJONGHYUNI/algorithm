import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static final int CHAR_ASCII = 97;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s = br.readLine().toCharArray();
        int n = Integer.parseInt(br.readLine());
        int len = s.length;

        StringTokenizer st;

        int cnt;
        int[][] dp = new int[len + 1][26];
        dp[1][s[0] - CHAR_ASCII] = 1;

        for (int i = 2; i <= len; i++) {
            dp[i][s[i - 1] - CHAR_ASCII] += 1;
            for (int j = 0; j < 26; j++) {
                dp[i][j] += dp[i - 1][j];
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0) - CHAR_ASCII;
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken()) + 1;
            sb.append(dp[r][a] - dp[l][a]).append("\n");
        }
        System.out.println(sb);
    }
}