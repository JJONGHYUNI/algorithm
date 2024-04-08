import java.util.*;
import java.io.*;
import java.util.stream.IntStream;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        int min = 0;
        int max = 256;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j ++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(arr[i][j], min);
                max = Math.max(arr[i][j], max);
            }
        }
        int answer = 13 * 10000000;
        int height = 0;
        for (int i = min; i <= max; i++) {
            int block = b;
            int time = 0;
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    int tmp = arr[y][x] - i;
                    if (tmp > 0) {
                        block += tmp;
                        time += tmp * 2;
                    } else if (tmp < 0) {
                        block += tmp;
                        time += (-tmp);
                    }
                }
            }
            if (block >= 0 && answer >= time) {
                answer = time;
                height = i;
            }
        }
        System.out.print(answer + " " + height);
    }
}