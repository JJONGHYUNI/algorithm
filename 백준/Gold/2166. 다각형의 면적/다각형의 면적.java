import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Pos {
        long x;
        long y;

        public Pos(long x, long y) {
            this.x = x;
            this.y = y;
        }
        
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Pos> pos = new ArrayList<>();
        StringTokenizer st;
        int y, x;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            pos.add(new Pos(x, y));
        }
        pos.add(new Pos(pos.get(0).x, pos.get(0).y));

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += pos.get(i).x * pos.get(i + 1).y - pos.get(i + 1).x * pos.get(i).y;
        }
        double answer = 1d * Math.abs(sum) / 2;

        System.out.printf("%.1f", answer);
    }
}