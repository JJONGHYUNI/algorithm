import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int minValue = 2000000001;
        int l = 0;
        int r = 0;
        while (l <= r && r < n) {
            int tmp = Math.abs(arr[r] - arr[l]);
            if (tmp >= m) {
                l += 1;
                minValue = Math.min(minValue, tmp);
                continue;
            }
            r += 1;
        }
        System.out.println(minValue);
    }
}