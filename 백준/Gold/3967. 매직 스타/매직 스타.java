import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    static char[] lines = new char[12];
    static List<Integer> checkPositions = new ArrayList<>();
    static boolean[] visited = new boolean[12];
    static char[][] ans = new char[][]{
            {'.','.','.','.','x','.','.','.','.'},
            {'.','x','.','x','.','x','.','x','.'},
            {'.','.','x','.','.','.','x','.','.'},
            {'.','x','.','x','.','x','.','x','.'},
            {'.','.','.','.','x','.','.','.','.'}
    };

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void init() throws IOException {
        int idx = 0;
        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < 9; j++) {
                char c = line.charAt(j);
                if (c != '.') {
                    lines[idx] = c;
                    if (c == 'x') {
                        checkPositions.add(idx++);
                        continue;
                    }
                    idx++;
                    visited[c - 'A'] = true;
                }
            }
        }
    }

    private static void solution() {
        dfs(0);
    }

    private static void dfs(int depth) {

        if (depth == checkPositions.size()) {
            if (isValid()) {
                draw();
                System.exit(0);
            }
            return;
        }

        for (int n = 0; n < 12; n++) {
            if (visited[n]) {
                continue;
            }

            visited[n] = true;
            lines[checkPositions.get(depth)] = (char) (n + 65);
            dfs(depth + 1);
            visited[n] = false;
        }
    }

    static List<int[]> ds = List.of(new int[]{0, 2, 5, 7}, new int[]{0, 3, 6, 10}, new int[]{1, 2, 3, 4}, new int[]{1, 5, 8, 11}, new int[]{4, 6, 9, 11}, new int[]{7, 8, 9, 10});

    private static boolean isValid() {
        int tmp;
        for (int[] d : ds) {
            tmp = 0;
            for (int dd : d) {
                tmp += lines[dd] - 'A' + 1;
            }

            if (tmp != 26) {
                return false;
            }
        }

        return true;
    }

    static void draw() {
        int idx = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (ans[i][j] == 'x') {
                    System.out.print(lines[idx++]);
                    continue;
                }
                System.out.print(ans[i][j]);
            }
            System.out.println();
        }
    }
    static class Pos {
        int y, x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}