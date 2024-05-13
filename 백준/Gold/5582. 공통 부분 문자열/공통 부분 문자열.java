import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String s2 = br.readLine();
        int[][] dp = new int[s.length() + 1][s2.length() + 1];

        int max = 0;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        System.out.print(max);
    }

}