import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, e;
    static List<List<Node>> nodes = new ArrayList<>();
    static int[] distances;
    static boolean[] visited;
    static int lay1, lay2;
    static final int MAX_VALUE = 200_000_000;

    static class Node implements Comparable<Node>{
        int next, cost;

        public Node(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        distances = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            int nxt = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            nodes.get(cur).add(new Node(nxt, cost));
            nodes.get(nxt).add(new Node(cur, cost));
        }

        st = new StringTokenizer(br.readLine());
        lay1 = Integer.parseInt(st.nextToken());
        lay2 = Integer.parseInt(st.nextToken());

        int distanceOneToLay1 = dijkstra(1, lay1);
        int distanceOneToLay2 = dijkstra(1, lay2);
        int distanceLay1ToLay2 = dijkstra(lay1, lay2);
        int distanceLay1ToN = dijkstra(lay1, n);
        int distanceLay2ToN = dijkstra(lay2, n);

        int ans = Math.min(distanceOneToLay1 + distanceLay1ToLay2 + distanceLay2ToN, distanceOneToLay2 + distanceLay1ToLay2 + distanceLay1ToN);
        System.out.print((ans >= MAX_VALUE) ? -1 : ans);
    }

    private static int dijkstra(int start, int target) {
        Arrays.fill(distances, MAX_VALUE);
        Arrays.fill(visited, false);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        distances[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int nxt = cur.next;

            if (!visited[nxt]) {
                visited[nxt] = true;
                for (Node n : nodes.get(nxt)) {
                    if (!visited[n.next] && distances[n.next] > distances[nxt] + n.cost) {
                        distances[n.next] = distances[nxt] + n.cost;
                        pq.add(new Node(n.next, distances[n.next]));
                    }
                }
            }
        }


        return distances[target];
    }
}
