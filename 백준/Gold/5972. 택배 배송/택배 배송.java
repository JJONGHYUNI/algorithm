import java.io.*;
import java.util.*;


class Main {
    static class Road implements Comparable<Road> {
        int end;
        int cost;

        public Road(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Road o) {
            return this.cost - o.cost;
        }
    }

    static int n, m;
    static List<Road>[] roads;
    static boolean[] visited;
    static int[] costs;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        roads = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        costs = new int[n + 1];
        Arrays.fill(costs, 50_000_001);

        for (int i = 1; i <= n; i++) {
            roads[i] = new ArrayList<>();
        }

        int a, b, c;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            roads[a].add(new Road(b, c));
            roads[b].add(new Road(a, c));
        }
        dijkstra();
        System.out.print(costs[n]);
    }

    private static void dijkstra() {
        PriorityQueue<Road> q = new PriorityQueue<>();
        costs[1] = 0;
        q.offer(new Road(1, 0));

        while (!q.isEmpty()) {
            Road tmp = q.poll();

            if (visited[tmp.end]) {
                continue;
            }

            visited[tmp.end] = true;

            for (Road nxt : roads[tmp.end]) {
                if (costs[nxt.end] > costs[tmp.end] + nxt.cost) {
                    costs[nxt.end] = costs[tmp.end] + nxt.cost;
                    q.offer(new Road(nxt.end, costs[nxt.end]));
                }
            }
        }
    }
}