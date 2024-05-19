import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static class Bus implements Comparable<Bus> {
        int end, cost;

        public Bus(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Bus o) {
            return cost - o.cost;
        }
    }

    static int n, m;
    static List<List<Bus>> buses = new ArrayList<>();
    static int[] costs;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        StringTokenizer st;

        costs = new int[n + 1];
        visited = new boolean[n + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            buses.add(new ArrayList<>());
        }

        buses.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            buses.get(Integer.parseInt(st.nextToken())).add(new Bus(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        System.out.print(dijkstra(start, end));
    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Bus> q = new PriorityQueue<>();
        q.add(new Bus(start, 0));
        costs[start] = 0;

        while (!q.isEmpty()) {
            Bus bus = q.poll();
            int tmp = bus.end;

            if (visited[tmp]) {
                continue;
            }

            visited[tmp] = true;

            for (Bus b : buses.get(tmp)) {
                if (!visited[b.end] && costs[b.end] > costs[tmp] + b.cost) {
                    costs[b.end] = costs[tmp] + b.cost;
                    q.add(new Bus(b.end, costs[b.end]));
                }
            }
        }
        return costs[end];
    }

}