import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static class Pos {
        int y, x, cost;
        boolean sword;

        public Pos(int y, int x, int cost, boolean sword) {
            this.y = y;
            this.x = x;
            this.cost = cost;
            this.sword = sword;
        }
    }

    static int n, m, t;
    static int[][] map;
    static int[] d = new int[]{-1, 1, 0, 0};
    static int distance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 명검 없이 최단 거리와 명검 위치 반환
        Pos tmp = bfs(new Pos(0, 0, 0, false));
        if (tmp != null) {
            bfs(tmp);
        }

        if (distance == Integer.MAX_VALUE) {
            System.out.print("Fail");
            return;
        }
        System.out.print(distance);
    }

    private static Pos bfs(Pos pos) {
        Queue<Pos> q = new LinkedList<>();
        q.add(pos);
        boolean[][] visited = new boolean[n][m];
        visited[pos.y][pos.x] = true;
        int dy, dx;
        Pos swordPos = null;

        while (!q.isEmpty()) {
            Pos cur = q.poll();
            if (cur.y == n - 1 && cur.x == m - 1 && cur.cost <= t) {
                distance = Math.min(distance, cur.cost);
                return swordPos;
            }
            for (int i = 0; i < 4; i++) {
                dy = cur.y + d[i];
                dx = cur.x + d[3 - i];

                if (dy < 0 || dy >= n || dx < 0 || dx >= m) {
                    continue;
                }

                if (visited[dy][dx]) {
                    continue;
                }

                visited[dy][dx] = true;

                if (map[dy][dx] == 0) {
                    q.add(new Pos(dy, dx, cur.cost + 1, cur.sword));
                } else if (map[dy][dx] == 1) {
                    if (cur.sword) {
                        q.add(new Pos(dy, dx, cur.cost + 1, cur.sword));
                    }
                } else {
                    q.add(new Pos(dy, dx, cur.cost + 1, true));
                    swordPos = new Pos(dy, dx, cur.cost + 1, true);
                }
            }
        }
        return swordPos;
    }

}