import java.io.*;
import java.util.*;

class Main {
    // 벌 벌 꿀통 -> 맨 왼쪽 벌 한 마리, 꿀통 끝, 벌 한 마리만 찾기
    // 벌 꿀통 벌 -> 벌 양 끝, 꿀통 하나씩 고르면서 찾기
    // 꿀통 벌 벌 -> 맨 오른쪽 벌 한 마리, 꿀 통 왼쪽 끝, 벌 한 마리만 찾기

    static long[] honeys;
    static long answer = 0, maxNum = 0;
    static int n;
    static long[] sum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        honeys = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0;  i < n; i++) {
            honeys[i] = Integer.parseInt(st.nextToken());
            maxNum = Math.max(honeys[i], maxNum);
        }

        sum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] += honeys[i - 1] + sum[i - 1];
        }
        left();
        middle();
        right();
        System.out.println(answer);
    }

    private static void left() {
        long tmp;
        for (int i = 2; i < n; i++) {
            tmp = sum[n] + sum[n] - sum[i] - sum[1] - honeys[i - 1];
            answer = Math.max(tmp, answer);
        }
    }

    private static void middle() {
        answer = Math.max(answer, sum[n] - honeys[0] - honeys[n - 1] + maxNum);
    }

    private static void right() {
        long tmp;
        for (int i = 1; i < n; i++) {
            tmp = sum[n] - honeys[n - 1] + sum[i] - honeys[i - 1] * 2;
            answer = Math.max(tmp, answer);
        }
    }
}