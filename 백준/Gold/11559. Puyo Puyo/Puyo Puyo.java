import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static char[][] board = new char[12][6];
    static int cnt = 0;
    static boolean isPop = false;

    static int[] d = {0, 0, -1, 1};

    static class Puyo {
        int y, x;
        char color;

        Puyo(int y, int x, char color) {
            this.y = y;
            this.x = x;
            this.color = color;
        }
    }

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 12; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < 6; j++) {
                board[i][j] = tmp.charAt(j);
            }
        }

        while(true) {
            isPop = false;

            bfs();
            down();

            if (!isPop) {
                break;
            }
            cnt++;
        }

        System.out.print(cnt);
    }

    private static void down() {
        for (int i = 0; i < 6; i++) {
            Queue<Puyo> q = new LinkedList<>();
            int idx = 11;

            for (int j = 11; j >= 0; j--) {
                if (board[j][i] != '.') {
                    q.add(new Puyo(j, i, board[j][i]));
                    board[j][i] = '.';
                }
            }

            while (!q.isEmpty()) {
                Puyo p = q.poll();
                board[idx--][i] = p.color;
            }
        }
    }

    private static void bfs() {
        Queue<Puyo> q = new LinkedList<>();
        boolean[][] visited = new boolean[12][6];

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if(board[i][j] != '.' && !visited[i][j]) {
                    visited[i][j] = true;
                    q.add(new Puyo(i, j, board[i][j]));
                    List<int[]> positions = new ArrayList<>();
                    positions.add(new int[]{i, j});

                    while(!q.isEmpty()) {
                        Puyo p = q.poll();

                        int y = p.y;
                        int x = p.x;
                        char color = p.color;

                        for (int k = 0; k < 4; k++) {
                            int dx = x + d[k];
                            int dy = y + d[3 - k];

                            if (dy < 0 || dy >= 12 || dx < 0 || dx >= 6) {
                                continue;
                            }

                            if (!visited[dy][dx] && board[dy][dx] == color) {
                                visited[dy][dx] = true;
                                q.add(new Puyo(dy, dx, board[dy][dx]));
                                positions.add(new int[]{dy, dx});
                            }
                        }
                    }

                    if (positions.size() >= 4) {
                        for (int[] position : positions) {
                            board[position[0]][position[1]] = '.';
                            isPop = true;
                        }
                    }
                }
            }
        }
    }
}