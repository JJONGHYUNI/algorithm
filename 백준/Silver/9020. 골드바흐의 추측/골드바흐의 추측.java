import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int len = 10_000;
    static List<Integer> primeList = new ArrayList<>();
    static boolean[] isPrime = new boolean[len + 1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        makePrimeList();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] partition = new int[2];
            for (int prime : primeList) {
                int tmp = n - prime;
                if (tmp < n / 2) {
                    break;
                }
                if (isPrime[tmp]) {
                    partition[0] = prime;
                    partition[1] = tmp;
                }
            }
            sb.append(partition[0]).append(" ").append(partition[1]).append("\n");
        }
        System.out.print(sb);
    }

    private static void makePrimeList() {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i < Math.sqrt(len); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= len; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i <= len; i++) {
            if (isPrime[i]) {
                primeList.add(i);
            }
        }
    }
}