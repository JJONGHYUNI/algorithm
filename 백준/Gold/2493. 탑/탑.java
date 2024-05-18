import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Top implements Comparable<Top>{
        int value, idx;

        Top(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }

        @Override
        public int compareTo(Top o) {
            return this.value - o.value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        PriorityQueue<Top> q = new PriorityQueue<>();
        q.add(new Top(arr[n - 1], n - 1));
        int[] answer = new int[n];
        int idx = n - 1;

        for (int i = n - 2; i >= 0; i--) {
            int tmp = arr[i];

            while (!q.isEmpty()) {
                if (q.peek().value < tmp) {
                    Top top = q.poll();
                    answer[top.idx] = i + 1;
                    continue;
                }
                break;
            }

            q.add(new Top(tmp, i));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(answer[i]).append(" ");
        }

        System.out.print(sb);
    }
}