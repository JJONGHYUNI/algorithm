import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int g = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        long multiple = (long) g * l;
        long a = 0, b =0;

        for (int i = g; i <= Math.sqrt(multiple); i += g) {
            if (multiple % i == 0 && gcd(i, multiple / i) == g) {
                a = i;
                b = multiple / i;
            }
        }

        System.out.printf("%d %d", a, b);
    }


    private static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}