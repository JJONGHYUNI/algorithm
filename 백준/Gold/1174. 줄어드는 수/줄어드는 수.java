import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    static List<Long> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        // 제일 앞자릿 수
        for (int i = 0; i < 10; i++) {
            solve(Integer.toString(i), i, 0);
        }

        Collections.sort(arr);

        if (n > arr.size()) {
            System.out.print(-1);
            return;
        }

        System.out.print(arr.get(n - 1));
    }

    private static void solve(String cur, int pre, int depth) {
        // 줄어드는 수 중 가장 큰 수는 9_876_543_210을 넘어가면 초과 10자리까지만 보면됨
        if (depth == 10) {
            return;
        }

        arr.add(Long.parseLong(cur));

        for (int i = 0; i < pre; i++) {
            solve(cur + Integer.toString(i), i, depth);
        }
    }
}
