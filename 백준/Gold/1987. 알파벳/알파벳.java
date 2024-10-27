import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int r, c;
    static boolean[] visited = new boolean[26];
    static char[][] board;
    static int ans = -1;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new char[r][c];

        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        visited[board[0][0] - 'A'] = true;
        dfs(0, 0, 1);

        System.out.print(ans);
    }

    static int[] d = new int[]{0, 0, -1, 1};

    private static void dfs(int y, int x, int depth) {
        ans = Math.max(ans, depth);

        for (int i = 0; i < 4; i++) {
            int dy = y + d[i];
            int dx = x + d[3 - i];

            if (dy < 0 || dx < 0 || dx >= c || dy >= r) continue;

            if (!visited[board[dy][dx] - 'A']) {
                visited[board[dy][dx] - 'A'] = true;
                dfs(dy, dx, depth + 1);
                visited[board[dy][dx] - 'A'] = false;
            }
        }
    }

}