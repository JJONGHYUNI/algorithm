import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[101];
        boolean[] visited = new boolean[101];

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b=  Integer.parseInt(st.nextToken());
            arr[a] = b;
        }

        Queue<int[]> q = new LinkedList<>();
        // {position, count}
        q.add(new int[]{1, 0});
        int pos, cnt;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            pos = tmp[0];
            cnt = tmp[1];

            if (pos == 100) {
                System.out.print(cnt);
                return;
            }

            for (int i = 1; i < 7; i++) {
                int next = pos + i;
                if (next < 1 || next > 100) {
                    continue;
                }

                if (arr[next] != 0) {
                    visited[next] = true;
                    next = arr[next];
                }

                if (!visited[next]) {
                    visited[next] = true;
                    q.add(new int[]{next, cnt + 1});
                }
            }
        }
    }

}