import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int r, c;
    static char[][] map;
    static int[] d = {0, 0, -1, 1};
    static Queue<Pos> q = new LinkedList<>();

    static class Pos {
        int y, x, t;

        public Pos(int y, int x, int t) {
            this.y = y;
            this.x = x;
            this.t = t;
        }
    }

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        int y = 0, x = 0;

        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);

                // 물 먼저 큐에 넣고 (물이 찰 예정이면 못 가므로), 이후에 고슴도치 큐에 추가
                if (map[i][j] == '*') {
                    q.add(new Pos(i, j, -1));
                } else if (map[i][j] == 'S') {
                    y = i;
                    x = j;
                }
            }
        }

        q.add(new Pos(y, x, 0));
        bfs();
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            Pos p = q.poll();

            for (int i = 0; i < 4; i++) {
                int dy = p.y + d[i];
                int dx = p.x + d[3 - i];

                if (dy < 0 || dy >= r || dx < 0 || dx >= c) continue;

                if (map[dy][dx] == 'X') continue;

                if (map[dy][dx] == 'D' && p.t != -1) {
                    System.out.print(p.t + 1);
                    return;
                }

                if (map[dy][dx] == '.' && p.t == -1) {
                    map[dy][dx] = '*';
                    q.add(new Pos(dy, dx, -1));
                } else if (map[dy][dx] == '.' && p.t != -1) {
                    map[dy][dx] = 'S';
                    q.add(new Pos(dy, dx, p.t + 1));
                }
            }
        }

        System.out.print("KAKTUS");
    }
}