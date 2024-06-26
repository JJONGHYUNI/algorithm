import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[] B = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        while(!checkAEqualB(B)) {
            if (isValidDivision(B)) {
                for (int i = 0; i < n; i++) {
                    B[i] /= 2;
                }
                answer += 1;
            } else {
                for (int i = 0; i < n; i++) {
                    if (B[i] != 0 && B[i] % 2 != 0) {
                        B[i] -= 1;
                        answer += 1;
                    }
                }
            }
        }
        System.out.print(answer);
    }

    private static boolean checkAEqualB(int[] b) {
        for (int tmp : b) {
            if (tmp == 0) {
                continue;
            }

            return false;
        }

        return true;
    }

    private static boolean isValidDivision(int[] b) {
        for (int tmp : b) {
            if (tmp % 2 == 0) {
                continue;
            }

            return false;
        }

        return true;
    }
}