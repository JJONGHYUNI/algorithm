import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static String t;
    static int width, n;
    static int[] legos;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static final String ANSWER_FORMAT = "%s %d %d";

    public static void main(String[] args) throws IOException {


        while ((t = br.readLine()) != null) {
            init();
            binarySearch();
        }

        System.out.print(sb);
    }

    private static void init() throws IOException {

        // 너비 나노센치로 변환
        width = Integer.parseInt(t) * (int) Math.pow(10, 7);
        n = Integer.parseInt(br.readLine());
        legos = new int[n];

        for (int i = 0; i < n; i++) {
            legos[i] = Integer.parseInt(br.readLine());
        }
    }

    private static void binarySearch() {

        Arrays.sort(legos);

        int l = 0;
        int r = n - 1;

        while (l < r) {

            int sum = legos[l] + legos[r];

            if (sum == width) {
                sb.append(String.format(ANSWER_FORMAT, "yes", legos[l], legos[r])).append("\n");
                return;
            } else if (sum > width) {
                r--;
                continue;
            }

            l++;
        }

        sb.append("danger").append("\n");
    }
}
