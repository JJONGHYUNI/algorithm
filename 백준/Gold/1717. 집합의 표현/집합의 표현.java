import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] parent;
    static final String YES = "YES";
    static final String NO = "NO";
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        int com, x, y;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            com = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            if (com == 0) {
                union(x, y);
                continue;
            }
            print(x, y);
        }

        System.out.print(sb);
    }

    private static void print(int x, int y) {
        if (parent[find(x)] == parent[find(y)]) {
            sb.append(YES).append("\n");
            return;
        }
        sb.append(NO).append("\n");
    }

    private static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) {
            return false;
        }

        if (x <= y) {
            parent[y] = x;
            return true;
        }

        parent[x] = y;
        return true;
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

}