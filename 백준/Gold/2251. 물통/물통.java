import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Water {
        int a;
        int b;
        int c;

        public Water(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    static boolean[][] visited = new boolean[201][201];
    static int A, B, C;
    static Set<Integer> waterList = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        dfs(new Water(0, 0, C));

        for (int tmp : waterList) {
            System.out.printf("%d ", tmp);
        }

    }

    private static void dfs(Water water) {
        int a = water.a;
        int b = water.b;
        int c = water.c;

        if (visited[a][b]) {
            return;
        }

        visited[a][b] = true;

        if (a == 0) {
            waterList.add(c);
        }

        // a -> b;
        if (a + b <= B) {
            dfs(new Water(0, a + b, c));
        } else {
            dfs(new Water(a - (B - b), B, c));
        }

        // a -> c
        if (a + c <= C) {
            dfs(new Water(0, b, a + c));
        } else {
            dfs (new Water(a - (C - c), b, C));
        }

        // b -> a
        if (b + a <= A) {
            dfs(new Water(b + a, 0, c));
        } else {
            dfs(new Water(A, b - (A - a), c));
        }

        // b -> c
        if (b + c <= C) {
            dfs(new Water(a, 0, b + c));
        } else {
            dfs(new Water(a, b - (C - c), C));
        }

        // c -> a
        if (c + a <= A) {
            dfs(new Water(a + c, b, 0));
        } else {
            dfs(new Water(A, b, c - (A - a)));
        }

        // c -> b
        if (c + b <= B) {
            dfs(new Water(a, b + c, 0));
        } else {
            dfs (new Water(a, B, c - (B - b)));
        }
    }
}
