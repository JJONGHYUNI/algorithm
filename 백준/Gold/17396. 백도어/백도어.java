import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int idx;
        long cost;

        public Node(int idx, long cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(cost, o.cost);
        }
    }

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        boolean[] roads = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (Integer.parseInt(st.nextToken()) == 1) {
                roads[i] = true;
            }
        }

        List<Node>[] nodes = new List[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            nodes[start].add(new Node(end, cost));
            nodes[end].add(new Node(start, cost));
        }

        long answer = dijkstra(n, nodes, roads);
        answer = answer == Long.MAX_VALUE ? -1 : answer;
        System.out.print(answer);
    }


    private static long dijkstra(int n, List<Node>[] nodes, boolean[] roads) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        pq.add(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.idx == n - 1) {
                break;
            }
            if (dist[cur.idx] < cur.cost) {
                continue;
            }

            for (int i = 0; i < nodes[cur.idx].size(); i++) {
                Node next = nodes[cur.idx].get(i);

                if (roads[next.idx] && next.idx != n - 1) {
                    continue;
                }

                if (dist[next.idx] > dist[cur.idx] + next.cost) {
                    dist[next.idx] = dist[cur.idx] + next.cost;
                    pq.add(new Node(next.idx, dist[next.idx]));
                }
            }
        }

        return dist[n - 1];
    }
}
