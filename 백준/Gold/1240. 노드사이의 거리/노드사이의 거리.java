import java.io.*;
import java.util.*;
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] nodes;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nodes = new int[n + 1][n + 1];
        int a, b, c;

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            nodes[a][b] = c;
            nodes[b][a] = c;
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
        Queue<Node> q = new LinkedList<>();
        visited = new boolean[n + 1];
        q.add(new Node(start, 0));
        Node node;
        while (!q.isEmpty()) {
            node = q.poll();
            if (node.next == target) {
                return node.cost;
            }
            for (int i = 1; i <= n; i++) {
                if (nodes[node.next][i] == 0) {
                    continue;
                }
                if (visited[i]) {
                    continue;
                }
                visited[i] = true;
                q.add(new Node(i, node.cost + nodes[node.next][i]));
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