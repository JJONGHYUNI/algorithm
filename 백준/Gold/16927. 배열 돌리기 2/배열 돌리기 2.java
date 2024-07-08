import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m, r;
    static int[][] arr;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 각 구간 몇 개인지 (가장자리부터 제일 안쪽까지 몇 개인지)
        int min = Math.min(n, m) / 2;

        for (int i = 0; i < min; i++) {
            // 실제 돌릴 횟수
            int rotate = r % (((n - 2 * i) + (m - 2 * i)) * 2 - 4);
//            //실제 돌릴 횟수
//            int rr = r % rotate;

            rotate(rotate, i);
        }
        StringBuilder sb = new StringBuilder();
        for (int[] a : arr) {
            for (int b : a) {
                sb.append(b).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static void rotate(int rr, int ii) {
        for (int r = 0; r < rr; r++) {
            int tmp = arr[ii][ii];
            int y = ii;
            int x = ii;
            int idx = 0;

            while (idx < 4) {
                int ny = y + dy[idx];
                int nx = x + dx[idx];
                if (ny >= ii && ny < n - ii && nx >= ii && nx < m - ii) {
                    arr[y][x] = arr[ny][nx];
                    y = ny;
                    x = nx;
                    continue;
                }
                idx++;
            }
            arr[ii + 1][ii] = tmp;
        }
    }
}