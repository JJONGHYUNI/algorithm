import java.util.*;
import java.io.*;

class Solution {
    class Status {
        int tired, cnt;
        
        public Status(int tired, int cnt) {
            this.tired = tired;
            this.cnt = cnt;
        }
    }
    
    boolean[] visited;
    int answer = -1;
    int len;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        len = dungeons.length;
        dfs(new Status(k, 0), dungeons);
        return answer;
    }
    
    private void dfs(Status status, int[][] dungeons) {
        
        answer = Math.max(answer, status.cnt);
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i] || status.tired < dungeons[i][0]) {
                continue;
            }
            
            visited[i] = true;
            dfs(new Status(status.tired - dungeons[i][1], status.cnt + 1), dungeons);
            visited[i] = false;
        }
    }
}