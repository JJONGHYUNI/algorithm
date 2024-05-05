import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static List<List<Integer>> friends = new ArrayList<>();
    static int[][] points;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            friends.add(new ArrayList<>());
        }

        points = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                points[i][j] = Integer.MAX_VALUE;
            }
        }

        StringTokenizer st;
        int a, b;

        while (true) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if (a == -1) {
                break;
            }

            friends.get(a).add(b);
            friends.get(b).add(a);
        }
        List<Integer> answer = new ArrayList<>();
        int point = Integer.MAX_VALUE, num = 0;

        for (int i = 1; i <= n; i++) {
            bfs(i);
            int tmp = Arrays.stream(points[i]).max().getAsInt();
            if (tmp < point) {
                answer = new ArrayList<>();
                point = tmp;
                num = 1;
                answer.add(i);
            } else if (tmp == point) {
                num += 1;
                answer.add(i);
            }
        }
        System.out.printf("%d %d\n", point, num);

        answer.forEach(k -> System.out.printf("%d ", k));
    }

    private static void bfs(int cur) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{cur, 0});

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int num = tmp[0];
            int cnt = tmp[1];

            if (cur != num) {
                points[cur][num] = Math.min(points[cur][num], cnt);
            }

            for (int idx : friends.get(num)) {
                if (cur != idx && points[cur][idx] == Integer.MAX_VALUE) {
                    q.add(new int[]{idx, cnt + 1});
                }
            }
        }
    }
}