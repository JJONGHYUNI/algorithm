import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int[][] arr = new int[9][9];
        int y = 0;
        int x = 0;
        int max = -1;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                    y = i;
                    x = j;
                }
            }
        }

        System.out.println(max);
        System.out.printf("%d %d", y + 1, x + 1);
    }
}