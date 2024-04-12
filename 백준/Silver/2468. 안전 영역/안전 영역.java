import java.util.*;
import java.io.*;


public class Main {
    static int n;
    static int[][] arr;
    static int maxHeight = 0;
    static int[] d = new int[]{-1, 1, 0, 0};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, arr[i][j]);
            }
        }
        int answer = 1;
        for (int height = 1; height < maxHeight; height++) {
            int cnt = 0;
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] > height && !visited[i][j]) {
                        cnt += 1;
                        dfs(i, j, height);
                    }
                }
            }
            answer = Math.max(answer, cnt);
        }

        System.out.print(answer);
     }

     private static void dfs(int y, int x, int height) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int dy = y + d[i];
            int dx = x + d[3-i];

            if ((dy >= 0 && dy < n) && (dx >= 0 && dx < n)) {
                if (arr[dy][dx] > height && !visited[dy][dx]) {
                    dfs(dy, dx, height);
                }
            }
        }
     }
}