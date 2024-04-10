import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] dp = new int[41];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        int previous = 0;
        int answer = 1;
        for (int i = 0; i < m; i++) {
            int tmp = Integer.parseInt(br.readLine());
            answer *= dp[tmp - previous - 1];
            previous = tmp;
        }
        answer *= dp[n - previous];
        System.out.println(answer);
    }
}
