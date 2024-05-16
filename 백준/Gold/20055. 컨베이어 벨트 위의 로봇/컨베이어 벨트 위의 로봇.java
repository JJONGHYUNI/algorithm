import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] conveyor;
    static int n, k, cnt = 0;
    static boolean[] robots;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        conveyor = new int[2 * n + 1];
        robots = new boolean[n + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= 2 * n; i++) {
            conveyor[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;

        while (!fourth()) {
            answer += 1;
            first();
            second();
            third();
        }

        System.out.print(answer);
    }

    private static void first() {
        int tmp = conveyor[2 * n];
        for (int i = 2 * n; i > 1; i--) {
            conveyor[i] = conveyor[i - 1];
        }
        conveyor[1] = tmp;

        for (int i = n; i > 1; i--) {
            robots[i] = robots[i - 1];
        }

        robots[1] = false;
        robots[n] = false;
    }

    private static void second() {
        for (int i = n; i > 1; i--) {
            if (robots[i - 1] && !robots[i] && conveyor[i] > 0) {
                conveyor[i]--;
                robots[i] = true;
                robots[i - 1] = false;
            }
        }

        robots[n] = false;
    }

    private static void third() {
        if (conveyor[1] > 0) {
            robots[1] = true;
            conveyor[1]--;
        }
    }

    private static boolean fourth() {
        int cnt = 0;

        for (int tmp : conveyor) {
            if (tmp == 0) {
                cnt += 1;
            }
        }
        if (cnt >= k + 1) {
            return true;
        }
        return false;
    }
}