class Solution {
    public int solution(String dirs) {
        int answer = 0;
        boolean[][][] map = new boolean[11][11][4];
        int[] d = {0, -1, 1};
        String[] strings = dirs.split("");
        int y = 5;
        int x = 5;
        for(String s : strings) {
            int dy = 0, dx = 0, in = 0, re = 0;
            switch(s) {
                case "U":
                    dy = y + d[2];
                    dx = x + d[0];
                    in = 0;
                    re = 3;
                    break;
                case "L":
                    dy = y + d[0];
                    dx = x + d[1];
                    in = 1;
                    re = 2;
                    break;
                case "R":
                    dy = y + d[0];
                    dx = x + d[2];
                    in = 2;
                    re = 1;
                    break;
                case "D":
                    dy = y + d[1];
                    dx = x + d[0];
                    in = 3;
                    re = 0;
                    break;
            }
            if(dy >= 0 && dy <= 10 && dx >= 0 && dx<=10) {
                if(!map[y][x][in]) {
                    answer += 1;
                    map[y][x][in] = true;
                    map[dy][dx][re] = true;
                }
                y = dy;
                x = dx;
            }
        }
        return answer;
    }
}