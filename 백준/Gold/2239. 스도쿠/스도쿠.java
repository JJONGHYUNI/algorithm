import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] arr = new int[Number.NINE.getValue()][Number.NINE.getValue()];
    static List<Empty> empties = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static boolean isExit = false;

    enum Number {
        ZERO(0), ONE(1), THREE(3), NINE(9);

        private final int value;

        Number(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    static class Empty {
        int y, x;

        Empty(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {

        for (int i = Number.ZERO.getValue(); i < Number.NINE.getValue(); i++) {
            String s = br.readLine();
            for (int j = Number.ZERO.getValue(); j < Number.NINE.getValue(); j++) {
                arr[i][j] = Integer.parseInt(s.charAt(j) + "");
                if (arr[i][j] == Number.ZERO.getValue()) {
                    empties.add(new Empty(i, j));
                }
            }
        }

        dfs(Number.ZERO.getValue());
        System.out.print(sb);
    }

    private static void dfs(int depth) {

        if (isExit) {
            return;
        }

        if (depth == empties.size()) {
            for (int[] a : arr) {
                for (int b : a) {
                    sb.append(b);
                }
                sb.append("\n");
            }
            isExit = true;
            return;
        }

        Empty empty = empties.get(depth);

        for (int i = Number.ONE.getValue(); i <= Number.NINE.getValue(); i++) {
            if (isValid(empty.y, empty.x, i) && !isExit) {
                arr[empty.y][empty.x] = i;
                dfs(depth + 1);
                arr[empty.y][empty.x] = Number.ZERO.getValue();
            }
        }
    }

    private static boolean isValid(int y, int x, int num) {

        for (int i = Number.ZERO.getValue(); i < Number.NINE.getValue(); i++) {
            if (arr[y][i] == num || arr[i][x] == num) {
                return false;
            }
        }

        int dy = (y / Number.THREE.getValue()) * Number.THREE.getValue();
        int dx = (x / Number.THREE.getValue()) * Number.THREE.getValue();

        for (int i = dy; i < dy + Number.THREE.getValue(); i++) {
            for (int j = dx; j < dx + Number.THREE.getValue(); j++) {
                if (arr[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
