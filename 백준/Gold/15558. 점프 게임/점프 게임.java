import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, k;
    static int[][] line;
    static boolean[][] visited;

    static class Pos {
        int y, x;
        int time;

        public Pos(int y, int x, int time) {
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        line = new int[2][n];
        visited = new boolean[2][n];

        for (int i = 0; i < 2; i++) {
            String s = br.readLine();

            for (int j = 0; j < n; j++) {
                line[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }
        bfs();
    }

    private static void bfs() {
        Queue<Pos> q = new ArrayDeque<>();
        q.add(new Pos(0, 0, 0));
        visited[0][0] = true;
        int[] d = new int[]{k, 1, -1};

        while (!q.isEmpty()) {
            Pos pos = q.poll();
            int dx, dy;
            for (int i = 0; i < 3; i++) {
                dx = pos.x + d[i];
                dy = 1 - pos.y;

                if (dx > n - 1) {
                    System.out.print(1);
                    return;
                }

                if (i == 0) {
                    if (dx > pos.time && line[dy][dx] == 1 && !visited[dy][dx]) {
                        visited[dy][dx] = true;
                        q.add(new Pos(dy, dx, pos.time + 1));
                    }
                    continue;
                }

                if (dx > pos.time && line[pos.y][dx] == 1 && !visited[pos.y][dx]) {
                    visited[pos.y][dx] = true;
                    q.add(new Pos(pos.y, dx, pos.time + 1));
                }
            }
        }
        System.out.print(0);
    }
}