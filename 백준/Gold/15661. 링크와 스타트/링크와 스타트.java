import java.io.*;
import java.util.*;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, answer = Integer.MAX_VALUE;
    static int[][] points;
    static boolean[] team;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        points = new int[n][n];
        team = new boolean[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                points[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        find(0);
        System.out.print(answer);
    }

    private static void find(int depth) {
        if (depth == n) {
            int start = 0, link = 0;

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    //둘이 다른 팀이면 계산 x
                    if (team[i] != team[j]) {
                        continue;
                    }

                    if (team[i]) {
                        start += points[i][j] + points[j][i];
                        continue;
                    }
                    link += points[i][j] + points[j][i];
                }
            }

            answer = Math.min(answer, Math.abs(start - link));
            return;
        }

        team[depth] = true;
        find(depth + 1);
        team[depth] = false;
        find(depth + 1);
    }
}