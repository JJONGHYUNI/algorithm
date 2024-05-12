import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> limits = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            limits.add(Integer.parseInt(st.nextToken()));
        }

        limits.sort(Collections.reverseOrder());

        int m = Integer.parseInt(br.readLine());
        List<Integer> boxes = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }

        boxes.sort(Collections.reverseOrder());
        int cnt = 0;

        if (boxes.get(0) > limits.get(0)) {
            System.out.print(-1);
            return;
        }

        while (!boxes.isEmpty()) {
            int limitIdx = 0, boxIdx = 0;
            cnt += 1;

            while (limitIdx < n) {
                if (boxIdx == boxes.size()) {
                    break;
                } else if (limits.get(limitIdx) >= boxes.get(boxIdx)) {
                    boxes.remove(boxIdx);
                    limitIdx += 1;
                    continue;
                }
                boxIdx += 1;
            }
        }

        System.out.print(cnt);

    }

}