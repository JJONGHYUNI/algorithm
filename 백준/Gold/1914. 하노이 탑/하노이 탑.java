import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BigInteger cnt = new BigInteger("2");
        System.out.println(cnt.pow(n).subtract(new BigInteger("1")));

        if (n <= 20) {
            hanoi(n, 1, 3);
            System.out.print(sb);
        }
    }

    private static void hanoi(int n, int from, int to) {
        if (n == 0) {
            return;
        }

        hanoi(n - 1, from, 6 - from - to);
        sb.append(from).append(" ").append(to).append("\n");
        hanoi(n - 1, 6 - from - to, to);
    }

}
