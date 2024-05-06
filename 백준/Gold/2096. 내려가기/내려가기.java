import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[] dp1 = new int[3];
        int[] dp2 = new int[3];
        int a, b, c;
        int before_zero, before_one, before_two;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (i == 0) {
                dp1[0] = dp2[0] = a;
                dp1[1] = dp2[1] = b;
                dp1[2] = dp2[2] = c;
                continue;
            }

            before_zero = dp1[0];
            before_one = dp1[1];
            before_two = dp1[2];

            dp1[0] = a + Math.max(before_zero, before_one);
            dp1[1] = b + Math.max(Math.max(before_zero, before_one), before_two);
            dp1[2] = c + Math.max(before_one, before_two);

            before_zero = dp2[0];
            before_one = dp2[1];
            before_two = dp2[2];

            dp2[0] = a + Math.min(before_zero, before_one);
            dp2[1] = b + Math.min(Math.min(before_zero, before_one), before_two);
            dp2[2] = c + Math.min(before_one, before_two);

        }

        System.out.printf("%d %d", Arrays.stream(dp1).max().getAsInt(), Arrays.stream(dp2).min().getAsInt());
    }
}