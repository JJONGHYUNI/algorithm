import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static boolean[][] isKnow;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        isKnow = new boolean[n + 1][n + 1];
        int a, b;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            isKnow[a][b] = true;
        }
        floodWarshall();
        System.out.print(getAnswer());
    }

    private static void floodWarshall() {

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (isKnow[i][k] && isKnow[k][j]) {
                        isKnow[i][j] = true;
                    }
                }
            }
        }
    }

    private static int getAnswer() {
        boolean tmp;
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            tmp = true;
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                if (!isKnow[i][j] && !isKnow[j][i]) {
                    tmp = false;
                    break;
                }
            }
            if (tmp) answer++;
        }

        return answer;
    }
}