import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static Computer[] computers;
    static int[] hacking;
    static boolean[] visited;
    public static class Computer {
        int idx;
        List<Computer> connects;

        public Computer(int idx) {
            this.idx = idx;
            connects = new ArrayList<>();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        hacking = new int[n + 1];
        computers = new Computer[n + 1];

        for (int i = 1; i <= n; i++) {
            computers[i] = new Computer(i);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int com1 = Integer.parseInt(st.nextToken());
            int com2 = Integer.parseInt(st.nextToken());
            computers[com2].connects.add(computers[com1]);
        }

        int tmp = 0;
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            visited[i] = true;
            dfs(i, i);
        }

        int max = 0;
        int idx = 0;

        for (int i = 1; i <= n; i++) {
            if (hacking[i] > max) {
                idx = i;
                max = hacking[i];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = idx; i <= n; i++) {
            if (hacking[i] == max) {
                sb.append(i + " ");
            }
        }

        System.out.print(sb.toString());
    }

    private static void dfs(int idx, int start) {
        for (Computer c : computers[idx].connects) {
            if (!visited[c.idx]) {
                visited[c.idx] = true;
                dfs(c.idx, start);
                hacking[start]++;
            }
        }
    }
}
