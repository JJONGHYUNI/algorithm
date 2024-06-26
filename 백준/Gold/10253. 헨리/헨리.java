import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        //분자, 분모, 단위분수 분모
        int m, d, henry = 0;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            while (!isZero(m)) {
                henry = findHenry(m, d);

                int[] tmp = subtractHenry(m, d, henry);
                m = tmp[0];
                d = tmp[1];
            }

            System.out.println(henry);
        }
    }

    private static boolean isZero(int m) {
        return m == 0;
    }


    //m / d >= 1.0 / henry
    // 1.0 / d >= 1.0 / henry * m
    // d <= henry * m
    // d / m <= henry;
    // d % m 값이 0 이면 그대로 사용 , 0이 아니면 + 1
    private static int findHenry(int m, int d) {
        int x = d % m ;

        if (x == 0) {
            return d / m;
        }
        return d / m + 1;
    }

    private static int[] subtractHenry(int m, int d, int henry) {
        int mm = m * henry - d;
        int dd = d * henry;

        return new int[]{mm, dd};
    }
}