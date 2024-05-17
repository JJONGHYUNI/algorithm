import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Lecture {
        int start;
        int end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Lecture[] lectures = new Lecture[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            lectures[i] = new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(lectures, (o1, o2) -> o1.start == o2.start ? o1.end - o2.end : o1.start - o2.start);

        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(lectures[0].end);

        for (int i = 1; i < n; i++) {
            if (q.peek() <= lectures[i].start) {
                q.poll();
            }
            q.add(lectures[i].end);
        }

        System.out.print(q.size());

    }
}
