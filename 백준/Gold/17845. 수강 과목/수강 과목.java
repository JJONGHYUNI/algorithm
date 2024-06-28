import java.io.*;
import java.util.*;

// 추측 문제 유형 : dp , 실제 문제 유형 : dp
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static class Subject {
        int l, t;

        public Subject(int l, int t) {
            this.l = l;
            this.t = t;
        }

    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Subject> subjects = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            subjects.add(new Subject(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int[] dp = new int[n + 1];
        int answer = 0;

        for (int i = 0; i < k; i++) {
            Subject subject = subjects.get(i);
            for (int j = n; j >= 1; j--) {
                if (subject.t <= j) {
                    dp[j] = Math.max(dp[j], dp[j - subject.t] + subject.l);
                }
            }
        }

        System.out.print(dp[n]);
    }
}