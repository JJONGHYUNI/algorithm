import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, a, b;
    static List<List<Integer>> relations = new ArrayList<>();
    static boolean[] visited;
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            relations.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            relations.get(x).add(y);
            relations.get(y).add(x);
        }

        q.add(new int[]{a, 0});
        visited[a] = true;
        bfs();
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int x = tmp[0];
            int cnt = tmp[1];

            if (x == b) {
                System.out.print(cnt);
                return;
            }

            for (int y : relations.get(x)) {
                if (!visited[y]) {
                    q.add(new int[]{y, cnt + 1});
                    visited[y] = true;
                }
            }
        }
        System.out.print(-1);
    }

}