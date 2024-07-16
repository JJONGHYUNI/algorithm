import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    static int d, n;
    static int[] oven;
    static int[] pizzas;
    static int answer, b;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        d = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        oven = new int[d];
        for (int i = 0; i < d; i++) {
            oven[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        pizzas = new int[n];
        for (int i = 0; i < n; i++) {
            pizzas[i] = Integer.parseInt(st.nextToken());
        }

        //오븐 정렬
        for (int i = 1; i < d; i++) {
            if (oven[i] > oven[i - 1]) {
                oven[i] = oven[i - 1];
            }
        }

        answer = Integer.MAX_VALUE;
        b = d - 1;

        for (int pizza : pizzas) {
            binary(pizza, 0, b);
        }

        System.out.print(answer + 1);
    }

    private static void binary(int pizza, int top, int bottom) {
        int tmp = -1;

        while (top <= bottom) {
            int m = (top + bottom) / 2;

            if (oven[m] >= pizza) {
                tmp = m;
                top = m + 1;
            } else {
                bottom = m - 1;
            }
        }
        answer = Math.min(answer, tmp);
        b = tmp - 1;
    }
}
