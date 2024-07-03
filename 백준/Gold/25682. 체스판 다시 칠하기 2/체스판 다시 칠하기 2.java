import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m, k;
    static char[][] chessBoard;

    // 맨 왼쪽 위 흰색일 때 , 검정색일 때 각각 누적합
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        chessBoard = new char[n][m];
        String s;

        for (int i = 0; i < n; i++) {
            s = br.readLine();
            for (int j = 0; j < m; j++) {
                chessBoard[i][j] = s.charAt(j);
            }
        }

        // 왼쪽 맨 위 컬러
        int[][] blackBoard = findSum('B');
        int[][] whiteBoard = findSum('W');

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= n - k; i++) {
            for (int j = 0; j <= m - k; j++) {
                min = Math.min(min, blackBoard[i + k][j + k] - blackBoard[i][j + k] - blackBoard[i + k][j] + blackBoard[i][j]);
                min = Math.min(min, whiteBoard[i + k][j + k] - whiteBoard[i][j + k] - whiteBoard[i + k][j] + whiteBoard[i][j]);
            }
        }
        System.out.print(min);
    }

    public static int[][] findSum(char color) {
        int[][] sumBoard = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sumBoard[i][j] -= sumBoard[i - 1][j - 1];
                if (((i - 1) + (j - 1)) % 2 == 0) {
                    sumBoard[i][j] += sumBoard[i - 1][j] + sumBoard[i][j - 1];
                    if (chessBoard[i - 1][j - 1] != color) {
                        sumBoard[i][j] += 1;
                    }
                    continue;
                }

                sumBoard[i][j] += sumBoard[i - 1][j] + sumBoard[i][j - 1];
                if (chessBoard[i - 1][j - 1] == color) {
                    sumBoard[i][j] += 1;
                }
            }
        }

        return sumBoard;
    }
}