import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int RANGE = 1_000_000;
    static boolean[] isPrime = new boolean[1_000_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        prime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int answer = 0;
            int tmp = Integer.parseInt(br.readLine());
            for (int j = 2; j <= tmp / 2; j++) {
                if (!isPrime[j] && !isPrime[tmp - j]) {
                    answer++;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }

    private static void prime() {
        for (int i = 2; i <= RANGE; i++) {
            if (isPrime[i]) {
                continue;
            }
            for (int j = i + i; j <= RANGE; j = j + i) {
                isPrime[j] = true;
            }
        }
    }
}