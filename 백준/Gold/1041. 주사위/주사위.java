import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    //1면 짜리 4(n-2)(n-1) + (n-2)^2
    //2면 짜리 4(2n - 3)   이웃하는 면
    //3면 짜리 4개         마주보는 면 중 최솟값 더하기
    static long[] dice = new long[6];
    static long max = 0;
    static long sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 6; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        long answer = one() * (4L * (n - 2) * (n - 1) + (long) (n - 2) * (n - 2)) + two() * (4 * (2L * n - 3)) + three() * 4;

        if (n == 1) {
            System.out.print(sum - max);
            return;
        }

        System.out.print(answer);
    }

    private static long one() {
        long tmp = 51;
        for (int i = 0; i < 6; i++) {
            tmp = Math.min(tmp, dice[i]);
            max = Math.max(max, dice[i]);
            sum += dice[i];
        }
        return tmp;
    }

    private static long two() {
        long tmp = 102;
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                if (i + j == 5) {
                    continue;
                }
                tmp = Math.min(tmp, dice[i] + dice[j]);
            }
        }
        return tmp;
    }

    private static long three() {
        long tmp = 0;
        for (int i = 0; i < 3; i++) {
            tmp += Math.min(dice[i], dice[5 - i]);
        }
        return tmp;
    }
}
