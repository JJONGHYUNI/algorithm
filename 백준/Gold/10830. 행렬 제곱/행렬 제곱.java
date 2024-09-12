import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    private static int MOD = 1_000;
    private static int n;
    private static int[][] origin;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        origin = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                origin[i][j] = Integer.parseInt(st.nextToken()) % MOD;
            }
        }

        int[][] res = pow(origin, b);
        for(int[] i : res) {
            for (int j : i) {
                sb.append(j).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static int[][] pow(int[][] a, long exp) {

        if (exp == 1L) {
            return a;
        }

        int[][] tmp = pow(a, exp / 2);

        tmp = multiply(tmp, tmp);

        if(exp % 2 == 1L) {
            tmp = multiply(tmp, origin);
        }

        return tmp;
    }

    private static int[][] multiply(int[][] a, int[][] b) {

        int[][] tmp = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    tmp[i][j] += a[i][k] * b[k][j];
                    tmp[i][j] %= MOD;
                }
            }
        }

        return tmp;
    }
}