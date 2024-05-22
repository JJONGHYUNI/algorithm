import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int[][] arr;
    static int n, m, r;
    static int[][] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < r; i++) {
            rotateArray(Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();

        for (int[] a : arr) {
            for (int b : a) {
                sb.append(b).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);

    }

    private static void rotateArray(int c) {
        temp = new int[n][m];

        if (c == 1) {
            one();
        } else if (c == 2) {
            two();
        } else if (c == 3) {
            three();
        } else if (c == 4) {
            four();
        } else if (c == 5) {
            five();
        } else {
            six();
        }

        arr = temp;
    }

    private static void one() {
        temp = new int[n][m];

        for (int i = 0; i < n; i++) {
            temp[n - i - 1] = arr[i];
        }
    }

    private static void two() {
        temp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[i][m - j - 1] = arr[i][j];
            }
        }
    }

    private static void three() {
        temp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = arr[n - j - 1][i];
            }
        }

        int tmp = n;
        n = m;
        m = tmp;
    }

    private static void four() {
        temp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = arr[j][m - i - 1];
            }
        }

        int tmp = n;
        n = m;
        m = tmp;
    }

    static int[][] d = new int[][]{{0, 0}, {0, 1}, {1, 1}, {1, 0}, {0, 0}};

    private static void five() {
        temp = new int[n][m];
        int h = n / 2;
        int w = m / 2;

        for (int k = 0; k < 4; k++) {
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    temp[h * d[k + 1][0] + i][w * d[k + 1][1] + j] = arr[h * d[k][0] + i][w * d[k][1] + j];
                }
            }
        }
    }

    private static void six() {
        temp = new int[n][m];

        int h = n / 2;
        int w = m / 2;

        for (int k = 0; k < 4; k++) {
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    temp[h * d[k][0] + i][w * d[k][1] + j] = arr[h * d[k + 1][0] + i][w * d[k + 1][1] + j];
                }
            }
        }
    }
}