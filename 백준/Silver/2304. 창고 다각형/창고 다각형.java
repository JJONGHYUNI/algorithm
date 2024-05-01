import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static List<int[]> wareHouse = new ArrayList<>();
    static int[] maxHeight = new int[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            wareHouse.add(new int[]{l, r});
            if (maxHeight[1] < r) {
                maxHeight[0] = l;
                maxHeight[1] = r;
            }
            if (maxHeight[1] == r && maxHeight[0] < l) {
                maxHeight[0] = l;
                maxHeight[1] = r;
            }
        }

        Collections.sort(wareHouse, Comparator.comparingInt(a -> a[0]));

        int beforeL = 0;
        int beforeH = 0;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            int curL = wareHouse.get(i)[0];
            int curH = wareHouse.get(i)[1];

            if (curL == maxHeight[0] && curH == maxHeight[1]) {
                idx = i + 1;
                answer += beforeH * (curL - beforeL);
                answer += curH;
                beforeL = curL;
                break;
            }
            if (beforeH < curH) {
                answer += beforeH * (curL - beforeL);
                beforeL = curL;
                beforeH = curH;
            }
        }

        beforeH = 0;

        while (idx < n) {
            for (int i = idx; i < n; i++) {
                if (beforeH < wareHouse.get(i)[1]) {
                    idx = i;
                    beforeH = wareHouse.get(i)[1];
                }
            }

            answer += beforeH * (wareHouse.get(idx)[0] - beforeL);
            beforeL = wareHouse.get(idx)[0];
            beforeH = 0;
            idx += 1;
        }
        System.out.print(answer);
    }
}