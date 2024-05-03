import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int five = findFive(n) - findFive(m) - findFive(n - m);
        int two = findTwo(n) - findTwo(m) - findTwo(n - m);

        System.out.print(Math.min(five, two));
    }

    private static int findFive(int num) {
        int cnt = 0;
        while (num >= 5) {
            cnt += num / 5;
            num /= 5;
        }

        return cnt;
    }

    private static int findTwo(int num) {
        int cnt = 0;
        while (num >= 2) {
            cnt += num / 2;
            num /= 2;
        }
        return cnt;
    }
}