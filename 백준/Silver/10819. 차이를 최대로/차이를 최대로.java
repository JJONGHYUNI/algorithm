import java.util.*;
import java.io.*;
import java.util.stream.IntStream;


public class Main {
    static int answer = -1;
    static int[] arr;
    static int[] nums;
    static boolean[] visited;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[n];
        nums = new int[n];
        dfs(0);
        System.out.println(answer);
    }

    private static void dfs(int cnt) {
        if (cnt == n) {
            int tmp = 0;
            for (int i = 0; i < n - 1; i++) {
                tmp += Math.abs(nums[i] - nums[i + 1]);
            }
            answer = Math.max(answer, tmp);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                nums[cnt] = arr[i];
                visited[i] = true;
                dfs(cnt + 1);
                visited[i] = false;
            }
        }
    }
}