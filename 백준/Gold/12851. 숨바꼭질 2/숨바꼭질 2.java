import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Pos> q = new LinkedList<>();
        boolean[] visited = new boolean[100001];

        q.add(new Pos(n, 0));
        visited[n] = true;

        int ans = 0;
        int tmp = 0;

        while (!q.isEmpty()) {
            Pos p = q.poll();
            visited[p.x] = true;

            if (p.x == k) {
                tmp = p.time;
                ans++;
                break;
            }

            int doubleX = p.x * 2;
            int plusX = p.x + 1;
            int minusX = p.x - 1;

            if (doubleX <= 100000 && !visited[doubleX]) {
                q.add(new Pos(doubleX, p.time + 1));
            }

            if (plusX <= 100000 && !visited[plusX]) {
                q.add(new Pos(plusX, p.time + 1));
            }

            if (minusX >= 0 && !visited[minusX]) {
                q.add(new Pos(minusX, p.time + 1));
            }
        }

        for (Pos p : q) {
            if (p.time != tmp) {
                break;
            }

            if (p.x == k) {
                ans++;
            }
        }

        System.out.println(tmp);
        System.out.print(ans);
    }

    static class Pos {
        int x, time;

        public Pos(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
}
