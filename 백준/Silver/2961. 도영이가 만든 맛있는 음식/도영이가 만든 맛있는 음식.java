import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int s, b;
    static int[][] board;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][2];
        visited = new boolean[n];
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            combi(0, i + 1, 0);
            if (answer == 0) {
                break;
            }
        }

        System.out.print(answer);
    }

    private static void combi(int idx, int cnt, int curCnt) {
        if (curCnt == cnt) {
            cook();
            return;
        }

        for (int i = idx; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combi(i + 1, cnt, curCnt + 1);
                visited[i] = false;
            }
        }
    }

    private static void cook() {
        s = 1;
        b = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
              s *= board[i][0];
              b += board[i][1];
            }
        }
        int dif = Math.abs(s - b);
        answer = Math.min(dif, answer);
    }
}