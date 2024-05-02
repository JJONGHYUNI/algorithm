import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int n;
        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            int answer = 1;
            int[] grade = new int[n + 1];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int doc = Integer.parseInt(st.nextToken());
                int interView = Integer.parseInt(st.nextToken());

                grade[doc] = interView;
            }
            int interView = grade[1];

            for (int j = 2; j <= n; j++) {
                if (interView > grade[j]) {
                    answer += 1;
                    interView = grade[j];
                }
            }
            System.out.println(answer);
        }
    }
}