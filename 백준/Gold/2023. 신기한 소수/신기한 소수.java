import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        isExcitingPrime(0, n);
        System.out.print(sb);
    }

    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void isExcitingPrime(int num, int n) {
        if (n == 0) {
            if (isPrime(num)) {
                sb.append(num).append("\n");
                return;
            }
        }

        for (int i = 0; i < 10; i++) {
            int tmp = num * 10 + i;

            if (isPrime(tmp)) {
                isExcitingPrime(tmp, n - 1);
            }
        }
    }
}