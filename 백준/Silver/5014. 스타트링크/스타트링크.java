import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int f, s, g, u, d;
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited;
        String answer = "use the stairs";
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        visited = new boolean[f + 1];

        q.add(new int[]{s, 0});

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int cur = tmp[0];
            int cnt = tmp[1];

            if (cur == g) {
                answer = Integer.toString(cnt);
                break;
            }
            int uX = cur + u;
            int dX = cur - d;

            if (uX <= f && !visited[uX]) {
                q.add(new int[]{uX, cnt + 1});
                visited[uX] = true;
            }

            if (dX > 0 && !visited[dX]) {
                q.add(new int[]{dX, cnt + 1});
                visited[dX] = true;
            }
        }

        System.out.print(answer);
    }
}