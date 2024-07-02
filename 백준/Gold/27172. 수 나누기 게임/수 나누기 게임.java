import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    // 3 4 무승부
    // 3 12 3 : + 1, 12 : -1
    // 4 12 4 : + 1, 12 : -1
    //배수만 보기

    static class Player {
        int idx, card, point;

        public Player(int idx, int card, int point) {
            this.idx = idx;
            this.card = card;
            this.point = point;
        }
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        List<Player> players = new ArrayList<>();
        int maxCard = -1;

        st = new StringTokenizer(br.readLine());
        int card;
        boolean[] cards = new boolean[1_000_001];
        //카드 번호 , 인덱스
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            card = Integer.parseInt(st.nextToken());
            cards[card] = true;
            maxCard = Math.max(maxCard, card);
            players.add(new Player(i, card, 0));
            map.put(card, i);
        }

        for (Player player : players) {
            for (int j = player.card * 2; j <= maxCard; j += player.card) {
                if (cards[j]) {
                    player.point += 1;
                    players.get(map.get(j) - 1).point -= 1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        for (Player player : players) {
            sb.append(player.point).append(" ");
        }
        System.out.print(sb);
    }
}