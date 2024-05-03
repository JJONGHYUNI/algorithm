import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int l, curY, curX, targetY, targetX;
        boolean[][] visited;
        StringTokenizer st;
        Queue<int[]> q;
        int[] dx = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = new int[]{-1, -2, -2, -1, 1, 2, 2, 1};
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            l = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            curY = Integer.parseInt(st.nextToken());
            curX = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            targetY = Integer.parseInt(st.nextToken());
            targetX = Integer.parseInt(st.nextToken());
            q = new LinkedList<>();
            int y, x, cnt;
            visited = new boolean[l][l];
            q.add(new int[]{curY, curX, 0});
            visited[curY][curX] = true;

            while (!q.isEmpty()) {
                int[] tmp = q.poll();
                y = tmp[0];
                x = tmp[1];
                cnt = tmp[2];

                if (y == targetY && x == targetX) {
                    sb.append(cnt).append("\n");
                    break;
                }

                for (int j = 0; j < 8; j++) {
                    int ry = y + dy[j];
                    int rx = x + dx[j];

                    if (ry >= 0 && ry < l && rx >=0 && rx < l && !visited[ry][rx]) {
                        q.add(new int[]{ry, rx, cnt + 1});
                        visited[ry][rx] = true;
                    }
                }
            }
        }
        System.out.print(sb);
    }
}