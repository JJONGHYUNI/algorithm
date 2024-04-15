import java.util.*;
import java.io.*;


public class Main {
    static int n, m, r;
    static List<List<Integer>> arr = new ArrayList<>();
    static boolean[] visited;
    static int[] answer;
    static int cnt = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            arr.get(a).add(b);
            arr.get(b).add(a);
        }
        for (List<Integer> a : arr) {
            Collections.sort(a);
        }
        visited = new boolean[n];
        answer = new int[n];
        answer[r - 1] = cnt;
        dfs(r - 1);

        for (int a : answer) {
            System.out.println(a);
        }
    }

    private static void dfs(int start) {
        visited[start] = true;
        List<Integer> tmp = arr.get(start);
        for (int i : tmp) {
            if (!visited[i]) {
                cnt += 1;
                answer[i] = cnt;
                visited[i] = true;
                dfs(i);
            }
        }
    }
}
