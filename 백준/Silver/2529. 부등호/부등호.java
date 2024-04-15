import java.util.*;
import java.io.*;


public class Main {
    static int k;
    static String[] arr;
    static int[] answer;
    static boolean[] visited;
    static long MAX = 0;
    static long MIN = Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new String[k];
        answer = new int[k + 1];
        visited = new boolean[10];
        for (int i = 0; i < k; i++) {
            arr[i] = st.nextToken();
        }
        dfs(0);
        System.out.println(MAX);
        String min = Long.toString(MIN);
        if (min.length() != k + 1) {
            String tmp = "";
            for (int i = 0; i < k + 1 - min.length(); i++) {
                tmp += "0";
            }
            tmp += min;
            min = tmp;
        }
        System.out.print(min);
    }

    private static void dfs(int cnt) {
        if (cnt == k + 1) {
            boolean control = true;
            String ans = "";
            for (int i = 0; i < k; i++) {
                if (arr[i].equals("<") && answer[i] < answer[i + 1]) {
                    continue;
                }
                if (arr[i].equals(">") && answer[i] > answer[i + 1]) {
                    continue;
                }
                control = false;
                break;
            }
            if (control) {
                for (int a : answer) {
                    ans += Integer.toString(a);
                }
                Long tmp = Long.parseLong(ans);
                MAX = Math.max(MAX, tmp);
                MIN = Math.min(MIN, tmp);
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!visited[i]) {
                answer[cnt] = i;
                visited[i] = true;
                dfs(cnt + 1);
                visited[i] = false;
            }
        }
    }
}
