import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Map<Integer, List<Integer>> likes = new HashMap<>();
    static int[][] seat;
    static int[] students;
    static int[] d = new int[]{-1, 1, 0, 0};
    static int n;

    static class Seat implements Comparable<Seat>{
        int y;
        int x;
        int like;
        int empty;

        public Seat(int y, int x, int like, int empty) {
            this.y = y;
            this.x = x;
            this.like = like;
            this.empty = empty;
        }

        @Override
        public int compareTo(Seat o) {
            if (like != o.like) {
                return -(like - o.like);
            }

            if (empty != o.empty) {
                return -(empty - o.empty);
            }

            if (y != o.y) {
                return y - o.y;
            }

            return x - o.x;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        putSeat();
        System.out.print(getAnswer());
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        students = new int[n * n];
        seat = new int[n][n];

        StringTokenizer st;

        for (int i = 0; i < n * n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            students[i] = num;

            likes.put(num, new ArrayList<>());

            for (int j = 0; j < 4; j++) {
                likes.get(num).add(Integer.parseInt(st.nextToken()));
            }
        }
    }

    private static void putSeat() {

        for (int i = 0; i < n * n; i++) {
            int num = students[i];
            Seat s = null;

            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    if (seat[y][x] != 0) {
                        continue;
                    }

                    int[] cnts = findLikeAndEmptyCnt(y, x, num);
                    Seat tmp = new Seat(y, x, cnts[0], cnts[1]);

                    if (s == null) {
                        s = tmp;
                        continue;
                    }

                    if (s.compareTo(tmp) < 0) {
                        continue;
                    }

                    s = tmp;
                }
            }

            seat[s.y][s.x] = num;
        }
    }

    private static int[] findLikeAndEmptyCnt(int y, int x, int num) {
        int likeCnt = 0;
        int emptyCnt = 0;

        for (int i = 0; i < 4; i++) {
            int dy = y + d[i];
            int dx = x + d[3 - i];

            if (dy < 0 || dy >= n || dx < 0 || dx >= n) {
                continue;
            }

            int tmp = seat[dy][dx];

            if (tmp == 0) {
                emptyCnt += 1;
                continue;
            }

            if (likes.get(num).contains(tmp)) {
                likeCnt += 1;
            }
        }

        return new int[]{likeCnt, emptyCnt};
    }

    private static int getAnswer() {
        int answer = 0;

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                int tmp = seat[y][x];

                int[] cnts = findLikeAndEmptyCnt(y, x, tmp);
                answer += Math.pow(10, cnts[0] - 1);
            }
        }

        return answer;
    }
}