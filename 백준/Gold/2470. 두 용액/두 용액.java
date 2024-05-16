import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int l = 0;
        int r = n - 1;
        int maxL = 0, maxR = 0;
        int max = Integer.MAX_VALUE;

        while (l < r) {
            int tmp = Math.abs(arr[l] + arr[r]);

            if (max > tmp) {
                max = tmp;
                maxL = l;
                maxR = r;
            }

            if (arr[r] > 0 && arr[l] + arr[r] > 0) {
                r -= 1;
                continue;
            }

            l += 1;
        }

        System.out.printf("%d %d", arr[maxL], arr[maxR]);
    }
}
