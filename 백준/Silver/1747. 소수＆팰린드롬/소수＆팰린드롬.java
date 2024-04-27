import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int LEN = 1_004_001;
    static boolean[] isPrime = new boolean[LEN];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        makePrime();

        while (n < LEN) {
            if (isPrime[n] && isPelin(Integer.toString(n).toCharArray())) {
                System.out.println(n);
                break;
            }
            n += 1;
        }
    }

    private static boolean isPelin(char[] tmp) {
        int len = tmp.length;
        for (int i = 0; i < len / 2; i++) {
            if (tmp[i] != tmp[len - i - 1]) {
                return false;
            }
        }
        return true;
    }

    private static void makePrime() {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i < Math.sqrt(LEN); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < LEN; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}