import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        int n;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            int[] ans = new int[]{0, 0, 0, 0, 0};
            ans[0] += n / 60;

            n %= 60;

            if (n <= 35) {
                if (n % 10 > 5) {
                    ans[1] += n / 10 + 1;
                    ans[4] += 10 - n % 10;
                } else {
                    ans[1] += n / 10;
                    ans[3] += n % 10;
                }
            } else {
                ans[0] += 1;

                if (n % 10 >= 5) {
                    // 10을 한 번 덜 빼고 위에서 아래로 1씩 줄이기
                    ans[2] += 5 - (n / 10);
                    ans[4] += 10 - n % 10;
                } else {
                    // 10을 한 번 더 빼고 아래에서 위로 1씩 올리기
                    ans[2] += 6 - n / 10;
                    ans[3] += n % 10;
                }
            }

            for (int a : ans) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
