import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 1 2 3  4  5  6  7   8   9   10  11  12  13  14
    // 4 7 44 47 74 77 444 447 474 477 744 747 774 777
    // +1 한 후2로 나눴을 때 나머지
    // 0 1 00 10 01 11 000 100 010 110 ~~
    // 0은 4 1은 7에 매핑 후 거꾸로 뒤집기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()) + 1;
        StringBuilder sb = new StringBuilder();

        // 0 이면 4, 1이면 7
        int[] mapper = new int[]{4, 7};
        int tmp;

        while (n != 1) {
            tmp = n % 2;
            sb.append(mapper[tmp]);
            n /= 2;
        }

        System.out.print(sb.reverse());
    }
}
