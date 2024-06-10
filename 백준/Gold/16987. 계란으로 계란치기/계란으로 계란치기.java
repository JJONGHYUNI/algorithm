
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
class Main {
    static class Egg {
        int durability;
        int weight;

        public Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }
    }

    static int n;
    static List<Egg> eggs = new ArrayList<Egg>();
    static int answer = -1;
    static boolean[] brokens;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        eggs = new ArrayList<Egg>();
        brokens = new boolean[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int durability = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            eggs.add(new Egg(durability, weight));
        }

        dfs(0, 0);
        System.out.print(answer);
    }

    private static void dfs(int depth, int brokenNum) {
        if (depth == n || brokenNum == n - 1) {
            answer = Math.max(answer, brokenNum);
            return;
        }

        if (brokens[depth]) {
            dfs(depth + 1, brokenNum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (i == depth || brokens[i]) {
                continue;
            }

            int cnt = 0;

            eggs.get(depth).durability -= eggs.get(i).weight;
            eggs.get(i).durability -= eggs.get(depth).weight;

            if (eggs.get(i).durability <= 0) {
                brokens[i] = true;
                cnt += 1;
            }

            if (eggs.get(depth).durability <= 0) {
                brokens[depth] = true;
                cnt += 1;
            }

            dfs(depth + 1, brokenNum + cnt);
            brokens[depth] = false;
            brokens[i] = false;
            eggs.get(depth).durability += eggs.get(i).weight;
            eggs.get(i).durability += eggs.get(depth).weight;
        }
    }
}