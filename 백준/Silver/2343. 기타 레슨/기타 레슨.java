import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;
    static int l,r;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        l = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            l = Math.max(l, arr[i]);
            r += arr[i];
        }

        while (l <= r) {
            int mid = (l + r) / 2;
            int cnt = howCount(mid);
            if (cnt > m) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.print(l);
    }

    private static int howCount(int mid) {
        int cnt = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (sum + arr[i] > mid) {
                sum = 0;
                cnt += 1;
            }
            sum += arr[i];
        }
        if (sum != 0) cnt+= 1;
        return cnt;
    }
}