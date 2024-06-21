import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[][] tops;
    static int[][] commands;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        tops = new int[n + 1][9];
        String top;
        for (int i = 1; i <= n; i++) {
            top = br.readLine();
            for (int j = 1; j <= 8; j++) {
                tops[i][j] = Character.getNumericValue(top.charAt(j - 1));
            }
        }

        k = Integer.parseInt(br.readLine());
        commands = new int[k][2];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            commands[i][0] = Integer.parseInt(st.nextToken());
            commands[i][1] = Integer.parseInt(st.nextToken());
        }
        rotate();
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (tops[i][1] == 1) {
                answer += 1;
            }
        }

        System.out.print(answer);
    }

    private static void rotate() {
        for (int[] command : commands) {
            visited = new boolean[n + 1];
            if (command[1] == 1) {
                rotateRight(command[0]);
                continue;
            }
            rotateLeft(command[0]);
        }
    }

    private static void rotateLeft(int idx) {
        if (visited[idx]) {
            return;
        }

        visited[idx] = true;

        //돌린 후 오른쪽이 다르면 돌린 방향 반대로 돌리기
        if (idx + 1 <= n && tops[idx + 1][7] != tops[idx][3]) {
            rotateRight(idx + 1);
        }
        //돌린 후 왼쪽이 다르면 돌린 방향 반대로 돌리기
        if (idx - 1 >= 1 && tops[idx - 1][3] != tops[idx][7]) {
            rotateRight(idx - 1);
        }
        tops[idx][0] = tops[idx][1];
        for (int i = 1; i < 8; i++) {
            tops[idx][i] = tops[idx][i + 1];
        }
        tops[idx][8] = tops[idx][0];

    }

    private static void rotateRight(int idx) {
        if (visited[idx]) {
            return;
        }
        visited[idx] = true;

        //돌린 후 오른쪽이 다르면 돌린 방향 반대로 돌리기
        if (idx + 1 <= n && tops[idx + 1][7] != tops[idx][3]) {
            rotateLeft(idx + 1);
        }
        //돌린 후 왼쪽이 다르면 돌린 방향 반대로 돌리기
        if (idx - 1 >= 1 && tops[idx - 1][3] != tops[idx][7]) {
            rotateLeft(idx - 1);
        }

        tops[idx][0] = tops[idx][8];

        for (int i = 8; i >= 2; i--) {
            tops[idx][i] = tops[idx][i - 1];
        }
        tops[idx][1] = tops[idx][0];

    }
}