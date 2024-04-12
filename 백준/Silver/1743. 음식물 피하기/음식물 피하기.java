import java.util.*;
import java.io.*;


public class Main {
    static int n;
    static int m;
    static int k;
    static int[][] arr;
    static int[] d = new int[]{0, 0, -1, 1};
    static int answer = 0;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][m + 1];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[r][c] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (arr[i][j] == 1) {
                    cnt = 0;
                    dfs(i, j);
                    answer = Math.max(answer, cnt);
                }
            }
        }
        System.out.print(answer);
     }

    private static void dfs(int y, int x) {
        arr[y][x] = 0;
        cnt += 1;
        for (int dd = 0; dd < 4; dd++) {
            int dy = y + d[dd];
            int dx = x + d[3 - dd];

            if ((dy > 0 && dy <= n) && (dx > 0 && dx <= m)) {
                if (arr[dy][dx] == 1) {
                    dfs(dy, dx);
                }
            }
        }
    }
}