import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int n, m;
    static StringBuilder sb = new StringBuilder();
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        answer = new int[m];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dfs(0, 0);
        System.out.print(sb);

    }

    private static void dfs(int idx, int cnt) {
        if (cnt == m) {
            for (int i = 0; i < m; i++) {
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        int before = 0;
        for (int i = idx; i < n; i++) {
            if (before == arr[i]) continue;
            answer[cnt] = arr[i];
            dfs(i, cnt + 1);
            before = arr[i];
        }
    }
}