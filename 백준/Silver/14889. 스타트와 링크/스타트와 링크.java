import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] board;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        visited = new boolean[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        combi(0, 0);
        System.out.print(answer);
    }

    private static void combi(int idx, int cnt) {
        if (cnt == n / 2) {
            findMin();
            return;
        }

        for (int i = idx; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combi(i + 1, cnt + 1);
                visited[i] = false;
            }
        }
    }

    private static void findMin() {
        int start = 0;
        int link = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visited[i] && visited[j]) {
                    start += board[i][j] + board[j][i];
                } else if (!visited[i] && !visited[j]) {
                    link += board[i][j] + board[j][i];
                }
            }
        }

        int dif = Math.abs(start - link);
        answer = Math.min(answer, dif);
    }
}