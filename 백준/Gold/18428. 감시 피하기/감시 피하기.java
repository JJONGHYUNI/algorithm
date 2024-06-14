import java.io.*;
import java.util.*;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static String[][] map;
    static List<int[]> teachers = new ArrayList<>();
    static String answer = "NO";
    static int idx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new String[n][n];
        StringTokenizer st;

        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                map[y][x] = st.nextToken();
                if (map[y][x].equals("T")) {
                    teachers.add(new int[]{y, x});
                }
            }
        }

        insertObstacle(0);
        System.out.print(answer);
    }

    private static void insertObstacle(int depth) {
        if (depth == 3) {
            if (findStudent()) {
                answer = "YES";
            }

            return;
        }

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (map[y][x].equals("X")) {
                    map[y][x] = "O";
                    insertObstacle(depth + 1);
                    map[y][x] = "X";
                }
            }
        }
    }

    private static boolean findStudent() {
        for (int[] teacher : teachers) {
            if (!find(teacher[0], teacher[1])) {
                return false;
            }
        }

        return true;
    }

    private static boolean find(int y, int x) {
        //상
        for (int i = y - 1; i >= 0; i--) {
            if (map[i][x].equals("S")) {
                return false;
            }

            if (map[i][x].equals("O")) {
                break;
            }
        }

        //하
        for (int i = y + 1; i < n; i++) {
            if (map[i][x].equals("S")) {
                return false;
            }

            if (map[i][x].equals("O")) {
                break;
            }
        }

        //좌
        for (int i = x - 1; i >= 0; i--) {
            if (map[y][i].equals("S")) {
                return false;
            }

            if (map[y][i].equals("O")) {
                break;
            }
        }

        //우
        for (int i = x + 1; i < n; i++) {
            if (map[y][i].equals("S")) {
                return false;
            }

            if (map[y][i].equals("O")) {
                break;
            }
        }

        return true;
    }
}