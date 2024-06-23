import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static int[][] mountains;
    static boolean[][] visited;
    static int[][] d = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    static List<Peak> peaks = new ArrayList<>();

    static class Peak {
        int y, x;

        Peak(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        mountains = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                mountains[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean control;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j]) {
                    continue;
                }
                peaks = new ArrayList<>();
                peaks.add(new Peak(i, j));
                visited[i][j] = true;
                findPeaks(i, j);
                control = isValidPeaks();
                if (control) {
                    answer += 1;
                }
            }
        }
        System.out.print(answer);
    }

    private static void findPeaks(int y, int x) {
        for (int[] dd : d) {
            int dy = y + dd[0];
            int dx = x + dd[1];

            if (dy >= 0 && dy < n && dx >= 0 && dx < m && mountains[y][x] == mountains[dy][dx]) {
                if (visited[dy][dx]) {
                    continue;
                }

                visited[dy][dx] = true;
                peaks.add(new Peak(dy, dx));
                findPeaks(dy, dx);
            }
        }
    }

    private static boolean isValidPeaks() {
        int dy, dx;

        for (Peak peak : peaks) {
            for (int[] dd : d) {
                dy = peak.y + dd[0];
                dx = peak.x + dd[1];

                if (dy >= 0 && dy < n && dx >= 0 && dx < m && mountains[peak.y][peak.x] < mountains[dy][dx]) {
                    return false;
                }
            }
        }
        return true;
    }
}