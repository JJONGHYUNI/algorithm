import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> answer = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        List<List<Integer>> road = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            road.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            road.get(a).add(b);
        }

        q.add(new int[]{x, 0});
        visited[x] = true;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int city = tmp[0];
            int cnt = tmp[1];

            if (cnt == k) {
                answer.add(city);
                continue;
            }

            for (int target : road.get(city)) {
                if (!visited[target]) {
                    q.add(new int[]{target, cnt + 1});
                    visited[target] = true;
                }
            }
        }

        if (answer.isEmpty()) {
            System.out.print(-1);
        } else {
            Collections.sort(answer);
            for (int tmp : answer) {
                System.out.println(tmp);
            }
        }
    }
}