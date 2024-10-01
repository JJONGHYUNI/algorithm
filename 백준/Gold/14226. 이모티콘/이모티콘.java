import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[][] visited = new boolean[2001][2001];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());

        Queue<Emoticon> q = new LinkedList<>();
        q.add(new Emoticon(0, 1, 0));
        visited[0][1] = true;

        while (!q.isEmpty()) {
            Emoticon e = q.poll();

            if (e.cur == s) {
                System.out.print(e.time);
                break;
            }
            if (e.cur > 2000) {
                continue;
            }
            
            if (!visited[e.cur][e.cur]) {
                q.add(new Emoticon(e.cur, e.cur, e.time + 1));
                visited[e.cur][e.cur] = true;
            }

            if (e.clip != 0 && e.cur + e.clip <= 2000 && !visited[e.clip][e.cur + e.clip]) {
                q.add(new Emoticon(e.clip, e.cur + e.clip, e.time + 1));
                visited[e.clip][e.cur + e.clip] = true;
            }

            if (e.cur > 1 && !visited[e.clip][e.cur - 1]) {
                q.add(new Emoticon(e.clip, e.cur - 1, e.time + 1));
            }
        }

    }

    static class Emoticon {
        int clip, cur, time;

        public Emoticon(int clip, int cur, int time) {
            this.clip = clip;
            this.cur = cur;
            this.time = time;
        }
    }
}