import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int answer = -1;
    //0 5 , 1 3 , 2 4
    static int[] d = new int[] {5, 3, 4, 1, 2, 0};

    static class Dice {
        int[] nums;

        public Dice(int[] nums) {
            this.nums = nums;
        }
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        if (n == 0) {
            System.out.print(0);
            return;
        }
        List<Dice> dices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int[] dice = new int[6];
            for (int j = 0; j < 6; j++) {
                dice[j] = Integer.parseInt(st.nextToken());
            }

            dices.add(new Dice(dice));
        }

        for (int i = 0; i < 6; i++) {
            int sum = 0;
            // 윗면, 아랫면
            int up = dices.get(0).nums[i];
            int down = dices.get(0).nums[d[i]];
            sum += maxSideNum(up, down);
            for (int j = 1; j < n; j++) {
                for (int k = 0; k < 6; k++) {
                    if (dices.get(j).nums[k] == up) {
                        down = dices.get(j).nums[k];
                        up = dices.get(j).nums[d[k]];
                        sum += maxSideNum(up, down);
                        break;
                    }
                }
            }

            answer = Math.max(answer, sum);
        }

        System.out.print(answer);
    }

    //위 아래 제외한 옆면의 최대 값 구하기
    private static int maxSideNum(int up, int down) {
        int tmp = 0;
        for (int i = 1; i <= 6; i++) {
            if (i == up || i == down) {
                continue;
            }

            tmp = Math.max(tmp, i);
        }

        return tmp;
    }
}