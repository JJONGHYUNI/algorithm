import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, k;
    static int[] visited;

    static final int LEN = 100001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new int[LEN];
        bfs();
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        Arrays.fill(visited, Integer.MAX_VALUE);
        q.add(new int[]{n, 0});
        visited[n] = 0;
        int answer = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int pos = tmp[0];
            int cnt = tmp[1];

            if (pos == k) {
                answer = Math.min(answer, cnt);
            }

            int p = pos + 1;
            int pp = pos - 1;
            int ppp = pos * 2;

            if (k > pos) {
                if (ppp >= 0 && ppp < LEN &&  visited[ppp] > cnt) {
                    q.add(new int[]{ppp, cnt});
                    visited[ppp] = cnt;
                }

                if (p >= 0 && p < LEN && visited[p] > cnt + 1) {
                    q.add(new int[]{p, cnt + 1});
                    visited[p] = cnt + 1;
                }
            }

            if (pp >= 0 && pp < LEN && visited[pp] > cnt + 1) {
                q.add(new int[]{pp, cnt + 1});
                visited[pp] = cnt + 1;
            }
        }

        System.out.print(answer);
    }
}