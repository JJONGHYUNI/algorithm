import java.util.*;
import java.io.*;
import java.util.stream.IntStream;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] trees = new int[n];
        int l = 0;
        int r = -1;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            r = Math.max(r, trees[i]);
        }

        while (l <= r) {
            int mid = (l + r) / 2;
            long tree = 0;
            for (int i = 0; i < n; i++) {
                if (trees[i] > mid) {
                    tree += trees[i] - mid;
                }
            }
            if (tree >= m) {
                l = mid + 1;
                continue;
            }
            r = mid - 1;
        }
        System.out.println(r);
    }
}