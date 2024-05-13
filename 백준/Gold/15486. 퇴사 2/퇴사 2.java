import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] t = new int[n + 1];
        int[] p = new int[n + 1];

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1];
        int max = 0;

        for (int i = 0; i <= n; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }

            if (i + t[i] > n) {
                continue;
            }

            dp[i + t[i]] = Math.max(dp[i + t[i]], max + p[i]);
        }
        
        System.out.print(max);
    }

}