import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int LEN = 1_000_001;
    static boolean[] isPrime = new boolean[LEN];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        findPrime();
        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }
            goldBauh(n);
        }
        System.out.print(sb);
    }

    private static void findPrime() {
        for (int i = 2; i < Math.sqrt(LEN); i++) {
            if (!isPrime[i]) {
                for (int j = i * i; j < LEN; j += i) {
                    isPrime[j] = true;
                }
            }
        }
    }

    private static void goldBauh(int temp) {
        for (int i = 2; i < temp; i++) {
            if (isPrime[i]) continue;

            int tmp = temp - i;
            if (!isPrime[tmp]) {
                sb.append(temp).append(" = ").append(i).append(" + ").append(tmp).append("\n");
                return;
            }
        }
        sb.append("Goldbach's conjecture is wrong\n");
    }
}