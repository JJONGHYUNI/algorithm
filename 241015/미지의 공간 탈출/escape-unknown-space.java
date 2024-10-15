import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Abnormal> abnormals = new ArrayList<>();
    static int[][] map;
    static int[][][] timeSpace;
    static int n, m, f;
    static Pos start;
    static int ey, ex;
    static int ty, tx;

    static class Abnormal {
        int y, x, d, v;

        Abnormal(int y, int x, int d, int v) {
            this.y = y;
            this.x = x;
            this.d = d;
            this.v = v;
        }
    }

    static class Pos {
        int y, x, d, t;

        // d =  0, 1, 2, 3, 4, 5(동 서 남 북 위 평면)
        Pos(int y, int x, int d, int t) {
            this.y = y;
            this.x = x;
            this.d = d;
            this.t = t;
        }

        public void print() {
            System.out.printf("%d %d %d %d \n", this.y, this.x, this.d, this.t);
        }
    }

    public static void main(String[] args) throws IOException {

        init();

        Queue<Pos> q = new LinkedList<>();

        q.offer(start);
        Pos exitTimeSpaceP = null;

        while (!q.isEmpty()) {
            Pos p = q.poll();

            if (p.d == 5) {
                exitTimeSpaceP = p;
                break;
            }

            timeSpace[p.d][p.y][p.x] = -1;

            if (p.d == 0) {
                q.addAll(moveFromEast(p));
            } else if (p.d == 1) {
                q.addAll(moveFromWest(p));
            } else if (p.d == 2) {
                q.addAll(moveFromSouth(p));
            } else if (p.d == 3) {
                q.addAll(moveFromNorth(p));
            } else if (p.d == 4) {
                q.addAll(moveFromFront(p));
            }
        }

        if (exitTimeSpaceP == null) {
            System.out.print(-1);
            return;
        }
        moveAbnormal(exitTimeSpaceP.t);

        if (map[exitTimeSpaceP.y][exitTimeSpaceP.x] != 0) {
            System.out.print(-1);
            return;
        }

        q = new LinkedList<>();

        q.add(exitTimeSpaceP);

        while (!q.isEmpty()) {
            Pos p = q.poll();

            if (p.y == ey && p.x == ex) {
                System.out.print(p.t);
                return;
            }

            map[p.y][p.x] = -1;
            moveAbnormal(p.t + 1);

            for (int i = 0; i < 4; i++) {
                int dy = p.y + d[i];
                int dx = p.x + d[3 - i];

                if (!isValidRange(dy, dx)) {
                    continue;
                }

                if (map[dy][dx] == 0 || map[dy][dx] == 4) {
                    q.add(new Pos(dy, dx, 5, p.t + 1));
                }
            }
        }

        System.out.print(-1);
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());

        boolean isFirst = true;

        map = new int[n][n];
        timeSpace = new int[5][m][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 3 && isFirst) {
                    isFirst = false;
                    ty = i;
                    tx = j;
                }

                if (map[i][j] == 4) {
                    ey = i;
                    ex = j;
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            if (i == 1 || i == 3) {
                for (int j = 0; j < m; j++) {
                    st = new StringTokenizer(br.readLine());
                    for (int k = 0; k < m; k++) {
                        timeSpace[i][j][m - k - 1] = Integer.parseInt(st.nextToken());
                    }
                }
                continue;
            }
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    timeSpace[i][j][k] = Integer.parseInt(st.nextToken());
                    if (timeSpace[i][j][k] == 2) {
                        start = new Pos(j, k, i, 0);
                    }
                }
            }
        }

        for (int i = 0; i < f; i++) {
            st = new StringTokenizer(br.readLine());
            abnormals.add(new Abnormal(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
    }

    // 시간 이상현상 이동
    static boolean[] visited = new boolean[3000];
    private static void moveAbnormal(int t) {
        if (visited[t]) {
            return;
        }

        visited[t] = true;

        for (Abnormal abnormal : abnormals) {
            int dt = t / abnormal.v;
            map[abnormal.y][abnormal.x] = -2;
            int dy = abnormal.y;
            int dx = abnormal.x;

            for (int i = 0; i < dt; i++) {

                if (abnormal.d == 0) {
                    dx += 1;
                } else if (abnormal.d == 1) {
                    dx -= 1;
                } else if (abnormal.d == 2) {
                    dy += 1;
                } else if (abnormal.d == 3) {
                    dy -= 1;
                }

                if (isValidRange(dy, dx)) {
                    if (map[dy][dx] == 3 || map[dy][dx] == 1 || map[dy][dx] == 4) {
                        break;
                    }
                    map[dy][dx] = -2;
                }
            }
        }
    }

    static int[] d = new int[]{0, 0, -1, 1};
    static List<Pos> moves;
    private static List<Pos> moveFromFront(Pos pos) {

        moves = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int dy = pos.y + d[i];
            int dx = pos.x - d[3 - i];
            if (dy < 0 && timeSpace[3][0][dx] == 0) {
                moves.add(new Pos(0, dx, 3, pos.t + 1));
                continue;
            }

            if (dy >= m && timeSpace[2][0][dx] == 0) {
                moves.add(new Pos(0, dx, 2, pos.t + 1));
                continue;
            }

            if (dx < 0 && timeSpace[1][0][dy] == 0) {
                moves.add(new Pos(0, dy, 1, pos.t + 1));
                continue;
            }

            if (dx >= m && timeSpace[0][0][m - 1 - dy] == 0) {
                moves.add(new Pos(0, m - 1 - dy, 0, pos.t + 1));
                continue;
            }

            if (isValidTimeRange(dy, dx) && timeSpace[pos.d][dy][dx] == 0) {
                moves.add(new Pos(dy, dx, pos.d, pos.t + 1));
            }
        }

        return moves;
    }

    private static List<Pos> moveFromSouth(Pos pos) {
        moves = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            int dy = pos.y + d[i];
            int dx = pos.x - d[3 - i];

            if (dy < 0 && timeSpace[4][m - 1][dx] == 0) {
                moves.add(new Pos(m - 1, dx, 4, pos.t + 1));
                continue;
            }

            if (dy >= m && isValidRange(ty + m, tx + dx) && map[ty + m][tx + dx] == 0) {
                moves.add(new Pos(ty + m, tx + dx, 5, pos.t + 1));
                continue;
            }

            if (dx < 0 && timeSpace[1][dy][m - 1] == 0) {
                moves.add(new Pos(dy, m - 1, 1, pos.t + 1));
                continue;
            }

            if (dx >= m && timeSpace[0][dy][0] == 0) {
                moves.add(new Pos(dy, 0, 0, pos.t + 1));
                continue;
            }

            if (isValidTimeRange(dy, dx) && timeSpace[pos.d][dy][dx] == 0) {
                moves.add(new Pos(dy, dx, pos.d, pos.t + 1));
            }
        }

        return moves;
    }

    private static List<Pos> moveFromNorth(Pos pos) {
        moves = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            int dy = pos.y + d[i];
            int dx = pos.x - d[3 - i];

            if (dy < 0 && timeSpace[4][0][dx] == 0) {
                moves.add(new Pos(0, dx, 4, pos.t + 1));
                continue;
            }

            if (dy >= m && isValidRange(ty - 1, tx + dx) && map[ty - 1][tx + dx] == 0) {
                moves.add(new Pos(ty - 1, tx + dx, 5, pos.t + 1));
                continue;
            }

            if (dx < 0 && timeSpace[1][dy][0] == 0) {
                moves.add(new Pos(dy, 0, 1, pos.t + 1));
                continue;
            }

            if (dx >= m && timeSpace[0][dy][m - 1] == 0) {
                moves.add(new Pos(dy, m - 1, 1, pos.t + 1));
                continue;
            }

            if (isValidTimeRange(dy, dx) && timeSpace[pos.d][dy][dx] == 0) {
                moves.add(new Pos(dy, dx, pos.d, pos.t + 1));
            }
        }

        return moves;
    }

    private static List<Pos> moveFromWest(Pos pos) {
        moves = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            int dy = pos.y + d[i];
            int dx = pos.x - d[3 - i];

            if (dy < 0 && timeSpace[4][dx][0] == 0) {
                moves.add(new Pos(dx, 0, 4, pos.t + 1));
                continue;
            }

            if (dy >= m && isValidRange(ty + dx, tx - 1) && map[ty + dx][tx - 1] == 0) {
                moves.add(new Pos(ty + dx, tx - 1, 5, pos.t + 1));
                continue;
            }

            if (dx < 0 && timeSpace[3][dy][0] == 0) {
                moves.add(new Pos(dy, 0, 3, pos.t + 1));
                continue;
            }

            if (dx >= m && timeSpace[2][dy][0] == 0) {
                moves.add(new Pos(dy, 0, 2, pos.t + 1));
                continue;
            }

            if (isValidTimeRange(dy, dx) && timeSpace[pos.d][dy][dx] == 0) {
                moves.add(new Pos(dy, dx, pos.d, pos.t + 1));
            }
        }

        return moves;
    }

    private static List<Pos> moveFromEast(Pos pos) {
        moves = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            int dy = pos.y + d[i];
            int dx = pos.x - d[3 - i];

            if (dy < 0 && timeSpace[4][dx][m - 1] == 0) {
                moves.add(new Pos(dx, m - 1, 4, pos.t + 1));
                continue;
            }

            if (dy >= m && isValidRange(ty + (m - dx - 1), tx + m) && map[ty + (m - dx - 1)][tx + m] == 0) {
                moves.add(new Pos(ty + (m - dx - 1), tx + m, 5, pos.t + 1));
                continue;
            }

            if (dx < 0 && timeSpace[2][dy][m - 1] == 0) {
                moves.add(new Pos(dy, m - 1, 2, pos.t + 1));
                continue;
            }

            if (dx >= m && timeSpace[3][dy][m - 1] == 0) {
                moves.add(new Pos(dy, m - 1, 3, pos.t + 1));
                continue;
            }

            if (isValidTimeRange(dy, dx) && timeSpace[pos.d][dy][dx] == 0) {
                moves.add(new Pos(dy, dx, pos.d, pos.t + 1));
            }
        }

        return moves;
    }

    private static boolean isValidRange(int y, int x) {
        return y < n && y >= 0 && x < n && x >= 0;
    }

    private static boolean isValidTimeRange(int y, int x) {
        return y < m && y >= 0 && x < m && x >= 0;
    }
}