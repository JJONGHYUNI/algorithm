import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static char[][] map;
    static int n, m;
    static int[] d = new int[]{-1, 1, 0, 0};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];

        String s;

        for (int i = 0; i < n; i++) {
            s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'L') {
                    bfs(i, j);
                }
            }
        }

        System.out.print(answer);
    }

    private static void bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        q.add(new int[]{y, x, 0});
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int curY = tmp[0];
            int curX = tmp[1];
            int cnt = tmp[2];
            answer = Math.max(answer, cnt);

            for (int i = 0; i < 4; i++) {
                int dy = curY + d[i];
                int dx = curX + d[3 - i];

                if (dy >= 0 && dy < n && dx >= 0 && dx < m) {
                    if (visited[dy][dx] || map[dy][dx] == 'W') {
                        continue;
                    }
                    visited[dy][dx] = true;
                    q.add(new int[]{dy, dx, cnt + 1});
                }
            }
        }
    }

}