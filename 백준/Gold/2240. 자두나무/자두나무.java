import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] arr = new int[t + 1];
        arr[0] = 1;
        for (int i = 1; i <= t; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // t 는 시간, w는 움직인 횟수, 3 은 현재 위치
        int[][][] dp = new int[t + 1][w + 1][3];

        if (arr[1] == 1) {
            dp[1][0][1] = 1;
            dp[1][1][2] = 0;
        } else {
            dp[1][0][1] = 0;
            dp[1][1][2] = 1;
        }

        for (int i = 2; i <= t; i++) {
            // t초에 1에서 떨어지면
            if (arr[i] == 1) {
                //아예 안움직였을 때 (이전에도)
                dp[i][0][1] = dp[i - 1][0][1] + 1;

                // 이전에 있었던 곳들에 따라
                for (int j = 1; j <= w; j++) {
                    // 현재 위치 1번인데 1번에 떨어졌으므로 +1 , 이전 값은 안 움직인 (j가 그대로)와 움직이기전 값의 2번 위치 값 중 최댓값
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][2]) + 1;
                    // 현재 위치 2번인데 1번에 떨어졌으므로 +없음, 이전 값은 안 움직인 2번 위치 값과 움직이기전 1번 위치 값 중 최댓값
                    dp[i][j][2] = Math.max(dp[i - 1][j - 1][1], dp[i - 1][j][2]);
                }
                continue;
            }
            
            for (int j = 1; j <= w; j++) {
                dp[i][j][1] = Math.max(dp[i - 1][j - 1][2], dp[i - 1][j][1]);
                dp[i][j][2] = Math.max(dp[i - 1][j][2], dp[i - 1][j - 1][1]) + 1;
            }
        }
        int answer = 0;
        for (int i = 0; i <= w; i++) {
            answer = Math.max(answer, Math.max(dp[t][i][1], dp[t][i][2]));
        }
        
        System.out.println(answer);
    }
}