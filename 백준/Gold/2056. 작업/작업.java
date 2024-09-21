import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static Queue<Task> q = new LinkedList<>();
    static List<Task> tasks;

    static class Task {
        int t;
        int inDegree;
        int end;
        List<Integer> inDegreeList;

        public Task(int t, int inDegree) {
            this.t = t;
            this.inDegree = inDegree;
            this.inDegreeList = new ArrayList<>();
            end = 0;
        }
    }
    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        tasks = new ArrayList<>();
        tasks.add(new Task(0, 0));

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int inDegree = Integer.parseInt(st.nextToken());
            tasks.add(new Task(t, inDegree));

            if (inDegree == 0) {
                q.add(tasks.get(i));
                tasks.get(i).end = tasks.get(i).t;
            }

            for (int j = 0; j < inDegree; j++) {
                tasks.get(Integer.parseInt(st.nextToken())).inDegreeList.add(i);
            }
        }

        System.out.print(topologicalSort());
    }

    static int topologicalSort() {

        while (!q.isEmpty()) {
            Task task = q.poll();

            for (int next : task.inDegreeList) {
                if (tasks.get(next).end < task.end + tasks.get(next).t) {
                    tasks.get(next).end = task.end + tasks.get(next).t;
                }

                if (--tasks.get(next).inDegree == 0) {
                    q.add(tasks.get(next));
                }
            }
        }

        return tasks.stream().mapToInt(x -> x.end).max().getAsInt();
    }
}