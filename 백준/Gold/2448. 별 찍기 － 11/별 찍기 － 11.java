import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static char[][] star;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        star = new char[n][n * 2 - 1];

        for (char[] row : star) {
            Arrays.fill(row, ' ');
        }

        makeStar(0, n - 1, n);

        StringBuilder sb = new StringBuilder();

        for (char[] row : star) {
            sb.append(row).append("\n");
        }

        System.out.print(sb);
    }

    private static void makeStar(int y, int x, int n) {
        if (n == 3) {
            star[y][x] = '*';
            star[y + 1][x - 1] = star[y + 1][x + 1] = '*';
            star[y + 2][x - 2] = star[y + 2][x - 1] = star[y + 2][x] = star[y + 2][x + 1] = star[y + 2][x + 2] = '*';
            return;
        }
        int tmp = n / 2;

        makeStar(y, x, tmp);
        makeStar(y + tmp, x - tmp, tmp);
        makeStar(y + tmp, x + tmp, tmp);
    }
}
