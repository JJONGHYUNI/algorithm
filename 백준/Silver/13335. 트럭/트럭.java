import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Queue<Integer> truck = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            truck.add(Integer.parseInt(st.nextToken()));
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < w; i++) {
            q.add(0);
        }

        int weight = 0;
        int cnt = 0;
        while (!q.isEmpty()) {
            cnt += 1;
            weight -= q.poll();
            if (!truck.isEmpty()) {
                if (truck.peek() + weight <= l) {
                    int tmp = truck.poll();
                    q.add(tmp);
                    weight += tmp;
                    continue;
                }
                q.add(0);
            }
        }
        System.out.print(cnt);
    }
}