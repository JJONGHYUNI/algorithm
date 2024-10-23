import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int v, e;
    static int[] parent;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        parent = new int[v + 1];

        List<Node> nodes = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            nodes.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        Collections.sort(nodes);
        int ans = 0;

        for (Node node : nodes) {
            if (find(node.a) == find(node.b)) {
                continue;
            }
            ans += node.cost;
            union(node.a, node.b);
        }
        
        System.out.print(ans);
    }

    static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }

    static class Node implements Comparable<Node> {
        int a, b, cost;

        Node(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            if (this.cost > o.cost) {
                return 1;
            }
            return -1;
        }
    }
}