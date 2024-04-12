import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken();
        int answer = 0;
        int maxSquare = 0;
        int previous = Integer.parseInt(st.nextToken());
        int first = previous;
        for (int i = 1; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            int cur = Integer.parseInt(st.nextToken());
            int tmp = previous * cur;
            answer += tmp;
            maxSquare = Math.max(maxSquare, tmp);
            previous = cur;
        }
        int lastSquare = first * previous;
        maxSquare = Math.max(maxSquare, lastSquare);
        answer += lastSquare;
        answer -= maxSquare * 2;
        System.out.print(answer * k);
    }
}
