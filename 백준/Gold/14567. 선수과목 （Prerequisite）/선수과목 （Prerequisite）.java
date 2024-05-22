import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<List<Integer>> arr = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        arr.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }

        int a, b;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            arr.get(b).add(a);
        }

        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            if (arr.get(i).isEmpty()) {
                continue;
            }

            for (int j : arr.get(i)) {
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            sb.append(dp[i]).append(" ");
        }
        System.out.print(sb);

    }
}