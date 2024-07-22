import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Task implements Comparable<Task>{
        int t, s;

        public Task(int t, int s) {
            this.t = t;
            this.s = s;
        }

        @Override
        public int compareTo(Task o) {
            return o.s - this.s;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        List<Task> tasks = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            tasks.add(new Task(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(tasks);
        
        //S의 최댓값
        int time = 1_000_001;

        for (int i = 0; i < n; i++) {
            //제일 늦게 끝나는 것부터 하향식으로, 이전 time보다 마감해야하는 시간이 빠르면 그 시간으로 교체 후 빼주기
            time = Math.min(time, tasks.get(i).s) - tasks.get(i).t;

            if (time < 0) {
                time = -1;
                break;
            }
        }

        System.out.print(time);
    }


}
