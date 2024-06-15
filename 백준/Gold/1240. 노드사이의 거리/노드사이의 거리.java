import java.io.*;
import java.util.*;
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static List<Node>[] nodes;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nodes = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }
        
        int a, b, c;

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            nodes[a].add(new Node(b, c));
            nodes[b].add(new Node(a, c));
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            sb.append(bfs(a, b)).append("\n");
        }
        System.out.print(sb);
    }

    private static int bfs(int start, int target) {
        Queue<Node> q = new ArrayDeque<>();
        visited = new boolean[n + 1];
        q.add(new Node(start, 0));
        Node node;

        while (!q.isEmpty()) {
            node = q.poll();
            if (node.next == target) {
                return node.cost;
            }

            for (Node next : nodes[node.next]) {
                if (visited[next.next]) {
                    continue;
                }
                visited[next.next] = true;
                q.add(new Node(next.next, next.cost + node.cost));
            }
        }
        return 0;
    }

    static class Node {
        int next;
        int cost;

        public Node(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }
    }
}