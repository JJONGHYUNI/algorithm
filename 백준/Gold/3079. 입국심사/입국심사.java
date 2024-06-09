import java.io.*;
import java.util.*;


class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];

        long left = 1_000_000_000;
        long right = 0l;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            right = Math.max(arr[i], right);
            left = Math.min(arr[i], left);
        }

        right *= m;
        long mid, cnt;

        while (left <= right) {
            mid = (left + right) / 2;
            cnt = 0;
            for (long tmp : arr) {
                cnt += mid / tmp;
                if (cnt >= m) {
                    break;
                }
            }
            if (cnt < m) {
                left = mid + 1;
                continue;
            }
            right = mid - 1;
        }

        System.out.print(left);
    }
}