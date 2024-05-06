import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static List<List<Integer>> friends = new ArrayList<>();
    static boolean control = false;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        friends = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            friends.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            friends.get(a).add(b);
            friends.get(b).add(a);
        }

        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            visited[i] = true;
            dfs(i, 0);
        }

        if (control) {
            System.out.print(1);
            return;
        }
        System.out.print(0);
    }
    private static void dfs(int idx, int depth) {
        if (control) {
            return;
        }

        if (depth == 4) {
            control = true;
            return;
        }

        for (int cur : friends.get(idx)) {
            if (!visited[cur]) {
                visited[cur] = true;
                dfs(cur, depth + 1);
                visited[cur] = false;
            }
        }
    }
}