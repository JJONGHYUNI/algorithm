import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //왼쪽 index, 오른쪽 index, 지운 개수
        int l = 0 ,r = 0, remove = 0;
        int max = -1;

        // r == n이 되면 끝까지 돈거
        while (r < n) {
            // 아직 k개 이하로 지웠으면
            if (remove <= k) {
                //현재 r 값이 홀수면 지운 갯수 추가
                if (arr[r] % 2 != 0) {
                    remove += 1;
                }
                r += 1;
                // l부터 r 까지 길이에서 제거한 홀수 개수 빼기
                max = Math.max(max, r - l - remove);
                continue;
            }

            // k개가 넘었으면 l 값 올리면서 이전 l 값이 홀수면 지운 갯수 줄여주기
            if (arr[l] % 2 != 0) {
                remove -= 1;
            }
            l += 1;
        }
        System.out.println(max);
    }
}
