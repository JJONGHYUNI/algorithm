import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] tops = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            tops[i] = Integer.parseInt(br.readLine());
            sum += tops[i];
        }
        // 0, 1 선택하고 시작
        int left = 0, right = 1;
        int distR = tops[left];
        int distL = sum - distR;
        int answer = 0;
        while (left < n) {
            answer = Math.max(answer, Math.min(distL, distR));

            if (distR < distL) {
                distR += tops[right];
                distL -= tops[right];
                right += 1;
                right %= n; // right 는 한 바퀴 넘어가도 계속 순회
            }

            else {
                distR -= tops[left];
                distL += tops[left];
                left += 1;
            }
        }

        System.out.print(answer);
    }
}