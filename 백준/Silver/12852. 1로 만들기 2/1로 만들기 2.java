import java.util.*;
import java.io.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        int dp[] = new int[x + 1];
        int line[] = new int[x + 1];

        dp[1] = 0;

        for (int i = 2; i <= x; i++) {
            dp[i] = dp[i - 1] + 1;
            line[i] = i - 1;

            if (isThree(i) && dp[i / 3] + 1 < dp[i]) {
                dp[i] =  dp[i / 3] + 1;
                line[i] = i / 3;
            }

            if (isTwo(i) && dp[i / 2] + 1 < dp[i]) {
                dp[i] = dp[i / 2] + 1;
                line[i] = i / 2;
            }
        }
        System.out.println(dp[x]);
        String answer = "";
        while(x != 0) {
            answer += x + " ";
            x = line[x];
        }
        System.out.print(answer);
    }

    private static boolean isThree(int n) {
        return n % 3 == 0;
    }

    private static boolean isTwo(int n) {
        return n % 2 == 0;
    }
}
