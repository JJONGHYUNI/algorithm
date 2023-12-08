import java.util.*;
class Solution {
        private static final int[] d = {0, 0, -1, 1};
    private boolean[][] visited;
    private int oilIndex = 1;
    private Map<Integer, Integer> oilVolume = new HashMap<>();
    private Oil oilInfo = new Oil();

    class Pos {
        int y;
        int x;
        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    class Oil {
        Map<Integer, List<Pos>> oil = new HashMap<>();

        public void addOil(Pos pos, int oilIdx) {
            if (validate(oilIdx)) {
                oil.get(oilIdx).add(pos);
                return;
            }
            oil.put(oilIdx, new ArrayList<>());
            oil.get(oilIdx).add(pos);
        }

        private boolean validate(int oilIdx) {
            if (oil.containsKey(oilIdx)) {
                return true;
            }
            return false;
        }
    }
    
    public int solution(int[][] land) {
        int row = land.length;
        int col = land[0].length;
        visited = new boolean[row][col];
        int answer = 0;

        for (int i = 0; i < col; i++) {
            List<Integer> throwOil = new ArrayList<>();
            for (int j = 0; j < row; j++) {
                if (land[j][i] == 1 && !visited[j][i]) {
                    int volume = dfs(land, j, i);
                    oilVolume.put(oilIndex, volume);
                    oilIndex += 1;
                }

                if (land[j][i] != 0 && !throwOil.contains(land[j][i])) {
                    throwOil.add(land[j][i]);
                }
            }
            int tmp = 0;
            for (int temp : throwOil) {
                tmp += oilVolume.get(temp);
            }
            if (answer < tmp) {
                answer = tmp;
            }
        }
        return answer;
    }
    
    private int dfs(int[][] land, int y, int x) {
        int volume = 1;
        visited[y][x] = true;
        land[y][x] = oilIndex;
        oilInfo.addOil(new Pos(y, x), oilIndex);

        for (int i = 0; i < 4; i++) {
            int dy = y + d[i];
            int dx = x + d[3-i];

            if (dy >= 0 && dy < land.length && dx >= 0 && dx < land[0].length) {
                if (!visited[dy][dx] && land[dy][dx] == 1) {
                    volume += dfs(land, dy, dx);
                }
            }
        }
        return volume;
    }
}