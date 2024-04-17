import java.util.*;
import java.io.*;


public class Main {
    static char[][] board;
    static boolean[][] visited;
    static int whiteTmp, blueTmp;
    static int[] d = new int[]{-1, 1, 0, 0};
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        visited = new boolean[n][m];
        int white = 0;
        int blue = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    blueTmp = 0;
                    whiteTmp = 0;
                    if (board[i][j] == 'W') {
                        whiteTmp = 1;
                    }
                    if (board[i][j] == 'B') {
                        blueTmp = 1;
                    }
                    dfs(i, j, board[i][j]);
                    white += (whiteTmp * whiteTmp);
                    blue += (blueTmp * blueTmp);
                }
            }
        }

        System.out.printf("%d %d", white, blue);
    }

    private static void dfs(int y, int x, char WB) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int dy = y + d[i];
            int dx = x + d[3 - i];
            if (dy >= 0 && dy < n && dx >= 0 && dx < m && !visited[dy][dx]) {
                if (WB == 'W' && board[dy][dx] == 'W') {
                    whiteTmp += 1;
                    dfs(dy, dx, 'W');
                    continue;
                }
                if (WB == 'B' && board[dy][dx] == 'B') {
                    blueTmp += 1;
                    dfs(dy, dx, 'B');
                }
            }
        }
    }
}
