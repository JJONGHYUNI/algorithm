import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] d = new int[]{0, 0, 0, 0, 1, -1, 0, 0};
    static char[][][] building;
    static final String ESCAPE = "Escaped in %d minute(s).";
    static final String IMPOSSIBLE = "Trapped!";
    static StringBuilder sb = new StringBuilder();
    static int l, r, c, startL, startR, startC;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (l == 0) {
                System.out.print(sb);
                return;
            }

            building = new char[l][r][c];
            visited = new boolean[l][r][c];

            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String str = br.readLine();
                    for (int k = 0; k < c; k++) {
                        char tmp = str.charAt(k);
                        building[i][j][k] = tmp;
                        if (tmp == 'S') {
                            startL = i;
                            startR = j;
                            startC = k;
                        }
                    }
                }
                br.readLine();
            }

            bfs();
        }
        
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startL, startR, startC, 0});
        visited[startL][startR][startC] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int curL = temp[0];
            int curR = temp[1];
            int curC = temp[2];
            int cnt = temp[3];

            if (building[curL][curR][curC] == 'E') {
                sb.append(String.format(ESCAPE, cnt)).append("\n");
                return;
            }

            for (int i = 0; i < 6; i++) {
                int dl = curL + d[i];
                int dr = curR + d[i + 2];
                int dc = curC + d[5 - i];

                if (dl >= 0 && dl < l && dr >= 0 && dr < r && dc >= 0 && dc < c) {
                    if (!visited[dl][dr][dc] && building[dl][dr][dc] != '#') {
                        visited[dl][dr][dc] = true;
                        q.add(new int[]{dl, dr, dc, cnt + 1});
                    }
                }
            }
        }

        sb.append(IMPOSSIBLE).append("\n");
    }
}