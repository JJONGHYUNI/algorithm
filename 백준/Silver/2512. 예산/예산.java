import java.util.*;
import java.io.*;
import java.util.stream.IntStream;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] urbans = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        IntStream.range(0, n).forEach(i -> urbans[i] = Integer.parseInt(st.nextToken()));
        int m = Integer.parseInt(br.readLine());

        Arrays.sort(urbans);
        int idx = 0;
        int answer = 0;
        while(n != 0) {
            int tmp = m / n;
            if(urbans[idx] <= tmp) {
                m -= urbans[idx];
                idx += 1;
                n -= 1;
                continue;
            }
            answer = tmp;
            break;
        }
        if (answer == 0) {
            answer = urbans[urbans.length - 1];
        }
        System.out.println(answer);
    }

}